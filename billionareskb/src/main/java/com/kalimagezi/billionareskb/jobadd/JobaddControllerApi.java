package com.kalimagezi.billionareskb.jobadd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class JobaddControllerApi {

	
	@Autowired
	private JobaddService jobaddService;
	
	@RequestMapping("/jobadds")
	public List<Jobadd> getAllJobadds(){
		return jobaddService.getAllJobadds();
	}
	@RequestMapping("/jobadd/{id}")
	public Optional<Jobadd> getJobadd(@PathVariable int id){
		return jobaddService.getJobadd(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/jobadd")
	public void addJobadd(@RequestBody Jobadd jobadd ){
		jobaddService.addJobadd(jobadd);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/jobadd/{id}")
	public void updateJobadd(@RequestBody Jobadd jobadd, @PathVariable int id){
		jobaddService.updateJobadd(jobadd);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/jobadd/{id}")
	public void deleteJobadd(@PathVariable int id ){
		jobaddService.deleteJobadd(id);
	}
}
