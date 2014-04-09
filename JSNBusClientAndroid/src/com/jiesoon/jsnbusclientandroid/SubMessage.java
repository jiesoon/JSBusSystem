package com.jiesoon.jsnbusclientandroid;

import org.json.JSONException;
import org.json.JSONObject;

public class SubMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(String cardId, int money){
		mObject = new JSONObject();
		
		try {
			mObject.put("_commandId", MSG_SUB);
			mObject.put("_cardId", cardId);
			mObject.put("_money", money);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		if(mObject != null){
			return mObject.toString();
		}
		
		return null;
	}
	
	
}
