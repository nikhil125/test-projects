package nikhil;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceImpl1 {

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	@Cacheable(cacheNames = "hello", sync = true)
	public String sayHello(String a) {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
	}

}
