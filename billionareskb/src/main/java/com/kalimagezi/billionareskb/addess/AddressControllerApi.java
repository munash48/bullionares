package com.kalimagezi.billionareskb.addess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressControllerApi {

	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/addresses")
	public List<Address> getAllAddresses(){
		return addressService.getAllAddresses();
	}
	@RequestMapping("/address/{id}")
	public Optional<Address> getAddress(@PathVariable int id){
		return addressService.getAddress(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/address")
	public void addAddress(@RequestBody Address address ){
		addressService.addAddress(address);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/address/{id}")
	public void updateAddress(@RequestBody Address address, @PathVariable int id){
		addressService.updateAddress(address);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/address/{id}")
	public void deleteAddress(@PathVariable int id ){
		addressService.deleteAddress(id);
	}
}
