package com.kalimagezi.billionareskb.advert;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdvertControllerApi {

	
	@Autowired
	private AdvertService advertsService;
	
	@RequestMapping("/adverts")
	public List<Advert> getAllAdverts(){
		return advertsService.getAllAdverts();
	}
	@RequestMapping("/advert/{id}")
	public Optional<Advert> getAdverts(@PathVariable int id){
		return advertsService.getAdvert(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/advert")
	public void addAdverts(@RequestBody Advert advert ){
		advertsService.addAdvert(advert);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/advert/{id}")
	public void updateAdverts(@RequestBody Advert advert, @PathVariable int id){
		advertsService.updateAdvert(advert);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/advert/{id}")
	public void deleteAdverts(@PathVariable int id ){
		advertsService.deleteAdvert(id);
	}
}
