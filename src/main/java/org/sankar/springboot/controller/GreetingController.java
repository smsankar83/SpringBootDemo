package org.sankar.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.sankar.springboot.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Application")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public String getRoot() {
		
		return "Welcome to Spring boot Demo page !!!";
	}
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public Greeting getGreeting(@RequestParam(value="name") String name){
	
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value="/Add", method=RequestMethod.PUT)
	public String countValues(@RequestParam(value="x") int x, @RequestParam(value="y") long y)
	{
		
		return (x+y) + "";
	}
	
	@RequestMapping(value="/Multiply", method=RequestMethod.POST)
	public String multiplyValues(@RequestParam(value="x") int x, @RequestParam(value="y") long y)
	{
		
		return (x*y) + "";
	}
	
}
