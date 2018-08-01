package info.dawidfilip.service;

import java.util.List;

import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.dto.PhoneDTO;
import info.dawidfilip.phone.entity.Phone;

public interface PhoneService {
	void setPhoneDAOImpl(PhoneDAOImpl phoneDAOImpl);
	
	List<Phone> getAll();
	Phone getOne(long id);
	
	Phone add(Phone phone);
	Phone addDummy();
	
	Phone delete(long id);
	void deleteAll();
}
