package org.dawidfilip.webservice;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneWebWebService {
	
	private Logger logger = Logger.getLogger(PhoneWebWebService.class.getSimpleName());
	
	
	@RequestMapping(path = "/bean", method = RequestMethod.GET)
	public String getString() {
		return " { Simple String } ";
	}
	
	@RequestMapping(path = "/value/{type}", method = RequestMethod.GET)
	public String pay(@PathVariable("type") String type) {
		System.out.println("type = " + type);
		logger.info("type = " + type);
		return "Your value is: " + type + ", lenght = " + type.length();
	}
	
}