package info.dawidfilip.service;

import static info.dawidfilip.phone.common.CommonBuilder.CONTEXT;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.phone.entity.Phone;

@Service
@SuppressWarnings("unchecked")
public class PhoneServiceImpl implements PhoneService {

	private Logger LOGGER = Logger.getLogger(PhoneServiceImpl.class.getSimpleName());

	private static final boolean additionalLogs = true;

	public List<Phone> getAll() {
		LOGGER.info("getAll");
		PhoneDAOImpl phoneDAOImpl = CONTEXT.getBean("phoneDAO", PhoneDAOImpl.class);
		List<Phone> phones = (List<Phone>) phoneDAOImpl.findAll();
		printAll(phones);
		return phones;
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

}
