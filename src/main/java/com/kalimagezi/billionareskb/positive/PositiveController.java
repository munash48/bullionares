package com.kalimagezi.billionareskb.positive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	

	@RequestMapping(value = "/home/addPositive", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("uid") int uid

	) {
		
		List <Positive> upositives = positiveService.getAllPositivesByAid(aid);

		Advert advert = advertService.getAdvert(aid).orElseThrow(null);
		advert.setNoPositives(advert.getNoPositives()+1);
		Positive positive = new Positive();

		positive.setAid(aid);
		positive.setUid(uid);
		
		for(Positive upositive: upositives) {
			
			if (positive.getUid()==upositive.getUid()) {
				
				return "redirect:/home?positiveFailed=failed";
				
			}
		}
				
				positiveService.addPositive(positive);

				advertService.addAdvert(advert);
				Counter counter =counterService.getUCounter(uid);
				counter.setNoVotes(counter.getNoVotes()+1);
				

				return "redirect:/home?positiveAdded=success";
		
			
	}
		
		

}
