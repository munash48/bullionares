package com.kalimagezi.billionareskb.event;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

	Event findByUid(int id);

	List<Event> findTop10AllByCid(int catid);

	List<Event> findTop10AllByCidOrderByCreateDateDesc(int catid);

}
