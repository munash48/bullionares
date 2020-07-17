package com.kalimagezi.billionareskb.user;



import org.springframework.data.jpa.repository.JpaRepository;


public interface UserModelRepository extends JpaRepository<User, Integer>{
	
	//getTopics()
	//getTopic(int id)
	//updateTopic(int id)
	//deleteTopic(int id)
	User findByEmail(String email);
	
	


}
