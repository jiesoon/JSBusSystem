package com.jiesoon;

import org.json.JSONObject;

public class NewsMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(){
		mObject = new JSONObject();
		
		mObject.put("_commandId", MSG_NEWS);
		
	}
}
