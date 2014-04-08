package com.jiesoon;

import java.util.ArrayList;

public class BusManager {
	private ArrayList<Bus> mManager;
	
	public BusManager(){
		mManager = new ArrayList<Bus>();
	}
	
	public int size(){
		return mManager.size();
	}
	

	
	public void add(Bus bus){
		if(bus != null){
			mManager.add(bus);
		}
	}
	
	public Bus find(String id){
		for(Bus bus: mManager){
			if(bus.mId.equals(id)){
				return bus;
			}
		}
		
		return null;
	}
	
	public void edit(String id, Bus bus){
		Bus target = find(id);
		if(target != null){
			target.mId = bus.mId;
			target.mTrack = bus.mTrack;
			target.mX = bus.mX;
			target.mY = bus.mY;
		}
		
	}
	
	public void delete(String id){
		Bus target = find(id);
		if(target != null){
			mManager.remove(target);
		}
		
	}
}

