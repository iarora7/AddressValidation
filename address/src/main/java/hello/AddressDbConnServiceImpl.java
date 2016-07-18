package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class AddressDbConnServiceImpl {
	
	@Autowired
	DbConnService dbConnService;
	Query searchUserQuery;
	
	public void saveAddress(Address address) {
		dbConnService.getMongoOperation().save(address);
	}
	
	public Address findAddress(String name) {
		searchUserQuery = new Query(Criteria.where("name").is(name));
		return dbConnService.getMongoOperation().findOne(searchUserQuery, Address.class);
	}
	
	public void updateHouse(String name, String house) {
		searchUserQuery = new Query(Criteria.where("name").is(name));
		dbConnService.getMongoOperation().updateFirst(searchUserQuery, 
                Update.update("house", house), Address.class);
	}
	
	public void updateCity(String name, String city) {
		searchUserQuery = new Query(Criteria.where("name").is(name));
		dbConnService.getMongoOperation().updateFirst(searchUserQuery, 
                Update.update("city", city), Address.class);
	}
	
	public void deleteAddress(String name) {
		searchUserQuery = new Query(Criteria.where("name").is(name));
		dbConnService.getMongoOperation().remove(searchUserQuery, Address.class);
	}
	
	public List<Address> getAllAddresses() {
		List<Address> addressList = dbConnService.getMongoOperation().findAll(Address.class);
		return addressList;
	}

}
