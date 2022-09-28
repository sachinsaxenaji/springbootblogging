package com.dropdownajex.exception;

public class ApiResponce {
	
	private String msgString;
	private boolean sucess;
	
	
	public ApiResponce(String msgString, boolean sucess) {
		super();
		this.msgString = msgString;
		this.sucess = sucess;
	}
	public String getMsgString() {
		return msgString;
	}
	public void setMsgString(String msgString) {
		this.msgString = msgString;
	}
	public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	
	
}
