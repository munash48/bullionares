package com.kalimagezi.billionareskb.invite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InviteService {

	
	@Autowired
	private InviteRepository inviteRepository;

	public void addInvite(Invite invite) {

		inviteRepository.save(invite);
	}

	public Optional<Invite> getInvite(int id) {

		return inviteRepository.findById(id);

	}

	public List<Invite> getAllInvites() {

		List<Invite> invites = new ArrayList<>();
		inviteRepository.findAll().forEach(invites::add);
		return invites;

	}

	public void updateInvite(Invite invite) {

		inviteRepository.save(invite);
	}

	public void deleteInvite(int id) {
		inviteRepository.deleteById(id);

	}

}
