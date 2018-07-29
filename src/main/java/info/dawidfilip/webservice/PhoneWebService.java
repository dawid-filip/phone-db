package info.dawidfilip.webservice;

import static info.dawidfilip.phone.common.CommonBuilder.CONTEXT;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.phone.common.PhoneBuilder;
import info.dawidfilip.phone.entity.Phone;
import info.dawidfilip.service.PhoneServiceImpl;

@RestController
@RequestMapping("/phone/")
@SuppressWarnings("unchecked")
public class PhoneWebService {
	
	private Logger LOGGER = Logger.getLogger(PhoneWebService.class.getSimpleName());

	@GetMapping(path = "all/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Phone> allAll() {
		return CONTEXT.getBean("phoneServiceImpl", PhoneServiceImpl.class).getAll();
	}
	
	@GetMapping(path = "add", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone add() {
		LOGGER.info("add");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		Phone phone = PhoneBuilder.createDummyRandomPhoneAndSensor();
		phoneDAOImpl.add(phone);
		return phone;
	}
	
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
		return (List<Phone>) phoneDAOImpl.findAll();
	}
	
	@GetMapping(path = "one/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone find(@PathVariable("id") Long id) {
		LOGGER.info("find");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		return (Phone) phoneDAOImpl.findById(id);
	}
	
	@GetMapping(path = "delete/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone delete(@PathVariable("id") Long id) {
		LOGGER.info("delete");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		Phone phone = (Phone) phoneDAOImpl.findById(id);
		phoneDAOImpl.delete(phone);
		return phone;
	}
	
	@GetMapping(path = "all/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteAll(@PathVariable("id") Long id) {
		LOGGER.info("deleteAll");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		phoneDAOImpl.deleteAll();
		return "true";
	}
	
	
}