package com.kalimagezi.billionareskb.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CounterService counterService;

	public String addCompany(Company company) {
		JSONObject jsonObject = new JSONObject();

		companyRepository.save(company);
		
		Counter counter =counterService.getUCounter(company.getUid());
		try {
			jsonObject.put("message", company.getName()+" Updated successfully");
			jsonObject.put("noVotes", counter.getNoVotes());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("newComp", company.getName());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public Optional<Company> getCompany(int id) {

		return companyRepository.findById(id);

	}

	public List<Company> getAllCompanies() {

		List<Company> companies = new ArrayList<>();
		companyRepository.findAll().forEach(companies::add);
		return companies;

	}

	public void updateCompany(Company company) {

		companyRepository.save(company);
	}

	public void deleteCompany(int id) {
		companyRepository.deleteById(id);

	}

	public Company getUCompany(int id) {
		// TODO Auto-generated method stub
		return companyRepository.findByUid(id);
	}

}
