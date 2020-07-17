package com.kalimagezi.billionareskb.invite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InviteControllerApi {

	
	@Autowired
	private InviteService inviteService;
	
	@RequestMapping("/invites")
	public List<Invite> getAllInvites(){
		return inviteService.getAllInvites();
	}
	@RequestMapping("/invite/{id}")
	public Optional<Invite> getInvite(@PathVariable int id){
		return inviteService.getInvite(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/invite")
	public void addInvite(@RequestBody Invite invite ){
		inviteService.addInvite(invite);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/invite/{id}")
	public void updateInvite(@RequestBody Invite invite, @PathVariable int id){
		inviteService.updateInvite(invite);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/invite/{id}")
	public void deleteInvite(@PathVariable int id ){
		inviteService.deleteInvite(id);
	}
}
