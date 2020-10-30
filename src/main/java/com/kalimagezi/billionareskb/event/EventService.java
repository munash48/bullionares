package com.kalimagezi.billionareskb.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventService {

	
	@Autowired
	private EventRepository eventRepository;

	public String addEvent(Event event) {
		
		JSONObject jsonObject = new JSONObject();
		
		System.out.println("Saving event");
		eventRepository.save(event);
		
		try {
			jsonObject.put("message", event.getEname()+" Updated successfully");
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
		return eventRepository.findTop10AllByCid(catid);
	}

}
