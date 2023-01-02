package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SamsungTV implements Tv {
   
   final Logger LOG = LogManager.getLogger(getClass());
   
   final String brand = "삼성 TV";
   
   private Speaker speaker;
   private int price;
   
   public SamsungTV() {
      LOG.debug(brand+" default생성자!");
   }
   
   //생성자 injection
   public SamsungTV(Speaker speaker) {
	   super();
	   this.speaker = speaker;
   }

   public SamsungTV(Speaker speaker, int price) {
	   super();
	   this.speaker = speaker;
	   this.price = price;
	   
	   LOG.debug("SamsungTV() price: "+price);
   }

   public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
   }
   
   public void setPrice(int price) {
	   this.price = price;
   }

//초기화 메서드
   public void initMethod() {
      LOG.debug(brand+" initMethod() 메서드!");
   }
   
   //자원 반납
   public void destroyMethod() {
      LOG.debug(brand+" destroyMethod() 메서드!");
   }
   
   @Override
   public void powerOn() {
      LOG.debug(brand+" 전원을 켠다.");
   }

   @Override
   public void powerOff() {
      LOG.debug(brand+" 전원을 끈다.");
   }

   @Override
   public void volumnUp() {
	   this.speaker.volumeUp();
      LOG.debug(brand+" 볼륨을 높힌다. 가격은 : "+price);
   }

   @Override
   public void volumnDown() {
	   this.speaker.volumeDown();
      LOG.debug(brand+" 볼륨을 낮춘다.");
   }

}