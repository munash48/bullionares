package com.kalimagezi.billionareskb.advert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdvertService {

	
	@Autowired
	private AdvertRepository advertRepository;

	public void addAdvert(Advert advert) {

		advertRepository.save(advert);
	}

	public Optional<Advert> getAdvert(int id) {

		return advertRepository.findById(id);

	}

	public List<Advert> getAllAdverts() {

		List<Advert> adverts = new ArrayList<>();
		advertRepository.findAll().forEach(adverts::add);
		return adverts;

	}

	public void updateAdvert(Advert advert) {

		advertRepository.save(advert);
	}

	public void deleteAdvert(int id) {
		advertRepository.deleteById(id);

	}

	public List<Advert> getAllEnabledAdverts() {
		// TODO Auto-generated method stub
		return advertRepository.findAllByEnabledTrueOrderByCreateDateDesc();
	}
	public List<Advert> getAllDisabledAdverts() {
		// TODO Auto-generated method stub
		return advertRepository.findAllByEnabledFalse();
	}
	
	

}
