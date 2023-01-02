package com.pcwk.ehr.cmn;

public class MessageVO extends DTO {
	
	private String msgId; //메세지 ID
	private String msgContents; //메세지
	
	public MessageVO () {}

	public MessageVO(String msgId, String msgContents) {
		super();
		this.msgId = msgId;
		this.msgContents = msgContents;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	@Override
	public String toString() {
		return "MessageVO [mesId=" + msgId + ", msgContents=" + msgContents + "]";
	}
	
	
	
}
