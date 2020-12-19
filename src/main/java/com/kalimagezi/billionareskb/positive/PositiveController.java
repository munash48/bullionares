package com.kalimagezi.billionareskb.positive;

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

import com.kalimagezi.billionareskb.advert.Advert;
import com.kalimagezi.billionareskb.advert.AdvertService;
import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.positive.Positive;
import com.kalimagezi.billionareskb.positive.PositiveService;
@Controller
public class PositiveController {
	
	@Autowired
	private PositiveService positiveService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private CounterService counterService;
	

	@RequestMapping(value = "/addPositive", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("uid") Integer uid, @RequestParam("adid") int adid, @RequestParam("aduid") Integer aduid

	) {
		JSONObject jsonObject = new JSONObject();
		
		List <Positive> upositives = positiveService.getAllPositivesByAid(adid);

		Advert advert = advertService.getAdvert(adid).orElseThrow(null);
		advert.setNoPositives(advert.getNoPositives()+1);
		Positive positive = new Positive();

		positive.setAid(adid);
		positive.setUid(uid);

		Counter counter =counterService.getUCounter(aduid);
		counter.setNoVotes(counter.getNoVotes()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		
		for(Positive upositive: upositives) {
			
			if (positive.getUid()==upositive.getUid()) {
				try {
					jsonObject.put("message", "You have already added a positive review");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
				
			}
		}
				
				positiveService.addPositive(positive);

				advertService.addAdvert(advert);				
	
				counterService.addCounter(counter);
				
				
				try {
					jsonObject.put("message", "You have added a positive review" + advert.getId());
					jsonObject.put("status", "success");
					jsonObject.put("newPositive",  "Positives ("+advert.getNoPositives()+")");
					if(uid==aduid) {
					jsonObject.put("noVotes", counter.getNoVotes());
					jsonObject.put("noTVotes", counter.getTotal());
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
		
			
	}
	@RequestMapping(value = "/countClick", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String countClicks(@RequestParam("eaid") Integer eaid
			
			) {
		JSONObject jsonObject = new JSONObject();		
		Advert advert = advertService.getAdvert(eaid).orElseThrow(null);
		advert.setNoClicks(advert.getNoClicks()+1);		

		
		advertService.addAdvert(advert);					
		
		try {
			jsonObject.put("message", "click on URL to visit advertiser");
			jsonObject.put("status", "success");
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
		
	}
		
		

}
