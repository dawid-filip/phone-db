package info.dawidfilip.webservice;

import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestWebService {

	private Logger LOGGER = Logger.getLogger(TestWebService.class.getSimpleName());
	
	@PostMapping(path = "add", produces = MediaType.APPLICATION_JSON_VALUE)
	public Test addDummy(@RequestBody Test test) {
		LOGGER.info("add -> Test 'Object'");
		LOGGER.info(test.toString());
		return test;
	}
	
}


/*

{
	
} 

*/