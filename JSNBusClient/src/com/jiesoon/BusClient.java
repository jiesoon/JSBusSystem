package com.jiesoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BusClient {

	public static void main(String[] args) {
		Socket client = null;
		//创建一个Socket对象
		try {
			client = new Socket("10.0.0.2", 7798);
			
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//读取来自屏幕的数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//向服务器发送数据
		BufferedWriter writer = null;
		try {
			 writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		while(true){
			try {
				//从标准输入读取一行内容
				String line = reader.readLine();
				System.out.println(line);
				
				if(line.equals("quit")){
					break;
				}
				
				writer.write(line);
				writer.newLine();
				writer.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		
		try {
			client.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
