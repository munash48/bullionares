package com.kalimagezi.billionareskb.review;

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

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/addReview", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("description") String description,
			@RequestParam("uid") int uid

	) {
		JSONObject jsonObject = new JSONObject();

		List<Review> reviews = reviewService.getAReviews(aid);

		for (Review areview : reviews) {

			if (uid == areview.getUid()) {
				
				try {
					jsonObject.put("message", "You have already crossed this advert");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}
		Review review = new Review();

		if (description != "") {

			

			review.setDescription(description);
			review.setAid(aid);
			review.setUid(uid);
			Counter counter = counterService.getUCounter(uid);
			counter.setNoVotes(counter.getNoVotes() + 1);

			Advert advert = advertService.getAdvert(aid).orElseThrow(null);
			advert.setNoReviews(advert.getNoReviews() + 1);
			reviewService.addReview(review);

			advertService.addAdvert(advert);
			try {
				jsonObject.put("message", "You have added a written review ");
				jsonObject.put("newNegative",  "Negatives ("+advert.getNoNegatives()+")");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return jsonObject.toString();
		}
		
		try {
			jsonObject.put("message", "The review cannot be empty");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();

	}

}
