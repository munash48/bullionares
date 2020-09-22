package com.kalimagezi.billionareskb.notrecomend;

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
public class NotRecomendController {
	@Autowired
	private NotRecomendService notNotRecomendService;
	@Autowired
	private JobaddService jobaddService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/home/addNotRecomend", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("jaid") Integer jaid, @RequestParam("uid") int uid

	) {

		List<NotRecomend> notRecomendations = notNotRecomendService.getAllNotRecomendsByJaid(jaid);

		Jobadd jobadd = jobaddService.getJobadd(jaid).orElseThrow(null);
		
        jobadd.setNotRecomended(jobadd.getNotRecomended()+1);
		
        NotRecomend notRecomend = new NotRecomend();
		notRecomend.setJaid(jaid);
		notRecomend.setUid(uid);

		Counter counter = counterService.getUCounter(uid);
		counter.setNoVotes(counter.getNoVotes()+1);

		for (NotRecomend anotRecomend : notRecomendations) {

			if (notRecomend.getUid() == anotRecomend.getUid()) {

				return "redirect:/home?notRecomendFailed=failed";

			}
		}
		

		notNotRecomendService.addNotRecomend(notRecomend);
		jobaddService.addJobadd(jobadd);

		return "redirect:/home?notRecomendAdded=success";

	}
}
