package com.kalimagezi.billionareskb.event;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;
@Controller
public class EventController {
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/uploads";

	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping(value="/updateEvent", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser (
			@RequestParam("id") Integer id,
			@RequestParam("ename") String ename,
			@RequestParam("description") String description,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("eventDate") String eventDate,
			@RequestParam("uid") Integer uid

			) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		User user = userService.findByEmail(authentication.getName());
		Counter counter= counterService.getUCounter(user.getId());
		Event  event = eventService.getUEvent(user.getId());
		
		if(event.getEname()==null) {
		counter.setNoVotes(counter.getNoVotes()+2);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
		}
	    
		event.setEname(ename);
		event.setDescription(description);
		event.setCid(user.getCatid());
		event.setGoing(1);
		
		List<User> catUsers=userService.getAllByCatid(user.getCatid());
		for(User cuser: catUsers) {
			
			Notification  notification = notificationService.getNotificationByUid(cuser.getId());
			notification.setEvents(notification.getEvents()+1);
			notificationService.addNotification(notification);
			
		}

		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");

		LocalDate date2 = LocalDate.parse(eventDate, dtf);
		System.out.println("Setting event date");
		event.setEventDate(date2);
		
		try {
			long tday = new Date().getTime(); 
			String pname=tday+".jpg";
			event.setImageLink(pname);
			String ppath=uploadDirectory+"/"+uid+"/events/";
			System.out.println("Starting to upload");
			userService.saveImage(imageFile,ppath,pname);
			System.out.println("uploaded");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error uploading image");
		}
		
		
	    


		return eventService.addEvent(event);
		
	}
	
	

}
