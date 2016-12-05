package hello;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class BookstoreApplication {

	@RequestMapping(value = "/recommended")
	public String readingList() {
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt) recommended on "
				+ dateFormat.format(new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
}
