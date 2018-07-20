package org.dawidfilip.webservice;

import java.util.List;
import java.util.logging.Logger;

import org.dawidfilip.dao.PhoneDAOImpl;
import org.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;
import org.dawidfilip.phone.common.CommonBuilder;
import org.dawidfilip.phone.common.PhoneBuilder;
import org.dawidfilip.phone.entity.Phone;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.dawidfilip.phone.common.CommonBuilder.CONTEXT;

@RestController
@RequestMapping("/phone/")
public class PhoneWebService {
	
	private Logger LOGGER = Logger.getLogger(PhoneWebService.class.getSimpleName());
	
//	private static final AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationBeanConfiguration.class); 
	
	@GetMapping(path = "add/brand/{brand}/model/{model}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone add(@PathVariable("brand") String brand, @PathVariable("model") String model) {
		LOGGER.info("add");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		Phone phone = PhoneBuilder.createDummyRandomPhoneAndSensor();
		phoneDAOImpl.add(phone);
		return phone;
	}

	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Phone> findAll() {
		LOGGER.info("findAll");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		return phoneDAOImpl.findAll();
	}
	@GetMapping(path = "one/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone find(@PathVariable("id") Long id) {
		LOGGER.info("find");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		return phoneDAOImpl.find(id);
	}
	
 	
}