package com.jiesoon;

import org.json.JSONException;
import org.json.JSONObject;

public class BusPosMessage extends Message {
	private JSONObject mObject;
	
	public void buildBusPos(double x, double y, String stopName, String track, String id){
		try {
			
			mObject = new JSONObject();
			
			mObject.put("_commandId", MSG_BUS_POS);
			mObject.put("_x", x);
			mObject.put("_y", y);
			mObject.put("_stopName", stopName);
			mObject.put("_track", track);
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
