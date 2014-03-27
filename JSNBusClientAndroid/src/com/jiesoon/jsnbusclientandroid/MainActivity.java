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
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mSend;
	private Socket mClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mSend = (Button)findViewById(R.id.main_send);
		mSend.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread clinetThread = new Thread(){

					@Override
					public void run() {
						try {
							mClient = new Socket("10.0.0.2", 7798);
							
							//向服务器发送数据
							BufferedWriter writer = null;
							try {
								
								 writer = new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream()));
								 writer.write("jiesoon");
								 writer.newLine();
								 writer.flush();
								 
							} catch (IOException e2) {
								e2.printStackTrace();
							}
							
							
							try {
								mClient.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						} catch (UnknownHostException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
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
