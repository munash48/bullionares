package com.kalimagezi.billionareskb.advert;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.user.UserService;

@Controller
public class AdvertController {
	
	
public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/uploads";

	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private AdvertService advertService;
	
	@RequestMapping(value="/addAdvert", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser ( @RequestParam("uid") Integer uid, 
			@RequestParam("cid") Integer cid, 
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("advertDate") String advertDate,
			@RequestParam("advertAmount") int advertAmount,
			@RequestParam("itemAmount") int itemAmount,
			@RequestParam("website") String website,
			@RequestParam("transactionId") String transactionId,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("noDays") int noDays

			) {

		Counter counter= counterService.getUCounter(uid);
		counter.setNoVotes(counter.getNoVotes()+2);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
		Advert advert = new Advert();
	    
		advert.setTitle(title);
		advert.setCid(cid);
		advert.setDescription(description);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");
		LocalDate date2 = LocalDate.parse(advertDate, dtf);
		advert.setDateFrom(date2);
		advert.setAdvertAmount(advertAmount);
		advert.setItemAmount(itemAmount);
		advert.setWebsite(website);
		advert.setTransactionId(transactionId);
		advert.setUid(uid);
		advert.setNoDays(noDays);
		JSONObject jsonObject = new JSONObject();
		
		try {
			long tday = new Date().getTime(); 
			String pname=tday+".jpg";
			advert.setImageLink(pname);
			String ppath=uploadDirectory+"/"+uid+"/adverts/";
			userService.saveImage(imageFile,ppath,pname);
			try {
				jsonObject.put("message", advert.getTitle()+" advert Uploaded successfully");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error uploading image");
		}
			
	    advertService.addAdvert(advert);

		return jsonObject.toString();
		
	}
	@RequestMapping(value="/admin/enableadd", method = RequestMethod.GET)
	public String enableadd (
			@RequestParam(name = "aid", required = false) Integer aid
			
			
			) {
		
		Advert advert = advertService.getAdvert(aid).orElseThrow(null);
		
		advert.setEnabled(true);
		
		
		
		
		advertService.addAdvert(advert);
		
		return "redirect:/admin?advertEnabled=success";
		
	}
	

}
