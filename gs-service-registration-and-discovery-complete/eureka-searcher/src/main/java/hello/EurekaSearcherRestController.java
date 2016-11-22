package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaSearcherRestController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/testText")
	public String getTestText() {
		final ResponseEntity<String> responseEntity = restTemplate.exchange("http://eureka-client/test", HttpMethod.GET,
				null, String.class);
		return responseEntity.getBody();
	}

}
