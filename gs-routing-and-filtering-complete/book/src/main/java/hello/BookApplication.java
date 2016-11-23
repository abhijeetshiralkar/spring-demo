package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class BookApplication {

	@RequestMapping(value = "/available")
	public String available() {
		return "Book available is Spring in Action";
	}

	@RequestMapping(value = "/checked-out")
	public String checkedOut() {
		return "Book checked out is Spring Boot in Action";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
}
