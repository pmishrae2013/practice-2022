package com.In28minutes.rest.webservices.restfulwebservices.hello_world;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	//	'helloWorld() method would map to GET request at '/hello-world' path/url
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld(){
		return "Hello World!!";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("This is Hello World Bean!!");
	}

//	using path parameters.
//	Path parameters are the variable values. here it's 'name'
	@GetMapping(path = "/hello/{name}")
	public HelloWorldBean helloWithName(@PathVariable String name){
//		return new HelloWorldBean("Hello"+ name);

//		here %s is a string format which gets replaced by name there
		return new HelloWorldBean(String.format("Hello, %s", name));
	}

	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(){
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
	}

}
