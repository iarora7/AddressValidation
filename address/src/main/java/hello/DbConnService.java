package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class DbConnService {
	
	private MongoOperations mongoOperation;

	public MongoOperations getMongoOperation() {
		return mongoOperation;
	}

	@Bean
	public MongoOperations setUp() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
	    mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	    return mongoOperation;
	}

}
