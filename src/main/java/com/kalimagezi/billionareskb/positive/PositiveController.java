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
		
		
		for(Positive upositive: upositives) {
			
			if (positive.getUid()==upositive.getUid()) {
				try {
					jsonObject.put("message", "You have already voted for this Advert");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
				
			}
		}
				
				positiveService.addPositive(positive);

				advertService.addAdvert(advert);
				Counter counter2 =counterService.getUCounter(uid);
				counter2.setNoVotes(counter2.getNoVotes()+1);
				
				
				counterService.addCounter(counter);
				counterService.addCounter(counter2);
				
				
				try {
					jsonObject.put("message", "You have Voted Advert No" + advert.getId());
					jsonObject.put("newvotes",  "Positives ("+advert.getNoPositives()+")");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
		
			
	}
		
		

}
