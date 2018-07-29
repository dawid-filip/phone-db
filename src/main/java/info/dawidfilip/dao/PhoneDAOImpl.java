package info.dawidfilip.dao;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(value = false)
public class PhoneDAOImpl extends BaseDAOImpl implements PhoneDAO {

	private static Logger LOGGER = Logger.getLogger(PhoneDAOImpl.class.getSimpleName());

}
