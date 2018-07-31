package info.dawidfilip.service;

import static info.dawidfilip.phone.common.CommonBuilder.CONTEXT;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.dto.PhoneDTO;
import info.dawidfilip.phone.common.PhoneBuilder;
import info.dawidfilip.phone.entity.Camera;
import info.dawidfilip.phone.entity.Phone;

@Service
@SuppressWarnings("unchecked")
public class PhoneServiceImpl implements PhoneService {

	private Logger LOGGER = Logger.getLogger(PhoneServiceImpl.class.getSimpleName());

	private static final boolean additionalLogs = true;

	//@Autowired
	//private PhoneDAOImpl phoneDAOImpl;
	// or:
	private PhoneDAOImpl phoneDAOImpl;
	public void setPhoneDAOImpl(PhoneDAOImpl phoneDAOImpl) {
		this.phoneDAOImpl = phoneDAOImpl;
	}
	
	public List<Phone> getAll() {
		LOGGER.info("getAll");
		List<Phone> phones = (List<Phone>) phoneDAOImpl.findAll();
		printAll(phones);
		return phones;
	}
	public Phone getOne(long id) {
		LOGGER.info("getOne");
		Phone phone = (Phone) phoneDAOImpl.findById(id);
		print(phone);
		return phone;
	}
	
	public Phone add(Phone phone) {
		LOGGER.info("add Phone");
		phoneDAOImpl.add(phone);
		print(phone);
		return phone;
	}
	
	public Phone add(PhoneDTO phoneDTO) {
		LOGGER.info("add PhoneDTO");
		
		Phone phoneToAdd = new Phone(phoneDTO);
		//phoneToAdd.setCameraFront(new Camera(phoneDTO.getCameraFront()));
		//phoneToAdd.setCameraBack(new Camera(phoneDTO.getCameraBack()));
		
		phoneDAOImpl.add(phoneToAdd);
		
		print(phoneToAdd);
		
		return phoneToAdd;
	}
	
	public Phone addDummy() {
		LOGGER.info("addDummy");
		Phone phone = PhoneBuilder.createDummyRandomPhoneAndSensor();
		phoneDAOImpl.add(phone);
		print(phone);
		return phone;
	}
	
	public Phone delete(long id) {
		LOGGER.info("delete");
		Phone phone = (Phone) phoneDAOImpl.findById(id);
		phoneDAOImpl.delete(phone);
		return phone;
	}
	
	public void deleteAll() {
		LOGGER.info("deleteAll");
		phoneDAOImpl.deleteAll();
	}
	
	
	public void printAll(List<?> objects) {
		if (additionalLogs) {
			int no = 1;
			for (Object o : objects) {
				System.out.println(no + ") " + o.toString());
				no++;
			}
		}
	}
	public void print(Object object) {
		if (additionalLogs) {
			System.out.println(object != null ? object.toString() : null);
		}
	}

}
