package com.jiesoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

public class BusServer {

	public static String getStopsByGPS(double x, double y){
		//calculate stop name by (x,y)
		String stops = null;
		
		stops = "天安门东站,天安门西站";
		
		return stops;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<String, JSONObject> oBuses = new HashMap<String, JSONObject>();
		//ArrayList<Messenger> oMessengers = new ArrayList<Messenger>();
		
		BusManager bm = new BusManager();
		CardManager cm = new CardManager();
		NewsManager nm = new NewsManager();
		
		cm.init();
		nm.init();
		try {
			
			ServerSocket serverSocket = new ServerSocket(7798);
			
			while(true){
				Socket conn = serverSocket.accept();
				
				InputStream in = conn.getInputStream();
				OutputStream out = conn.getOutputStream();
				
				while(true){
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
					
					String line = reader.readLine();
					System.out.println("line = " + line);				
	
					if(line == null || line.equals("quit")){
						break;
					}
					
					JSONObject o = new JSONObject(line);
					
					int commandId = o.getInt("_commandId");
					switch(commandId){
						case Message.MSG_BUS_START:
							//BusManager add a new bus.
							String id = o.getString("_id");
							String track = o.getString("_track");
							double x = o.getDouble("_x");
							double y = o.getDouble("_y");
							
							Bus bus = new Bus(id, track, x, y);
							bm.add(bus);
							
							break;
						case Message.MSG_BUS_STOP:
							id = o.getString("_id");
							
							bm.delete(id);
							break;
						case Message.MSG_BUS_POS:
							
							track = o.getString("_track");
							String stopName = o.getString("_stopName");
							id = o.getString("_id");
							x = o.getDouble("_x");
							y = o.getDouble("_y");
							
							oBuses.put(id, o);							
							System.out.println(track + "|" + stopName + "|" + id + "|" + x + "|" + y);
							break;
						case Message.MSG_REGISTER:
							String name = o.getString("_name");
							String gender = o.getString("_gender");
							String birthDay = o.getString("_birthDay");
							int money = o.getInt("_money");
							
							RegisterRes res = new RegisterRes();

							if(name != null && name.length() > 0 &&
									gender != null && gender.length() > 0 &&
									birthDay != null && birthDay.length() > 0 && 
									money > 0){

								Card card = new Card();
								
								card.mBirthday = birthDay;
								card.mGender = gender;
								card.mMoney = money;
								card.mName = name;
								card.mId = cm.genId();
								cm.add(card);
								System.out.println("CardManager.size: " + cm.size());
								
								res.buildRes("200", "OK");
								
							}
							else{
								res.buildRes("400", "Invalid register message");
							}
							
							writer.write(res.toString());
							writer.newLine();
							writer.flush();
							
							System.out.println(name + "|" + gender + "|" + birthDay + "|" + money);
							break;
						case Message.MSG_UNREGISTER:
							String userId = o.getString("_userId");
							cm.delete(userId);
							System.out.println("CardManager.size: " + cm.size());

							break;
							
						case Message.MSG_STOPS_BY_GPS:
							double xPos = 0.0f;
							double yPos = 0.0f;
							
							xPos = o.getDouble("_x");
							yPos = o.getDouble("_y");

							StopsByPosRes resStops = new StopsByPosRes();

							String stops = getStopsByGPS(xPos, yPos);
							if(stops != null && stops.length() > 0){
								resStops.buildRes("200", stops);
								
							}
							else{
								resStops.buildRes("400", "Invalid stop name!");
							}

							writer.write(resStops.toString());
							writer.newLine();
							writer.flush();

							break;
							
						case Message.MSG_ADD:
							String cardId = o.getString("_cardId");
							money = o.getInt("_money");
							
							AddRes ar = new AddRes();
							Card result = cm.find(cardId);
							if(result == null){
								ar.buildRes("400", "Not a valid card!");
							}
							else{
								ar.buildRes("200", "OK");
								
								result.show();
								result.add(money);
								result.show();
							}
							
							writer.write(ar.toString());
							writer.newLine();
							writer.flush();
							
							break;
							
						case Message.MSG_SUB:
							cardId = o.getString("_cardId");
							money = o.getInt("_money");
							
							SubRes sr = new SubRes();
							
							result = cm.find(cardId);
							if(result == null){
								sr.buildRes("400", "Invalid card!");
							}
							else{
								sr.buildRes("200", "OK");
								result.sub(money);
							}
							
							writer.write(sr.toString());
							writer.newLine();
							writer.flush();
							
							break;
							
						case Message.MSG_NEWS:
							String allNews = nm.getAllNews();
							NewsRes nr = new NewsRes();
							
							if(allNews != null){
								nr.buildRes("200", allNews);
							}
							else{
								nr.buildRes("400", null);
							}
							
							writer.write(nr.toString());
							writer.newLine();
							writer.flush();
							
							break;
						default:
							;
					}
					
				}
	
				
				conn.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
