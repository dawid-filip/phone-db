package org.dawidfilip.webservice;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.dawidfilip.dao.PhoneDAOImpl;
import org.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;
import org.dawidfilip.phone.model.Phone;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneWebWebService {
	
	private Logger LOGGER = Logger.getLogger(PhoneWebWebService.class.getSimpleName());
	
	private static final AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBeanConfiguration.class); 
	
	@GetMapping(path = "/add/brand/{brand}/model/{model}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone add(@PathVariable("brand") String brand, @PathVariable("model") String model) {
		LOGGER.info("add");
		Phone phone = new Phone(brand, model + "-" +  new Random().nextInt(100) + 1, new Random().nextDouble()+10000);
		PhoneDAOImpl phoneDAOImpl = context.getBean("phoneDAOImpl", PhoneDAOImpl.class);
		phoneDAOImpl.add(phone);
		return phone;
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Phone> findAll() {
		LOGGER.info("findAll");
		PhoneDAOImpl phoneDAOImpl = context.getBean("phoneDAOImpl", PhoneDAOImpl.class);
		return phoneDAOImpl.findAll();
	}
	
	
}