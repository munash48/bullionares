package com.kalimagezi.billionareskb.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;

	public void addCompany(Company company) {

		companyRepository.save(company);
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
