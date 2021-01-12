package com.kalimagezi.billionareskb.invite;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.email.Mail;
import com.kalimagezi.billionareskb.email.MailService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;

import freemarker.template.TemplateException;


@Controller
public class InviteController {
	
	@Autowired
	private InviteService inviteService;
	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;
	@Autowired
    private MailService mailService;

	
	@RequestMapping(value="/inviteUser", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String inviteUser ( @RequestParam("uid") Integer uid, 
			@RequestParam("uemail") String uemail,
			@RequestParam("iemail") String iemail
			) {
		JSONObject jsonObject = new JSONObject();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userService.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		   

		    Invite invite = new Invite();

			invite.setEmail(iemail);
			invite.setUid(uid);
			invite.setMessage(user.getFirstName() +" " +user.getOtherNames() +" has invited you to join Billonares" );
			
			List<Invite> invites = inviteService.getAllInvites();
			
			
			for(Invite myinvite: invites) {
				
				if (myinvite.getEmail().equals(invite.getEmail())) {
					
					try {
						jsonObject.put("message", invite.getEmail()+" was already invited");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
												
					return jsonObject.toString();
					
				} 
				
			}
			  Mail mail = new Mail();
		        mail.setFrom("info@kalimagezi.com");
		        mail.setTo(iemail);
		        mail.setSubject(user.getFirstName() +" " +user.getOtherNames() +" has invited you to join Billonares");

		        Map<String, Object> model = new HashMap<>();
		        model.put("name", iemail);
		        model.put("location", "Uganda");
		        model.put("message", user.getFirstName()  +" Thinks you have what it takes to be the next Billionare. <br> Follow the link https://kalimanares.herokuapp.com/ to join <br> or <a href='https://kalimanares.herokuapp.com/'>click here </a>");
		        model.put("signature", "https://kalimagezi.com");
		       

		        try {
					mailService.sendSimpleMessage(mail, model);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TemplateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
//			counter.setNoInvites(counter.getNoInvites()+1);
//			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()+
//		    counter.getNoReports()+counter.getNoVotes());
//			
//			
//			counterService.addCounter(counter);
			
			
		return inviteService.addInvite(invite);
		
	}

}
