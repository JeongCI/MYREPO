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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	//50,30 대한 상수 도입
	//최소 로그인 수 실버로 등업 : 50
	public final static int MIN_LOGIN_COUNT_FOR_SILVER = 50;
	//최소 추천 수 골드로 등업 : 30
	public final static int MIN_RECOMMEND_COUNT_FOR_GOLD = 30;
	
	@Autowired
	private UserDao userDao;
	
	//MailSender를 구현한 class가 2개 있다.
//	@Autowired
//	@Qualifier("dummyMailSender")
	@Resource(name = "dummyMailSender")
	private MailSender mailSender;
	
	public UserServiceImpl() {}
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	//1. 업그레이드 대상 확인
	public boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();
		
		switch (currentLevel) {
		//레벨별로 구분해서 등업 조건을 판별한다.
		case BASIC: return(user.getLogin() >= MIN_LOGIN_COUNT_FOR_SILVER);
		case SILVER: return(user.getRecommend() >= MIN_RECOMMEND_COUNT_FOR_GOLD);
		case GOLD: return false;
		default: throw new IllegalArgumentException("Unknown Level: "+currentLevel);
		}
	}
	
	//업그레이드
	public void upgradeLevel(UserVO user) throws SQLException {
//		if("p11_04".equals(user.getuId())) {
//			throw new TestUserServiceException("트랜잭션 테스트: "+user.getuId());
//		}
		
		user.upgradeLevel();
		userDao.doUpdate(user);
		sendUpgradeEmail(user); //등업되면 메일 전송
	}
	
	private void sendUpgradeEmail(UserVO user) {

			LOG.debug("┌───────────────────────────────────────────┐");
			LOG.debug("│sendUpgradeEmail: "+user.getEmail()+","+user.getName());
			LOG.debug("└───────────────────────────────────────────┘");
//			MimeMessage mail = this.mailSender.createMimeMessage();
//			MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
//			
//			//mail인증 주소와 동일
//			mailHelper.setFrom("jci1203@naver.com"); //보내는 사람
//			mailHelper.setTo(user.getEmail()); //받는 사람
//			//mailHelper.setSubject("등업안내!");
//			//mailHelper.setText("사용자의 등급이 "+user.getLevel().name()+"로 업그레이드 되었습니다.");
//			mailHelper.setSubject("바보");
//			mailHelper.setText("오점뭐?");
//			
//			mailSender.send(mail);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("jci1203@naver.com"); //보내는 사람
			message.setTo(user.getEmail()); //받는 사람
			message.setSubject("바보");
			message.setText("오점뭐?");
			
			mailSender.send(message);
	}

	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
		try {
			//1. 대상 사용자 조회
			List<UserVO> allUser = userDao.getAll(inVO);
			//2.
			for(UserVO vo : allUser) {
				//2.1. 등업 대상자 추출
				if(canUpgradeLevel(vo) == true) {
					//등업
					upgradeLevel(vo);
				}
			}
		} catch (Exception e) {
			LOG.debug("┌───────────────────────────────────────────┐");
			LOG.debug("│rollback: "+e.getMessage());
			LOG.debug("└───────────────────────────────────────────┘");
			throw e;
		}
	}

	@Override
	public int add(UserVO inVO) throws SQLException {
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
	public List<UserVO> doRetrieve(DTO inVO) throws SQLException {
		return userDao.doRetrieve(inVO);
	}

	@Override
	public int getCount(UserVO inVO) throws SQLException {
		return userDao.getCount(inVO);
	}

	@Override
	public int idCheck(UserVO inVO) throws SQLException {
		return userDao.idCheck(inVO);
	}

}
