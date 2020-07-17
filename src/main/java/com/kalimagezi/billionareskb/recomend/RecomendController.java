package com.kalimagezi.billionareskb.recomend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.jobadd.Jobadd;
import com.kalimagezi.billionareskb.jobadd.JobaddService;

@Controller
public class RecomendController {
	@Autowired
	private RecomendService recomendService;
	@Autowired
	private JobaddService jobaddService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/home/addRecomend", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("jaid") Integer jaid, @RequestParam("uid") int uid

	) {

		List<Recomend> recomendations = recomendService.getAllRecomendsByJaid(jaid);

		Jobadd jobadd = jobaddService.getJobadd(jaid).orElseThrow(null);
		
        jobadd.setRecomended(jobadd.getRecomended()+1);
		
        Recomend recomend = new Recomend();
		recomend.setJaid(jaid);
		recomend.setUid(uid);

		Counter counter = counterService.getUCounter(uid);
		counter.setNoVotes(counter.getNoVotes()+1);

		for (Recomend arecomend : recomendations) {

			if (recomend.getUid() == arecomend.getUid()) {

				return "redirect:/home?recomendFailed=failed";

			}
		}
		

		recomendService.addRecomend(recomend);
		jobaddService.addJobadd(jobadd);

		return "redirect:/home?recomendAdded=success";

	}
}
