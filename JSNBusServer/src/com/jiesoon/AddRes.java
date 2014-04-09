package com.jiesoon;

import org.json.JSONObject;

public class AddRes {
	private JSONObject mObject;
	public void buildRes(String status, String description){
		mObject = new JSONObject();
		
		mObject.put("_status", status);
		mObject.put("_description", description);
	}
	
	@Override
	public String toString() {
		if(mObject != null){
			return mObject.toString();
		}
		
		return null;
	}
	
	
}
