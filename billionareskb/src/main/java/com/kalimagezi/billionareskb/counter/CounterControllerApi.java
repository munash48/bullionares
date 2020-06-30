package com.kalimagezi.billionareskb.counter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CounterControllerApi {
	@Autowired
	private CounterService counterService;
	
	@RequestMapping("/counters")
	public List<Counter> getAllCounters(){
		return counterService.getAllCounters();
	}
	@RequestMapping("/counter/{id}")
	public Optional<Counter> getCounter(@PathVariable int id){
		return counterService.getCounter(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/counter")
	public void addCounter(@RequestBody Counter counter ){
		counterService.addCounter(counter);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/counter/{id}")
	public void updateCounter(@RequestBody Counter counter, @PathVariable int id){
		counterService.updateCounter(counter);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/counter/{id}")
	public void deleteCounter(@PathVariable int id ){
		counterService.deleteCounter(id);
	}

}
