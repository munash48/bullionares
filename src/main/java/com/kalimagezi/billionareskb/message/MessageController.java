package com.kalimagezi.billionareskb.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	
	@RequestMapping(value = "/message/sendMessage", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("uid") Integer uid, @RequestParam("wuid") Integer wuid,
			@RequestParam("message") String message

	) {
		String scatid="0";
		if (uid<wuid) {
		
		scatid=uid.toString()+wuid;
		} else {
			scatid=wuid.toString()+uid;	
		}
		int catid = Integer.parseInt(scatid);
		
		Counter counter = counterService.getUCounter(uid);
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

				

				return "redirect:/message?wuid="+wuid;
				
				
		
		
	}

}
