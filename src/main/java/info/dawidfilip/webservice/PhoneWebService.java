package info.dawidfilip.webservice;

import static info.dawidfilip.phone.common.CommonBuilder.CONTEXT;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.dawidfilip.dto.PhoneDTO;
import info.dawidfilip.phone.entity.Phone;
import info.dawidfilip.service.PhoneService;

@RestController
@RequestMapping("/phone/")
public class PhoneWebService {
	
	private Logger LOGGER = Logger.getLogger(PhoneWebService.class.getSimpleName());

	private final PhoneService phoneServiceImpl = CONTEXT.getBean("phoneServiceImpl", PhoneService.class);
	
	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Phone> allAll() {
		LOGGER.info("all");
		List<Phone> phones = phoneServiceImpl.getAll();
		return phones;
	}
	
	@PostMapping(path = "add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Phone addPhone(@RequestBody Phone phone) {
		LOGGER.info("add");
		Phone addedPhone = phoneServiceImpl.add(phone);
		return addedPhone;
	}
	
	@GetMapping(path = "add-dummy", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone addDummy() {
		LOGGER.info("add-dummy");
		Phone phone = phoneServiceImpl.addDummy();
		return phone;
	}
	
	@GetMapping(path = "find/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone find(@PathVariable("id") Long id) {
		LOGGER.info("find");
		Phone phone = phoneServiceImpl.getOne(id);
		return phone;
	}
	
	@GetMapping(path = "delete/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Phone delete(@PathVariable("id") Long id) {
		LOGGER.info("delete");
		Phone phone = phoneServiceImpl.delete(id);
		return phone;
	}
	
	
	@GetMapping(path = "all/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteAll(@PathVariable("id") Long id) {
		LOGGER.info("deleteAll");
		phoneServiceImpl.deleteAll();
		return "true";
	}
	
	
}
