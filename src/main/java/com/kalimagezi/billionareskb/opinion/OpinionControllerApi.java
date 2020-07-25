package com.kalimagezi.billionareskb.opinion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OpinionControllerApi {

	@Autowired
	private OpinionService opinionService;
	
	@RequestMapping("/opinions")
	public List<Opinion> getAllOpinions(){
		return opinionService.getAllOpinions();
	}
	@RequestMapping("/opinion/{id}")
	public Optional<Opinion> getOpinion(@PathVariable int id){
		return opinionService.getOpinion(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/opinion")
	public void addOpinion(@RequestBody Opinion opinion ){
		opinionService.addOpinion(opinion);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/opinion/{id}")
	public void updateOpinion(@RequestBody Opinion opinion, @PathVariable int id){
		opinionService.updateOpinion(opinion);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/opinion/{id}")
	public void deleteOpinion(@PathVariable int id ){
		opinionService.deleteOpinion(id);
	}
}
