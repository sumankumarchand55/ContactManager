package com.smart.contact.helper;

public class MessagePopup {
	private String content;
	private String type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public MessagePopup(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}

}
