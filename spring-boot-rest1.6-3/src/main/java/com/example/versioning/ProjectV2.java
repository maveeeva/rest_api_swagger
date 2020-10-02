package com.example.versioning;

public class ProjectV2 {
	private ProjectName name ;

	
	public ProjectV2() {
		super();	
	}
	public ProjectV2(ProjectName name) {
		super();
		this.name = name;
	}

	public ProjectName getName() {
		return name;
	}

	public void setName(ProjectName name) {
		this.name = name;
	}

}
