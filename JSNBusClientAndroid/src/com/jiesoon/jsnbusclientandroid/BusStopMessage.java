package com.jiesoon.jsnbusclientandroid;

import org.json.JSONException;
import org.json.JSONObject;

public class BusStopMessage extends Message {
	private JSONObject mObject;
	
	public void buildMsg(String id, String track, double x, double y){
		try {
			mObject = new JSONObject();
			mObject.put("_commandId", Message.MSG_BUS_STOP);
			
			mObject.put("_id", id);

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
