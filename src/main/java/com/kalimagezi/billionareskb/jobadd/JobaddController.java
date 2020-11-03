package com.kalimagezi.billionareskb.jobadd;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kalimagezi.billionareskb.jobadd.Jobadd;
import com.kalimagezi.billionareskb.jobadd.JobaddService;
import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;
import com.kalimagezi.billionareskb.recomend.Recomend;
import com.kalimagezi.billionareskb.recomend.RecomendService;
import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;

@Controller
public class JobaddController {
	
	
public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/uploads";

	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private JobaddService jobaddService;
	@Autowired
	private RecomendService recomendService;
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping(value="/addJobadd", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser ( @RequestParam("uid") Integer uid, 
			@RequestParam("catid") Integer cid, 
			@RequestParam("compid") Integer compId, 
			@RequestParam("title") String jobTitle,
			@RequestParam("jobCategory") String jobCategory,
			@RequestParam("description") String description,
			@RequestParam("noPositions") Integer noPositions,
			@RequestParam("deadline") String deadline,
			@RequestParam("salary") String salary,
			@RequestParam("imageFile") MultipartFile imageFile

			) {
		Jobadd jobadd = new Jobadd();

		Counter counter= counterService.getUCounter(uid);
		counter.setNoVotes(counter.getNoVotes()+10);

		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
			
			List<User> catUsers=userService.getAllByCatid(cid);
			for(User cuser: catUsers) {
				
				Notification  notification = notificationService.getNotificationByUid(cuser.getId());
				notification.setJobad(notification.getJobad()+1);
				
			}
		Recomend recomend = new Recomend();
		
		
	    
		jobadd.setCid(cid);
		jobadd.setUid(uid);
		jobadd.setCompId(compId);
		jobadd.setJobTitle(jobTitle);
		jobadd.setJobCategory(jobCategory);
		jobadd.setSalary(salary);
		jobadd.setDescription(description);
		jobadd.setNoPositions(noPositions);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");
		LocalDate date2 = LocalDate.parse(deadline, dtf);
		jobadd.setDeadline(date2);
		jobadd.setRecomended(1);
		JSONObject jsonObject = new JSONObject();
		
		try {
			long tday = new Date().getTime(); 
			String pname=tday+".jpg";
			jobadd.setImageLink(pname);
			String ppath=uploadDirectory+"/"+uid+"/jobadds/";
			userService.saveImage(imageFile,ppath,pname);
			
			try {
				jsonObject.put("message", jobadd.getJobTitle()+" advert Uploaded successfully. Waiting aprooval");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error uploading image");
		}
			
	    jobaddService.addJobadd(jobadd);
	    recomend.setJaid(jobadd.getId());
	    recomend.setUid(uid);
	    recomendService.addRecomend(recomend);
	    

		return jsonObject.toString();
		
	}
	


}
