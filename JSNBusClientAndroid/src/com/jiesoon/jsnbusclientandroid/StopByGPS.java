package com.jiesoon.jsnbusclientandroid;

import org.json.JSONException;
import org.json.JSONObject;

public class StopByGPS extends Message {
	private JSONObject mObject;
	
	public void buildMsg(double x, double y){
		mObject = new JSONObject();
		
		try {
			mObject.put("_commandId", Message.MSG_STOPS_BY_GPS);
			mObject.put("_x", x);
			mObject.put("_y", y);
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
