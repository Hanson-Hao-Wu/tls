package org.hao.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import org.springframework.stereotype.Service;

@Service
public class ConnectService {

	public String testConnection(String url) throws Exception{
		URL testApi = new URL(url);
		//URL testApi = new URL("https://www.google.ca/");
		try {
			URLConnection conn = testApi.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			return "success";
		}
		//        catch(SSLSocketException se) {
		//
		//        }
		catch(Exception e) {
			//System.out.println(e);
			//System.out.println("TLS 1.0 is not supported. Please upgrade your integration.");

			System.out.println("Exception is" + e.getMessage());
			//return "TLS 1.0 is not supported. Please upgrade your integration.";
			return e.getMessage();
		}
	}
	
	public boolean ifContain(String resp, String keyword){
		
		boolean ifContain = resp.indexOf(keyword) != -1;
		
		System.out.println(resp + "is contain " + keyword + ifContain);
		
		return ifContain;
	}
	
	void showSSLContext() throws Exception{
//		BoxAPIConnection api = new BoxAPIConnection(boxConfig);
		//		api.setBaseURL("https://api-test.box.com/2.0/");
		SSLContext context = SSLContext.getDefault();
		SSLSocketFactory factory = (SSLSocketFactory)context.getSocketFactory();
		SSLSocket socket = (SSLSocket)factory.createSocket();

		String[] protocols = socket.getSupportedProtocols();

		System.out.println("Supported Protocols: " + protocols.length);
		for(int i = 0; i < protocols.length; i++)
		{
			System.out.println(" " + protocols[i]);
		}

		protocols = socket.getEnabledProtocols();

		System.out.println("Enabled Protocols: " + protocols.length);
		for(int i = 0; i < protocols.length; i++)
		{
			System.out.println(" " + protocols[i]);
		}


		String[] ciphers = socket.getSupportedCipherSuites();
		System.out.println("Enabled Ciphers: " + ciphers.length);
		for(int i = 0; i < ciphers.length; i++)
		{
			System.out.println(" " + ciphers[i]);
		}
	}
	
}
