package com.kalimagezi.billionareskb.review;

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

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/home/addReview", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("description") String description,
			@RequestParam("uid") int uid

	) {

		List<Review> reviews = reviewService.getAReviews(aid);

		for (Review areview : reviews) {

			if (uid == areview.getUid()) {

				return "redirect:/home?reviewFailed=failed";

			}
		}

		if (description != "") {

			Review review = new Review();

			review.setDescription(description);
			review.setAid(aid);
			review.setUid(uid);
			Counter counter = counterService.getUCounter(uid);
			counter.setNoVotes(counter.getNoVotes() + 1);

			Advert advert = advertService.getAdvert(aid).orElseThrow(null);
			advert.setNoReviews(advert.getNoReviews() + 1);
			reviewService.addReview(review);

			advertService.addAdvert(advert);
			return "redirect:/home?ReviewCreated=success";
		}

		return "redirect:/home?ReviewNotCreated=success";

	}

}
