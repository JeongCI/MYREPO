package com.pcwk.ehr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정 정보라는 표시
@Configuration
public class DaoFactory {
	
	//오브젝트 생성을 담당하는 IoC용 메소드라는 표시
	@Bean
	public UserDao userDao() {
		//객체를 어떻게 만들지 결정하고, 돌려준다.
		//ConnectionMaker  connectionMaker = new NConnectionMaker();
		UserDao userDao = new UserDao(new NConnectionMaker());
		
		return userDao;
	}
	
}
