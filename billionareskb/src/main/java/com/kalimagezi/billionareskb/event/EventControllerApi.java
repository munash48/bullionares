package com.kalimagezi.billionareskb.event;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EventControllerApi {

	
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/events")
	public List<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
	@RequestMapping("/event/{id}")
	public Optional<Event> getEvent(@PathVariable int id){
		return eventService.getEvent(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/event")
	public void addEvent(@RequestBody Event event ){
		eventService.addEvent(event);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/event/{id}")
	public void updateEvent(@RequestBody Event event, @PathVariable int id){
		eventService.updateEvent(event);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/event/{id}")
	public void deleteEvent(@PathVariable int id ){
		eventService.deleteEvent(id);
	}
}
