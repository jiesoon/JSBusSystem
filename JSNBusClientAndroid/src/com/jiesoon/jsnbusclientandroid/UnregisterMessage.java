package com.jiesoon.jsnbusclientandroid;

import org.json.JSONException;
import org.json.JSONObject;

public class UnregisterMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(String id){
		mObject = new JSONObject();
		
		try {
			mObject.put("_commandId", MSG_UNREGISTER);
			mObject.put("_userId", id);
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
