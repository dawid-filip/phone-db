package info.dawidfilip.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PhoneDAOImpl extends BaseDAOImpl implements PhoneDAO {

	private static Logger LOGGER = Logger.getLogger(PhoneDAOImpl.class.getSimpleName());

}
