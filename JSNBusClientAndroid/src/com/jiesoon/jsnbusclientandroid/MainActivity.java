package com.jiesoon.jsnbusclientandroid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String TAG = "BusClient";
	private Button mSend;
	private Button mOpen;
	private Button mClose;
	private Socket mClient;
	
	private Button mStartABus;
	private Button mStopABus;
	
	private Button mRegister;
	private Button mUnregister;
	
	private Button mAdd;
	private Button mSub;
	
	private Button mNews;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BusPosMessage posMsg = new BusPosMessage();
		//posMsg.buildBusPos(10.10039, 400.567, "天安门东站", "101", "京A7789");
		posMsg.buildBusPos(344.10039, 52.567, "大红门东站", "38", "京A7ABC");
		
		RegisterMessage registMsg = new RegisterMessage();
		registMsg.buildMsg("jiesoon", "male", "2011-7-7", 100);
		
		StopByGPS stopMessage = new StopByGPS();
		stopMessage.buildMsg(20.003, 6000.134);
		
		final String msg = stopMessage.toString();
		
		//final String msg = posMsg.toString();
		Log.d(TAG, "msg: " + msg);
		
		mSend = (Button)findViewById(R.id.main_send);
		mOpen = (Button)findViewById(R.id.main_open);
		mClose = (Button)findViewById(R.id.main_close);
		mStartABus = (Button)findViewById(R.id.main_start_bus);
		mStopABus = (Button)findViewById(R.id.main_stop_bus);
		mRegister = (Button)findViewById(R.id.main_register);
		mUnregister = (Button)findViewById(R.id.main_unregister);
		mAdd = (Button)findViewById(R.id.main_add);
		mSub = (Button)findViewById(R.id.main_sub);
		mNews = (Button)findViewById(R.id.main_news);

		mNews.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						BufferedWriter writer = null;
						BufferedReader reader = null;
						try {
							 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
							 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
						 
							 NewsMessage nm  = new NewsMessage();
							 nm.buildMsg();
							 
							 writer.write(nm.toString());
							 writer.newLine();
							 writer.flush();
							 
							 //waiting for data from server
							 String res = reader.readLine();
							 Log.d(TAG, "res: " + res.toString());
							 
						} catch (IOException e2) {
							e2.printStackTrace();
						}						
					}
				}).start();
				

				
				

			
			}
		});
		

		mSub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						BufferedWriter writer = null;
						BufferedReader reader = null;
						try {
							 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
							 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
						 
							 SubMessage addMsg = new SubMessage();
							 addMsg.buildMsg("1002", 1);
							 
							 writer.write(addMsg.toString());
							 writer.newLine();
							 writer.flush();
							 
							 //waiting for data from server
							 String res = reader.readLine();
							 Log.d(TAG, "res: " + res.toString());
							 
						} catch (IOException e2) {
							e2.printStackTrace();
						}						
					}
				}).start();
				

				
				

			
			}
		});
		
		mAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						BufferedWriter writer = null;
						BufferedReader reader = null;
						try {
							 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
							 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
						 
							 AddMessage addMsg = new AddMessage();
							 addMsg.buildMsg("1002", 115);
							 
							 writer.write(addMsg.toString());
							 writer.newLine();
							 writer.flush();
							 
							 //waiting for data from server
							 String res = reader.readLine();
							 Log.d(TAG, "res: " + res.toString());
							 
						} catch (IOException e2) {
							e2.printStackTrace();
						}						
					}
				}).start();
				

				
				

			
			}
		});
		
		mRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						BufferedWriter writer = null;
						BufferedReader reader = null;
						try {
							 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
							 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
						 
							 RegisterMessage registMsg = new RegisterMessage();
							 registMsg.buildMsg("jiesoon", "male", "2011-7-7", 100);
							 
							 writer.write(registMsg.toString());
							 writer.newLine();
							 writer.flush();
							 
							 //waiting for data from server
							 String res = reader.readLine();
							 Log.d(TAG, "res: " + res.toString());
							 
						} catch (IOException e2) {
							e2.printStackTrace();
						}						
					}
				}).start();
				

				
				

			}
		});
		
		mUnregister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BufferedWriter writer = null;
				BufferedReader reader = null;
				try {
					 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
					 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
				 
					 UnregisterMessage registMsg = new UnregisterMessage();
					 registMsg.buildMsg("0");
					 
					 writer.write(registMsg.toString());
					 writer.newLine();
					 writer.flush();
//					 
//					 //waiting for data from server
//					String res = reader.readLine();
//					Log.d(TAG, "res: " + res.toString());
					 
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		
		mOpen.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Thread(){

					@Override
					public void run() {
						try {
							mClient = new Socket("10.0.0.2", 7798);
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					
				}.start();
		
				
			}
		});
		
		mClose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mClient != null){
					try {
						mClient.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		mStartABus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BufferedWriter writer = null;
				BufferedReader reader = null;
				try {
					 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
					 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
					 
					 BusStartMessage bsm = new BusStartMessage();
					 bsm.buildMsg("京B7798", "101", 20.3343, 5000.6888);
					 String start = bsm.toString();
					 
					 writer.write(start);
					 writer.newLine();
					 writer.flush();
					 
					 //waiting for data from server
					 //String res = reader.readLine();
					// Log.d(TAG, "res: " + res.toString());
					 
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		mStopABus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BufferedWriter writer = null;
				BufferedReader reader = null;
				try {
					 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
					 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
					 
					 BusStopMessage bsm = new BusStopMessage();
					 bsm.buildMsg("京B7798", "101", 20.3343, 5000.6888);
					 String stop = bsm.toString();
					 
					 writer.write(stop);
					 writer.newLine();
					 writer.flush();
					 
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		mSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread clinetThread = new Thread(){

					@Override
					public void run() {
							BufferedWriter writer = null;
							BufferedReader reader = null;
							try {
								 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
								 reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
								 
								 writer.write(msg);
								 writer.newLine();
								 writer.flush();
								 
								 //waiting for data from server
								 String res = reader.readLine();
								 Log.d(TAG, "res: " + res.toString());
								 
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							
					}
					
				};
				clinetThread.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
