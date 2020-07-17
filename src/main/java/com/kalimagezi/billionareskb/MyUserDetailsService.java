package com.kalimagezi.billionareskb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserRepository;
import com.kalimagezi.billionareskb.user.UserService;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional <User> user =userRepository.findByEmail(email);
		 User user1 = userService.findByEmail(email);
		
         Notification  notification = notificationService.getNotificationByUid(user1.getId());
		
		notification.setChart(1);
	    notificationService.addNotification(notification);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + email));
		return user.map(MyUserDetails::new).get();
	}

}
