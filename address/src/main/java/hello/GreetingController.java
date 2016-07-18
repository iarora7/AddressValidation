package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Autowired
	GreetingDbConnServiceImpl greetingDbConnService;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		
		Greeting user = new Greeting(counter.incrementAndGet(),
                String.format(template, name));
		greetingDbConnService.saveUser(user);
		Greeting savedUser = greetingDbConnService.findUser(user.getId());
		System.out.println("Fetched savedUser : " + savedUser.toString());
		System.out.println("User : " + user.toString());
        return user;
    }
	
	@RequestMapping("/heythere")
	public String heythere(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello, " + name;
	}

}
