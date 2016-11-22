package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EurekaSearcherApplication {
	  private static Logger log = LoggerFactory.getLogger(EurekaSearcherApplication.class);

	 @Autowired
	 private DiscoveryClient discoveryClient;
	
    public static void main(String[] args) {
        SpringApplication.run(EurekaSearcherApplication.class, args);
    }
    
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
    	log.warn("Number of instances registered" + this.discoveryClient.getInstances(applicationName).size());
        return this.discoveryClient.getInstances(applicationName);
    }
}
