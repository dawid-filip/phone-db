package org.dawidfilip.webservice;

import java.math.BigDecimal;
import java.util.Random;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.dawidfilip.dao.PhoneTestDao;
import org.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;
import org.dawidfilip.phone.common.PhoneTestBuilder;
import org.dawidfilip.phone.model.PhoneTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneWebWebService {
	
	private Logger logger = Logger.getLogger(PhoneWebWebService.class.getSimpleName());
	
	private static AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBeanConfiguration.class); 
	
	@RequestMapping(path = "/add/brand/{brand}/model/{model}", method = RequestMethod.GET)
	public String add(@PathVariable("brand") String brand,
					  @PathVariable("model") String model) {
		PhoneTest pt = new PhoneTest(brand, model + "-" + 
					  new Random().nextInt(100) + 1, 
					  new Random().nextDouble()+10000, new BigDecimal("100"));
		
		PhoneTestDao phoneTestDao = context.getBean("phoneTestDao", PhoneTestDao.class);
		phoneTestDao.persist(pt);
		
		return pt.toString();
	}
	
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