package hello;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		System.out.println("Available method is called");
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Book available is Spring in Action on " + dateFormat.format(new Date());
	}

	@RequestMapping(value = "/checked-out")
	public String checkedOut() {
		System.out.println("Checked out method is called");
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Book checked out is Spring Boot in Action" + dateFormat.format(new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
}
