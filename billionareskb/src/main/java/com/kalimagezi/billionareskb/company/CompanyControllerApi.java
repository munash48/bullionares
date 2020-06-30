package com.kalimagezi.billionareskb.company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CompanyControllerApi {

	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/companies")
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	@RequestMapping("/company/{id}")
	public Optional<Company> getCompany(@PathVariable int id){
		return companyService.getCompany(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/company")
	public void addCompany(@RequestBody Company company ){
		companyService.addCompany(company);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/company/{id}")
	public void updateCompany(@RequestBody Company company, @PathVariable int id){
		companyService.updateCompany(company);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/company/{id}")
	public void deleteCompany(@PathVariable int id ){
		companyService.deleteCompany(id);
	}
}
