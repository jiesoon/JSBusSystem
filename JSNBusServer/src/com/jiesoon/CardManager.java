package com.jiesoon;

import java.util.ArrayList;

public class CardManager {
	private ArrayList<Card> mManager;
	
	public CardManager(){
		mManager = new ArrayList<Card>();
	}
	
	public int size(){
		return mManager.size();
	}
	
	public String genId(){
		int id = -1;
		for(Card c: mManager){
			if(Integer.parseInt(c.mId) > id){
				id = Integer.parseInt(c.mId);
			}
		}
		
		return String.valueOf(id + 1);
	}
	
	public void add(Card card){
		if(card != null){
			mManager.add(card);
		}
	}
	
	public Card find(String id){
		for(Card card: mManager){
			if(card.mId.equals(id)){
				return card;
			}
		}
		
		return null;
	}
	
	public void edit(String id, Card card){
		Card target = find(id);
		if(target != null){
			target.mId = card.mId;
			target.mName = card.mName;
			target.mMoney = card.mMoney;
			target.mBirthday = card.mBirthday;
			target.mGender = card.mGender;
		}
		
	}
	
	public void delete(String id){
		Card target = find(id);
		if(target != null){
			mManager.remove(target);
		}
		
	}
}
