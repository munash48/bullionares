package com.kalimagezi.billionareskb.user;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	//getTopics()
	//getTopic(int id)
	//updateTopic(int id)
	//deleteTopic(int id)
	Optional<User> findByEmail(String email);

	User findByEmailAndPassword(String name, String credentials);


	List<User> findAllByCatid(int catid);

	User findAllByResetcode(String resetcode);
	


}
