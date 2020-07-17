package com.kalimagezi.billionareskb.education;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EducationControllerApi {
	
	@Autowired
	private EducationService educationService;
	
	@RequestMapping("/educations")
	public List<Education> getAllEducations(){
		return educationService.getAllEducations();
	}
	@RequestMapping("/education/{id}")
	public Optional<Education> getEducation(@PathVariable int id){
		return educationService.getEducation(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/education")
	public void addEducation(@RequestBody Education education ){
		educationService.addEducation(education);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/education/{id}")
	public void updateEducation(@RequestBody Education education, @PathVariable int id){
		educationService.updateEducation(education);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/education/{id}")
	public void deleteEducation(@PathVariable int id ){
	}

}
