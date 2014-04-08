package com.jiesoon.jsnbusclientandroid;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(String name, String gender, String birthDay, double money){
		
		mObject = new JSONObject();
		
		try {
			mObject.put("_commandId", MSG_REGISTER);
			mObject.put("_name", name);
			mObject.put("_gender", gender);
			mObject.put("_birthDay", birthDay);
			mObject.put("_money", money);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		if(mObject != null)
			return mObject.toString();
		return null;
	}
	
	
}
