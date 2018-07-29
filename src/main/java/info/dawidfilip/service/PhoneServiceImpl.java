package info.dawidfilip.service;

import static info.dawidfilip.phone.common.CommonBuilder.CONTEXT;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.phone.entity.Phone;

@Service
public class PhoneServiceImpl {
	
	private Logger LOGGER = Logger.getLogger(PhoneServiceImpl.class.getSimpleName());
	
	public List<Phone> getAll() {
		LOGGER.info("PhoneService ---> getAll");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		List<Phone> phones = (List<Phone>) phoneDAOImpl.findAll();
		return phones;
	}
	
	
}
