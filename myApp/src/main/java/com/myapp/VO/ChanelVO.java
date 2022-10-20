package com.myapp.VO;

import java.io.Serializable;

public class ChanelVO implements Serializable {
	
	private String chanel;
	private String chanelMaker;
		
	public String getChanel() {
		return chanel;
	}

	public void setChanel(String chanel) {
		this.chanel = chanel;
	}

	public String getChanelMaker() {
		return chanelMaker;
	}

	public void setChanelMaker(String chanelMaker) {
		this.chanelMaker = chanelMaker;
	}
	
}