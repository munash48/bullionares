package com.kalimagezi.billionareskb.career;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CareerControllerApi {

	
	@Autowired
	private CareerService careerService;
	
	@RequestMapping("/careers")
	public List<Career> getAllCareers(){
		return careerService.getAllCareers();
	}
	@RequestMapping("/career/{id}")
	public Optional<Career> getCareer(@PathVariable int id){
		return careerService.getCareer(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/career")
	public void addCareer(@RequestBody Career career ){
		careerService.addCareer(career);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/career/{id}")
	public void updateCareer(@RequestBody Career career, @PathVariable int id){
		careerService.updateCareer(career);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/career/{id}")
	public void deleteCareer(@PathVariable int id ){
		careerService.deleteCareer(id);
	}
}
