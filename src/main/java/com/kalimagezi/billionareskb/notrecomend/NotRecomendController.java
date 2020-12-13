package com.kalimagezi.billionareskb.notrecomend;

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

	@RequestMapping(value = "/addNotRecomend", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("jaid") Integer jaid, @RequestParam("uid") int uid, @RequestParam("jauid") int jauid

	) {
		
		JSONObject jsonObject = new JSONObject();

		List<NotRecomend> notRecomendations = notNotRecomendService.getAllNotRecomendsByJaid(jaid);

		Jobadd jobadd = jobaddService.getJobadd(jaid).orElseThrow(null);
		
        jobadd.setNotRecomended(jobadd.getNotRecomended()+1);
		
        NotRecomend notRecomend = new NotRecomend();
		notRecomend.setJaid(jaid);
		notRecomend.setUid(uid);

		Counter counter = counterService.getUCounter(jauid);
		counter.setNoVotes(counter.getNoReports()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());

		for (NotRecomend anotRecomend : notRecomendations) {

			if (notRecomend.getUid() == anotRecomend.getUid()) {
				
				try {
					jsonObject.put("message", "You have already Un-Recommended this Job ADD");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}
		

		notNotRecomendService.addNotRecomend(notRecomend);
		jobaddService.addJobadd(jobadd);
		counterService.addCounter(counter);
		
		
		try {
			
			jsonObject.put("message", "You have added a negative review " + jobadd.getId());
			jsonObject.put("status", "success");
			jsonObject.put("newNotRecomend",  "Not Recomend ("+jobadd.getNotRecomended()+")");
			jsonObject.put("noReports", counter.getNoReports());
			jsonObject.put("noTVotes", counter.getTotal());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();

	}
}
