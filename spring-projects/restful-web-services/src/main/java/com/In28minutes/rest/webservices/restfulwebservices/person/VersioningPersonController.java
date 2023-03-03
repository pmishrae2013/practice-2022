package com.In28minutes.rest.webservices.restfulwebservices.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class VersioningPersonController {

//	URI Versioning - Twitter
	@GetMapping("/v1")
	public PersonV1 getPersonV1(){
		return new PersonV1("Johhny Depp");
	}

	@GetMapping("/v2")
	public PersonV2 getPersonV2(){
		return new PersonV2(new Name("Leonardo", "DiCaprio"));
	}

//	Request Parameter Versioning - Amazon
	@GetMapping(params = "version=1")
	public PersonV1 getPersonV1ByParameter(){
		return new PersonV1("Angelina Jolie");
	}

	@GetMapping(params = "version=2")
	public PersonV2 getPersonV2ByParameter(){
		return new PersonV2(new Name("Tom", "Hanks"));
	}

//	Headers customisation Versioning - Microsoft
	@GetMapping(headers = "X-API-VERSION=1")
	public PersonV1 getPersonV1ByHeader(){
		return new PersonV1("Meryl Streep");
	}

	@GetMapping(headers = "X-API-VERSION=2")
	public PersonV2 getPersonV2ByHeader(){
		return new PersonV2(new Name("Robert", "DeNIro"));
	}

//	Media Type Versioning - GitHub
	@GetMapping(produces = "application/vnd.company.app-v1+json") //'produces' is used for 'accept' headers
	public PersonV1 getPersonV1ByMediaType(){
		return new PersonV1("Meryl Streep");
	}

	@GetMapping(produces = "application/vnd.company.app-v2+json")
	public PersonV2 getPersonV2ByMediaType(){
		return new PersonV2(new Name("Robert", "DeNIro"));
	}
}
