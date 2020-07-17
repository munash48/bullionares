package com.kalimagezi.billionareskb.notgoing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.event.Event;
import com.kalimagezi.billionareskb.event.EventService;


@Controller
public class NotGoingController {
	@Autowired
	private NotGoingService notGoingService;
	@Autowired
	private EventService eventService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/home/addNotGoing", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("eid") Integer eid, @RequestParam("uid") int uid

	) {

		List<NotGoing> unotgoings = notGoingService.getAllNotGoingsByEid(eid);

		Event event = eventService.getEvent(eid).orElseThrow(null);
		event.setNotGoing(event.getNotGoing() + 1);
		NotGoing notGoing = new NotGoing();

		notGoing.setEid(eid);
		notGoing.setUid(uid);

		Counter counter = counterService.getUCounter(event.getUid());
		counter.setNoReports(counter.getNoReports()+1);

		for (NotGoing unotgoing : unotgoings) {

			if (notGoing.getUid() == unotgoing.getUid()) {

				return "redirect:/home?notGoingFailed=failed";

			}
		}

		notGoingService.addNotGoing(notGoing);

		eventService.addEvent(event);

		return "redirect:/home?notGoingAdded=success";

	}

}
