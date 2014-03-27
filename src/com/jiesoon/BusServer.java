package com.jiesoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class BusServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			ServerSocket serverSocket = new ServerSocket(7798);
			
			while(true){
				Socket conn = serverSocket.accept();
				
				InputStream in = conn.getInputStream();
				OutputStream out = conn.getOutputStream();
				
				while(true){
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					System.out.println("line = " + line);				
	
					if(line == null || line.equals("quit")){
						break;
					}
				}
	
				
				conn.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
