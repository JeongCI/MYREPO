package com.pcwk.ehr.cmn;

public class PcwkRuntimeException extends RuntimeException {

	private String returnURL = "";
	
	public PcwkRuntimeException(String msg) {
		super(msg);
	}

	public PcwkRuntimeException(String msg,String returnURL) {
		super();
		this.returnURL = returnURL;
	}
	
	
	
}
