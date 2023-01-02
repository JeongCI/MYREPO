package com.pcwk.ehr.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.LevelPieVO;
import com.pcwk.ehr.user.domain.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	//log
	final Logger LOG = LogManager.getLogger(getClass());
	
	//50,30에 대한 상수 도입
	//최소 로그인 수 실버로 등업: 50
	public final static int MIN_LOGIN_COUNT_FOR_SILVER = 50;
	
	//최소 추천 수 골드로 등업: 30
	public final static int MIN_RECOMMEND_COUNT_FOR_GOLD = 30;
	
	@Autowired
	private UserDao userDao;
	
	//MailSender를 구현한 class가 2개가 있다.
	/*
	 * Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
	 * No qualifying bean of type 'org.springframework.mail.MailSender' available: 
	 * expected single matching bean but found 2: mailSenderImpl,dummyMailSender
	 */
	
	//@Autowired
	//@Qualifier("dummyMailSender")
	@Resource(name = "dummyMailSender")
	private MailSender mailSender;
	
	public UserServiceImpl() {}
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	/*
	 * -코드에 중복된 부분은 없는가?
	 * -코드가 무엇을 하는지 이해하기 불편하지 않는가?
	 * -코드가 자신이 있어야할 자리에 있는가?
	 * -앞으로 변경이 일어난다면 어떤 것이 있을 수 있고, 그 변환에 쉽게 대응할수 있게 작성되어 있는가?
	 */	
	//1.업그레이대 대상 확인
	private boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();
		
		switch (currentLevel) {
		//레벨별로 구분해서 등업 조건을 판별한다.
		case BASIC: return (user.getLogin()>=MIN_LOGIN_COUNT_FOR_SILVER);
		case SILVER: return (user.getRecommend() >=MIN_RECOMMEND_COUNT_FOR_GOLD);
		case GOLD : return false;
		default: throw new IllegalArgumentException("Unknown Level:"+currentLevel);
		
		}
	}
	
	//업그레이드
	public void upgradeLevel(UserVO user) throws SQLException {
        //p99_04
		
		user.upgradeLevel();
		userDao.doUpdate(user);
		sendUpgradeEmail(user);//등업 되면 메일 전송!
	}
	
	private void sendUpgradeEmail(UserVO user) {

			LOG.debug("┌-------------------------------------------┐");
			LOG.debug("|sendUpgradeEmail:"+user.getEmail()+","+user.getName());
			LOG.debug("└-------------------------------------------┘");					
//			MimeMessage mail = this.mailSender.createMimeMessage();
//			MimeMessageHelper mailHelper=new MimeMessageHelper(mail,"UTF-8");
//			
//			//mail인증 주소와 동일
//			mailHelper.setFrom("jamesol@naver.com");//보내는 사람
//			
//			mailHelper.setTo(user.getEmail());//받는 사람
//			mailHelper.setSubject("등업안내!");//제목
//			mailHelper.setText("사용자의 등급이 "+user.getLevel().name()+"로 업그레이드 되었습니다. ");
//			
//			
//			mailSender.send(mail);
			
			
			SimpleMailMessage  message=new SimpleMailMessage();
			message.setFrom("jamesol@naver.com");//보내는 사람
			
			message.setTo(user.getEmail());//받는 사람
			message.setSubject("등업안내!");//제목
			message.setText("사용자의 등급이 "+user.getLevel().name()+"로 업그레이드 되었습니다. ");			
			
			mailSender.send(message);

	}
	
	
	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
		
		try {
			//1.
			List<UserVO> allUser = userDao.getAll(inVO);
			//2.
			for(UserVO vo :allUser) {
				//2.1. 등업 대상자 추출
				if(canUpgradeLevel(vo) == true) {
				//등업 
				   upgradeLevel(vo);	
				}
			}	
		
		}catch(Exception e) {
			LOG.debug("┌-------------------------------------------┐");
			LOG.debug("|rollback:"+e.getMessage());
			LOG.debug("└-------------------------------------------┘");
		
			throw e;
		}
		
	}

	@Override
	public int  add(UserVO inVO) throws SQLException {
		if(null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}
		
		return userDao.doSave(inVO);
	}

	@Override
	public int doDelete(UserVO inVO) throws SQLException {
		return userDao.doDelete(inVO);
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {
		return userDao.doUpdate(inVO);
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		return userDao.doSelectOne(inVO);
	}

	@Override
	public List<UserVO> doRetrive(DTO inVO) throws SQLException {
		return userDao.doRetrive(inVO);
	}

	@Override
	public int getCount(UserVO inVO) throws SQLException {
		return userDao.getCount(inVO);
	}

	@Override
	public int idCheck(UserVO inVO) throws SQLException {
		return userDao.idCheck(inVO);
	}

	@Override
	public int upDeleteAll(List<UserVO> users) throws SQLException {
		int cnt = 0;
		try {
		
			for(UserVO vo :users) {

				cnt+=userDao.doDelete(vo);
			}
			
		}catch(Exception e) {
			LOG.debug("┌-------------------------------------------┐");
			LOG.debug("|rollback:"+e.getMessage());
			LOG.debug("└-------------------------------------------┘");
			throw e;		
		}
		
		return cnt;
	}

	@Override
	public int idPassCheck(UserVO inVO) throws SQLException {
		
		int flag = userDao.idCheck(inVO);
		if( 1 != flag) {//id가 존재 하지 않음!
			LOG.debug("┌-------------------------------------------┐");
			LOG.debug("|id가 존재 하지 않음!");
			LOG.debug("└-------------------------------------------┘");			
			return 10;
		}
		
		flag = userDao.passCheck(inVO);
		if(1 != flag) {
			LOG.debug("┌-------------------------------------------┐");
			LOG.debug("|비번 불일치 !");
			LOG.debug("└-------------------------------------------┘");					
			return 20;
		}
		
		
		LOG.debug("┌-------------------------------------------┐");
		LOG.debug("|id/비번 일치 !");
		LOG.debug("└-------------------------------------------┘");			
		return 30;
	}

	@Override
	public List<LevelPieVO> levelPerMemberCount() throws SQLException {

		return userDao.levelPerMemberCount();
	}

}

