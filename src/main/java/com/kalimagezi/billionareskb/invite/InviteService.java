package com.kalimagezi.billionareskb.invite;

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
public class InviteService {

	
	@Autowired
	private InviteRepository inviteRepository;
	@Autowired
	private CounterService counterService;

	public String addInvite(Invite invite) {
		JSONObject jsonObject = new JSONObject();
		Counter counter =counterService.getUCounter(invite.getUid());

		inviteRepository.save(invite);
		
		try {
			jsonObject.put("message", invite.getEmail()+" invited successfully");
			jsonObject.put("status", "success");
			jsonObject.put("noInvite", counter.getNoInvites());
			jsonObject.put("noTVotes", counter.getTotal());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
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

	public Invite getInvite(String email) {
		// TODO Auto-generated method stub
		
		return inviteRepository.findByEmail(email);
	}

}
