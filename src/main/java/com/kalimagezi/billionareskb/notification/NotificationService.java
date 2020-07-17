package com.kalimagezi.billionareskb.notification;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;

	public void addNotification(Notification notification) {

		notificationRepository.save(notification);
	}

	public Optional<Notification> getNotification(int id) {

		return notificationRepository.findById(id);

	}

	public void updateNotification(Notification notification) {

		notificationRepository.save(notification);
	}

	public void deleteNotification(int id) {
		notificationRepository.deleteById(id);

	}
	public Notification getNotificationByUid(int uid) {
		// TODO Auto-generated method stub
		return notificationRepository.findByUid(uid);
	}




}
