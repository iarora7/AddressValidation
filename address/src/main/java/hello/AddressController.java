package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/myaddress")
public class AddressController {
	
	@Autowired
	AddressDbConnServiceImpl addressDbConnService;
	Address address;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public Address myaddress(@RequestParam(value="name", defaultValue="Isha") String name,
			@RequestParam(value="house", defaultValue="2138 Oak St") String house,
			@RequestParam(value="city", defaultValue="Los Angeles") String city,
			@RequestParam(value="state", defaultValue="CA") String state) {
		address = new Address(name, house, city, state);
		System.out.println("Address as: " + address.toString());
		addressDbConnService.saveAddress(address);
		return address;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Address findMyaddress(@RequestParam(value="name", defaultValue="Isha") String name) {
		address = addressDbConnService.findAddress(name);
		System.out.println("Address returned as: " + address.toString());
		return address;
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public List<Address> getAllAddresses() {
		List<Address> addressList = addressDbConnService.getAllAddresses();
		System.out.println(addressList);
		return addressList;
	}

}
