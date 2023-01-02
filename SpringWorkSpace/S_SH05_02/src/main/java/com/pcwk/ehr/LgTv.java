package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lgTv")
public class LgTv implements Tv {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
//	@Autowired
//	@Qualifier("apple")
	
	@Autowired
	private Speaker speaker;
	
	final String brand = "LG TV";

	public LgTv () {
		LOG.debug(brand+" default 생성자");
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
		//LOG.debug(brand+" 볼륨을 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumnDown() {
		//LOG.debug(brand+" 볼륨을 내린다.");
		speaker.volumeDown();
	}

}
