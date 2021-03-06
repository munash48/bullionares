package com.kalimagezi.billionareskb.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;


@Service
public class EventService {

	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CounterService counterService;

	public String addEvent(Event event) {
		
		JSONObject jsonObject = new JSONObject();
		
		
		eventRepository.save(event);
		Counter counter =counterService.getUCounter(event.getUid());
		
		try {
			jsonObject.put("message", event.getEname()+" Updated successfully");
			jsonObject.put("status", "success");
			jsonObject.put("noVotes", counter.getNoVotes());
			jsonObject.put("noTVotes", counter.getTotal());
			String newEvents="Don't miss my <i>"+event.getEname() +",</i>"+ event.getDescription()+". Scheduled for "+event.getEventDate();
			String EventImage="<img class='img-responsive pad' src='/uploads/"+event.getUid()+"/events/"+event.getImageLink()+"' alt='Event Photo'>";
			String newProgresBar ="<div class='progress-bar' style='width: "+1 +"%'></div>";
			jsonObject.put("newEvent", newEvents);
			jsonObject.put("newEventImg", EventImage);
			jsonObject.put("newsideEName", event.getEname());
			jsonObject.put("newsideEDesc", event.getDescription());
			jsonObject.put("newsideEGoing", "1  going");
			jsonObject.put("newProgresBar", newProgresBar);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public Optional<Event> getEvent(int id) {

		return eventRepository.findById(id);

	}

	public List<Event> getAllEvents() {

		List<Event> events = new ArrayList<>();
		eventRepository.findAll().forEach(events::add);
		return events;

	}

	public void updateEvent(Event event) {

		eventRepository.save(event);
	}

	public void deleteEvent(int id) {
		eventRepository.deleteById(id);

	}

	public Event getUEvent(int id) {
		// TODO Auto-generated method stub
		return eventRepository.findByUid(id);
	}

	public List<Event> getCatEvents(int catid) {
		// TODO Auto-generated method stub
		return eventRepository.findTop10AllByCidOrderByCreateDateDesc(catid);
	}

}
