package com.example.demo;

public class Contact {
	String uname ;
	String email;
	String message;
	public Contact(String uname, String email, String message) {
		super();
		this.uname = uname;
		this.email = email;
		this.message = message;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
