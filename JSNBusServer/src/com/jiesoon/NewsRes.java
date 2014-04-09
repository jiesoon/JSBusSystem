package com.jiesoon;

import org.json.JSONObject;

public class NewsRes {
	private JSONObject mObject;
	public void buildRes(String status, String news){
		mObject = new JSONObject();
		
		mObject.put("_status", status);
		mObject.put("_news", news);
	}
	
	@Override
	public String toString() {
		if(mObject != null){
			return mObject.toString();
		}
		
		return null;
	}
	
	
}