package com.jiesoon;

import org.json.JSONObject;

public class StopsByPosRes {
	private JSONObject mObject;

	public void buildRes(String status, String stops) {
		mObject = new JSONObject();
		
		mObject.put("_status", status);
		mObject.put("_stops", stops);
	}

	@Override
	public String toString() {
		if(mObject != null){
			return mObject.toString();
		}
		
		return null;
	}
	
	

}
