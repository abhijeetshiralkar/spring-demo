package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaSearcherRestController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/testText")
	public String getTestText() {
		return restTemplate.getForObject("http://eureka-client/test", String.class);
	}

}
