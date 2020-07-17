package com.kalimagezi.billionareskb.negative;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalimagezi.billionareskb.advert.Advert;
import com.kalimagezi.billionareskb.advert.AdvertService;
import com.kalimagezi.billionareskb.negative.Negative;
import com.kalimagezi.billionareskb.negative.NegativeService;

@Controller
public class NegativeController {
	
	@Autowired
	private NegativeService negativeService;
	@Autowired
	private AdvertService advertService;
	

	@RequestMapping(value = "/home/addNegative", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("uid") int uid

	) {
		
		List <Negative> unegatives = negativeService.getAllNegativesByAid(aid);

		Advert advert = advertService.getAdvert(aid).orElseThrow(null);
		advert.setNoNegatives(advert.getNoNegatives()+1);
		Negative negative = new Negative();

		negative.setAid(aid);
		negative.setUid(uid);
		
		for(Negative unegative: unegatives) {
			
			if (negative.getUid()==unegative.getUid()) {
				
				return "redirect:/home?negativeFailed=failed";
				
			}
		}
				
				negativeService.addNegative(negative);

				advertService.addAdvert(advert);
				

				return "redirect:/home?negativeAdded=success";
		
			
	}
		

}
