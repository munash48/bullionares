package com.kalimagezi.billionareskb.message;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kalimagezi.billionareskb.message.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{

	List<Message> findAllByUid(int uid);

	List<Message> findTop10ByChatid(int catid);

	List<Message> findTop5ByWuid(int id);
}
