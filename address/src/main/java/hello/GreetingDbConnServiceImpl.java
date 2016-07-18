package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class GreetingDbConnServiceImpl {
	
	@Autowired
	DbConnService dbConnService;

	public void saveUser(Greeting user) {
		dbConnService.getMongoOperation().save(user);
		System.out.println("TestUser created: " + user.toString());
	}
	
	public Greeting findUser(long userid){
		Query searchUserQuery = new Query(Criteria.where("id").is(userid));
		Greeting savedUser = dbConnService.getMongoOperation().findOne(searchUserQuery, Greeting.class);
		return savedUser;
	}

}
