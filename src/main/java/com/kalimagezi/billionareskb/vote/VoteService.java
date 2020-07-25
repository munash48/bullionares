package com.kalimagezi.billionareskb.vote;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoteService {
	
	@Autowired
	private VoteRepository voteRepository;

	public void addVote(Vote vote) {

		voteRepository.save(vote);
	}

	public Optional<Vote> getVote(int id) {

		return voteRepository.findById(id);

	}

	public List<Vote> getAllVotes() {

		List<Vote> votes = new ArrayList<>();
		voteRepository.findAll().forEach(votes::add);
		return votes;

	}

	public void updateVote(Vote vote) {

		voteRepository.save(vote);
	}

	public void deleteVote(int id) {
		voteRepository.deleteById(id);

	}

	public List<Vote> getAllVotesByUid(int uid) {
		// TODO Auto-generated method stub
		return voteRepository.findAllByUid(uid);
	}

	public List<Vote> getAllVotesByAid(Integer aid) {
		// TODO Auto-generated method stub
		return voteRepository.findAllByAid(aid);
	}


}
