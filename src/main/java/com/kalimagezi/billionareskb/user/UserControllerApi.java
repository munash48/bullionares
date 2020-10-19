package com.kalimagezi.billionareskb.user;

import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerApi {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@RequestMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable int id){
		return userService.getUser(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/user")
	public void addUser(@RequestBody User user ){
		userService.addUser(user);
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id ) throws JSONException{
		 userService.updateUser( user);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/user/{id}")
	public void deleteUser(@PathVariable int id ){
		userService.deleteUser(id);
	}
}
