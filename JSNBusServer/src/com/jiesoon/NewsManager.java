package com.jiesoon;

import java.util.ArrayList;
import java.util.Date;

public class NewsManager {
	private ArrayList<News> mManager;
	
	public NewsManager(){
		mManager = new ArrayList<News>();
	}
	
	public void init(){
		mManager.add(new News(new Date(), "习近平视察武警特警学院 为猎鹰突击队授旗"));
		mManager.add(new News(new Date(), "四川原副省长郭永祥受贿为子谋利 最高检立案"));
		mManager.add(new News(new Date(), "网络世界陷入最大危机：OpenSSL曝重大安全漏洞"));
		mManager.add(new News(new Date(), "美防长：中美舰长曾在东海隔空畅谈 互问晚餐吃啥"));
	}
	
	public int size(){
		return mManager.size();
	}
	
	public void add(News news){
		if(news != null){
			mManager.add(news);
		}
	}
	
	public News find(String content){
		for(News news: mManager){
			if(news.mContent.equals(content)){
				return news;
			}
		}
		
		return null;
	}
	
	public String getAllNews(){
		String allNews = null;
		
		for(News nw: mManager){
			allNews += nw.mContent;
			allNews += "|";
		}
		
		return allNews;
	}
	
	public void edit(String id, News news){
		News target = find(id);
		if(target != null){
			target.mDate = news.mDate;
			target.mContent = news.mContent;
		}
		
	}
	
	public void delete(String id){
		News target = find(id);
		if(target != null){
			mManager.remove(target);
		}
		
	}
}
