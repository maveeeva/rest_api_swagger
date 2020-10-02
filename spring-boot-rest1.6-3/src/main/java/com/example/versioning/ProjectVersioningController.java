package com.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectVersioningController {
	
	@GetMapping("v1/project")
	public ProjectV1 projectV1() {
		return new ProjectV1("CustomerSolution");
	}
	@GetMapping("v2/project")
	public ProjectV2 projectV2() {
		return new ProjectV2(new ProjectName("CustomerSolution","CSM"));
	}
	@GetMapping(value ="/project/param", params = "version=1")
	public ProjectV1 paramV1() {
		return new ProjectV1 ("CustomerSolution");
	}
	@GetMapping(value ="/project/param", params = "version=2")
	public ProjectV2 paramV2() {
		return new ProjectV2(new ProjectName("CustomerSolution","CSM"));
	}
	
	@GetMapping(value ="/project/header", headers = "X_API_VERSION=1")
	public ProjectV1 headerV1() {
		return new ProjectV1 ("CustomerSolution");
	}
	@GetMapping(value ="/project/header", headers = "X_API_VERSION=2")
	public ProjectV2 headerV2() {
		return new ProjectV2(new ProjectName("CustomerSolution","CSM"));
	}
	@GetMapping(value ="/project/produces", produces = "application/api_v1+json")
	public ProjectV1 produesV1() {
		return new ProjectV1 ("CustomerSolution");
	}
	@GetMapping(value ="/project/produces", produces = "application/api_v2+json")
	public ProjectV2 produesV2() {
		return new ProjectV2(new ProjectName("CustomerSolution","CSM"));
	}

}
