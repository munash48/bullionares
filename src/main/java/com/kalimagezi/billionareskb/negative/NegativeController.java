package com.kalimagezi.billionareskb.negative;

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
import com.kalimagezi.billionareskb.negative.Negative;
import com.kalimagezi.billionareskb.negative.NegativeService;

@Controller
public class NegativeController {
	
	@Autowired
	private NegativeService negativeService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private CounterService counterService;
	

	@RequestMapping(value = "/addNegative", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("uid") Integer uid, @RequestParam("adid") int adid, @RequestParam("aduid") int aduid

	) {
		JSONObject jsonObject = new JSONObject();
		
		List <Negative> unegatives = negativeService.getAllNegativesByAid(adid);

		Advert advert = advertService.getAdvert(adid).orElseThrow(null);
		advert.setNoNegatives(advert.getNoNegatives()+1);
		Negative negative = new Negative();

		negative.setAid(adid);
		negative.setUid(uid);
		Counter counter =counterService.getUCounter(aduid);
		counter.setNoVotes(counter.getNoVotes()-1);
		
		
		for(Negative unegative: unegatives) {
			
			if (negative.getUid()==unegative.getUid()) {
				
				try {
					jsonObject.put("message", "You have already crossed this advert");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
				
			}
		}
				
				negativeService.addNegative(negative);

				advertService.addAdvert(advert);
				counterService.addCounter(counter);
				
				try {
					jsonObject.put("message", "You have added a negative review " + advert.getId());
					jsonObject.put("newNegative",  "Negatives ("+advert.getNoNegatives()+")");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				

				return jsonObject.toString();
		
			
	}
		

}
