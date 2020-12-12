package com.kalimagezi.billionareskb.message;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.message.Message;
import com.kalimagezi.billionareskb.message.MessageService;
import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;

@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private NotificationService notificationService;

	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("uid") Integer uid, @RequestParam("wuid") Integer wuid,
			@RequestParam("message") String message

	) {
		JSONObject jsonObject = new JSONObject();
		String scatid="0";
		if (uid<wuid) {
		
		scatid=uid.toString()+wuid;
		} else {
			scatid=wuid.toString()+uid;	
		}
		int catid = Integer.parseInt(scatid);
		
		Counter counter = counterService.getUCounter(wuid);
		counter.setNoVotes(counter.getNoVotes()+1);
		
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	    counter.getNoReports()+counter.getNoVotes());
		
		Message message1 = new Message();

		message1.setUid(uid);
		message1.setWuid(wuid);
		message1.setMessage(message);
		message1.setChatid(catid);
		Notification  wnotification = notificationService.getNotificationByUid(wuid);
		wnotification.setMessage(wnotification.getMessage()+1);
		notificationService.addNotification(wnotification);
		Notification  notification = notificationService.getNotificationByUid(uid);
		notification.setMessage(0);
		notificationService.addNotification(notification);
	
			    messageService.addMessage(message1);
			    
			    try {
					jsonObject.put("message", "Messagege with "+message1.getWuid()+" Updated successfully");
					jsonObject.put("wuid", wuid);
					jsonObject.put("status", "success");
					
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				return jsonObject.toString();
				
				
		
		
	}

}
