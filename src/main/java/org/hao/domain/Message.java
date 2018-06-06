package org.hao.domain;

public class Message {
	
	boolean successStatus;
	String content;
	public boolean isSuccessStatus() {
		return successStatus;
	}
	public void setSuccessStatus(boolean successStatus) {
		this.successStatus = successStatus;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message(boolean successStatus, String content) {
		super();
		this.successStatus = successStatus;
		this.content = content;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	  String name;
//    String text;
// 
//    public Message(String name, String text) {
//        this.name = name;
//        this.text = text;
//    }
// 
//    public String getName() {
//        return name;
//    }
// 
//    public String getText() {
//        return text;
//    }
	
	
    

}
