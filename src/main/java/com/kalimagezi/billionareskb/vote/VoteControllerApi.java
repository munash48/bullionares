package com.kalimagezi.billionareskb.vote;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VoteControllerApi {

	
	@Autowired
	private VoteService voteService;
	
	@RequestMapping("/votes")
	public List<Vote> getAllVotes(){
		return voteService.getAllVotes();
	}
	@RequestMapping("/vote/{id}")
	public Optional<Vote> getVote(@PathVariable int id){
		return voteService.getVote(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/vote")
	public void addVote(@RequestBody Vote vote ){
		voteService.addVote(vote);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/vote/{id}")
	public void updateVote(@RequestBody Vote vote, @PathVariable int id){
		voteService.updateVote(vote);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/vote/{id}")
	public void deleteVote(@PathVariable int id ){
		voteService.deleteVote(id);
	}
}
