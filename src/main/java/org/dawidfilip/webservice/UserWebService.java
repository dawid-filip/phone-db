package org.dawidfilip.webservice;

import static org.dawidfilip.phone.common.CommonBuilder.CONTEXT;

import java.util.List;
import java.util.logging.Logger;

import org.dawidfilip.dao.UserDAOImpl;
import org.dawidfilip.phone.common.UserBuilder;
import org.dawidfilip.phone.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserWebService {
	
	private Logger LOGGER = Logger.getLogger(UserWebService.class.getSimpleName());
	
	@GetMapping(path = "add", produces = MediaType.APPLICATION_JSON_VALUE)
	public User addDummy() {
		LOGGER.info("add");
		UserDAOImpl userDAOImpl = CONTEXT.getBean("userDAO", UserDAOImpl.class);
		User user = UserBuilder.creatDummyRandomUser();
		userDAOImpl.add(user);
		return user;
	}
	
	@GetMapping(path = "add/userName/{userName}/password/{password}/role/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User add(@PathVariable String userName, @PathVariable String password, @PathVariable String role) {
		LOGGER.info("add: " + new User(userName, password, role).toString());
		UserDAOImpl userDAOImpl = CONTEXT.getBean("userDAO", UserDAOImpl.class);
		User user = new User(userName, password, role);
		userDAOImpl.add(user);
		return user;
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll() {
		LOGGER.info("findAll");
		UserDAOImpl userDAOImpl = CONTEXT.getBean("userDAO", UserDAOImpl.class);
		return (List<User>) userDAOImpl.findAll();
	}
	
	@GetMapping(path = "one/userName/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User find(@PathVariable("userName") String userName) {
		LOGGER.info("find");
		UserDAOImpl userDAOImpl = CONTEXT.getBean("userDAO", UserDAOImpl.class);
		return (User) userDAOImpl.findById(userName);
	}
	
	
}
