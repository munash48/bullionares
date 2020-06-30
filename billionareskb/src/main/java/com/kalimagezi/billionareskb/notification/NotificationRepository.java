package com.kalimagezi.billionareskb.notification;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



	public interface NotificationRepository extends CrudRepository<Notification, Integer> {

		Notification findByUid(int id);
		Optional<Notification> findById(int id);


	}