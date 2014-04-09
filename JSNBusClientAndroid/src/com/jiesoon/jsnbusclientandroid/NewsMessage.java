package com.jiesoon.jsnbusclientandroid;

import org.json.JSONException;
import org.json.JSONObject;

public class NewsMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(){
		mObject = new JSONObject();
		
		try {
			mObject.put("_commandId", MSG_NEWS);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
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
