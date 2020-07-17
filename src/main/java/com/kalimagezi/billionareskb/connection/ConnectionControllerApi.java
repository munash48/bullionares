package com.kalimagezi.billionareskb.connection;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConnectionControllerApi {

	
	@Autowired
	private ConnectionService connectionService;
	
	@RequestMapping("/connections")
	public List<Connection> getAllConnections(){
		return connectionService.getAllConnections();
	}
	@RequestMapping("/connection/{id}")
	public Optional<Connection> getConnection(@PathVariable int id){
		return connectionService.getConnection(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/connection")
	public void addConnection(@RequestBody Connection connection ){
		connectionService.addConnection(connection);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/connection/{id}")
	public void updateConnection(@RequestBody Connection connection, @PathVariable int id){
		connectionService.updateConnection(connection);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/connection/{id}")
	public void deleteConnection(@PathVariable int id ){
		connectionService.deleteConnection(id);
	}
}
