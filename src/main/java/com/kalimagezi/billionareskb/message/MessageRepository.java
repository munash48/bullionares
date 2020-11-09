package com.kalimagezi.billionareskb.message;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kalimagezi.billionareskb.message.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{

	List<Message> findTop10ByUid(int uid);

	List<Message> findTop10ByChatid(int catid);

	List<Message> findTop5ByWuid(int id);

	List<Message> findTop10ByWuid(int id);

	List<Message> findTop20ByWuid(int id);

	List<Message> findTop10ByWuidOrderByMdateDesc(int id);

	List<Message> findTop10ByChatidOrderByMdateDesc(int catid);

	List<Message> findTop10ByUidOrderByMdateDesc(int uid);

	List<Message> findTop10ByUidOrderByMdateAsc(int uid);

	List<Message> findTop10ByChatidOrderByMdateAsc(int catid);

	List<Message> findTop10ByWuidOrderByMdateAsc(int id);
}
