package com.example.versioning;

public class ProjectName {
	private String  code;
	private String title;
	
	public ProjectName() {
		super();
	}
	public ProjectName(String code, String title) {
		super();
		this.code = code;
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public String getTitle() {
		return title;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
