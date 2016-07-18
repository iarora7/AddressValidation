package hello;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
public class Address {
	
	private final String name;
	private final String house;
	private final String city;
	private final String state;
//	private final String postal;
	
	public String getName() {
		return name;
	}
	
	public String getHouse() {
		return house;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public Address(String name, String house, String city, String state) {
		super();
		this.name = name;
		this.house = house;
		this.city = city;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Address [name=" + name + ", house=" + house + ", city=" + city + ", state=" + state + "]";
	}

}
