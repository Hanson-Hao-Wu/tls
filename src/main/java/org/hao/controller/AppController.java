package org.hao.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import org.hao.domain.Message;
import org.hao.service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	ConnectService connectService;
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to TLS Upgrade Test Web Service.";
    }

	@RequestMapping("/status")
	public String getStatus() {
		return "It works";
	}
	
	@RequestMapping("/hello/{result}")
    public Message message(@PathVariable String result) {//REST Endpoint.
 
        Message msg = new Message(true, "Hello " + result);
        return msg;
    }
	
	/*	public static void main(String[] args) throws Exception {
		AppController ac = new AppController();
		ac.getTest();
	}*/
	
	@RequestMapping("/test")
	public Message getTest() throws Exception {
		
		String resp = connectService.testConnection("https://api-test.box.com/2.0/");
		
		System.out.println("The response is " + resp);
		
		Message message = new Message(true, resp);
		
		if(connectService.ifContain(resp, "handshake")){
			message.setSuccessStatus(false);
		}
		else if (connectService.ifContain(resp, "401")){
			message.setSuccessStatus(true);
		}
		
		return message;
		
	}
}
