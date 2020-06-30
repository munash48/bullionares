package com.kalimagezi.billionareskb.addess;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;
@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;

	
	@RequestMapping(value="/home/updateAddress", method = RequestMethod.POST)
	public String updadeUser ( @RequestParam("aId") Integer id, 
			@RequestParam("country") String country,
			@RequestParam("district") String district,
			@RequestParam("division") String division,
			@RequestParam("village") String village,
			@RequestParam("street") String street,
			@RequestParam("boxNumber") String boxNumber
			) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userService.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  Address  address = addressService.getUAddress(user.getId()).orElseThrow(null);
		  if(address.getCountry()==null) {
         counter.setNoVotes(counter.getNoVotes()+2);
 		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
		  }
	
		address.setCountry(country);
	    address.setDistrict(district);
	    address.setDivision(division);
	    address.setVillage(village);
	    address.setStreet(street);
	    address.setBoxNumber(boxNumber);
			
			
	    addressService.addAddress(address);


		return "redirect:/home?addressupdate=success";
		
	}


}
