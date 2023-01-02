package com.pcwk.ehr.user.domain;

import com.pcwk.ehr.cmn.DTO;

public class UserVO extends DTO {
   private String uId; // 사용자 아이디
   private String name; // 이름
   private String passwd; // 비밀번호

   private Level level;
   private int login;
   private int recommend;
   private String email;
   private String regDt;

   // mybatis levle -> int
   private int intLevel;

   public UserVO() {}

   public UserVO(String uId, String name, String passwd, Level level, int login, int recommend, String email,
         String regDt) {
      super();
      this.uId = uId;
      this.name = name;
      this.passwd = passwd;
      this.level = level;
      this.login = login;
      this.recommend = recommend;
      this.email = email;
      this.regDt = regDt;

      // mybatis levle -> int
      intLevel = level.getValue();
   }
   // mybatis levle -> int
   public int getIntLevel() {
      return intLevel;
   }
   // mybatis levle -> int
   public void setIntLevel(int intLevel) {
      
      this.intLevel = intLevel;
      
      //mybatis -> DAO
      this.level = Level.valueOf(intLevel);
   }

   public String getuId() {
      return uId;
   }

   public void setuId(String uId) {
      this.uId = uId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPasswd() {
      return passwd;
   }

   public void setPasswd(String passwd) {
      this.passwd = passwd;
   }

   public Level getLevel() {
      return level;
   }

   public void setLevel(Level level) {
      this.level = level;
      
      //inLevel
      if(null != level) {
         this.intLevel = level.getValue();
      }
      
   }

   public int getLogin() {
      return login;
   }

   public void setLogin(int login) {
      this.login = login;
   }



   public int getRecommend() {
      return recommend;
   }

   public void setRecommend(int recommend) {
      this.recommend = recommend;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getRegDt() {
      return regDt;
   }

   public void setRegDt(String regDt) {
      this.regDt = regDt;
   }


	   @Override
	public String toString() {
		return "UserVO [uId=" + uId + ", name=" + name + ", passwd=" + passwd + ", level=" + level + ", login=" + login
				+ ", recommend=" + recommend + ", email=" + email + ", regDt=" + regDt + ", intLevel=" + intLevel + "]";
	}

public void upgradeLevel() {
      Level nextLevel = this.level.nextLevel();
      if (null == nextLevel) {
         throw new IllegalArgumentException(this.level + "더이상 등업이 불가능!");
      } else {
         this.level = nextLevel;
         //mybatis 등록위해 추가
         this.intLevel = nextLevel.getValue();
      }

   }

}