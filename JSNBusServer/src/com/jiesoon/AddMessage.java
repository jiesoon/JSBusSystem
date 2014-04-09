package com.jiesoon;

import org.json.JSONObject;

public class AddMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(String cardId, int money){
		mObject = new JSONObject();
		
		mObject.put("_commandId", MSG_ADD);
		mObject.put("_cardId", cardId);
		mObject.put("_money", money);
		
	}

	@Override
	public String toString() {
		if(mObject != null){
			return mObject.toString();
		}
		
		return null;
	}
	
	
}
