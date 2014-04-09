package com.jiesoon;

public class Card {

	public String mId;
	public String mName;
	public int mMoney;
	public String mBirthday;
	public String mGender;
	
	public Card(){
		
	}
	
	public Card(String id, String name, int money, String birthday, String gender){
		mId = id;
		mName = name;
		mMoney = money;
		mBirthday = birthday;
		mGender = gender;
	}
	
	public void add(int money){
		mMoney += money;
	}
	
	public void sub(int money){
		mMoney -= money;
	}
	
	public void show(){
		System.out.println(mId + "|" + mName + "|" + mMoney);
	}

}
