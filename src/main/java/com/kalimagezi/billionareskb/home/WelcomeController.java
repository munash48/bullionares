package com.kalimagezi.billionareskb.home;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalimagezi.billionareskb.email.Mail;
import com.kalimagezi.billionareskb.email.MailService;
import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;

import freemarker.template.TemplateException;

@Controller
public class WelcomeController {
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;
	@Autowired
	NotificationService notificationService;

//		@RequestMapping(value = "/", method = RequestMethod.GET)
//			public String welcome (Model model){
//				model.addAttribute("title", "Welcome");
//				model.addAttribute("ModeWelcome", true);				
//			return "welcome";
//
//		}

	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public String register(Model model) {

		model.addAttribute("title", "Rules");
		model.addAttribute("ModeRegister", true);
		return "/shared/message";
	}

//		@RequestMapping ("/")
//		public String welcome (Model model){
//			model.addAttribute("heading", "The AddressBook by Fiona Davis");
//			model.addAttribute("message", "After a failed apprenticeship, working her way up to head housekeeper of a posh London hotel is more than Sara Smythe ever thought she’d make of herself. But when a chance encounter with Theodore Camden, one of the architects of the grand New York apartment house The Dakota, leads to a job offer, her world is suddenly awash in possibility—no mean feat for a servant in 1884. The opportunity to move to America, where a person can rise above one’s station. The opportunity to be the female manager of The Dakota, which promises to be the greatest apartment house in the world. And the opportunity to see more of Theo, who understands Sara like no one else...and is living in The Dakota with his wife and three young children.");
//			return "welcome";
//			
//		}
//		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model, String error, String logout, String reset, String resetcode, String session,
			String withinreset) {

		if (error != null) {

			if (error.equals("reg")) {
				model.addAttribute("success", "<b>You have successfully registered <br> Now you can login</b>");
				model.addAttribute("ModeJustRegistered", true);

			} else {

				model.addAttribute("error", "<b>bad credentials <br>Check your email and password</b>");
				model.addAttribute("logingin", true);
			}

		}
		if (logout != null) {

			model.addAttribute("logout", "<b>You have successfully logged out </b>");
			model.addAttribute("ModeJustLoggedOut", true);

		}
		if (reset != null) {
		if (reset.equals("success")) {

			model.addAttribute("logout", "<b>Your password has been successfuly Set/reset </b>");
			model.addAttribute("ModeReseted", true);
			

		}
		if (reset.equals("failed")) {
			
			model.addAttribute("error", "<b>the reset code must have expired try again");
			model.addAttribute("ModeReseted", true);
			
		}
		if (reset.equals("mismatch")) {
			
			model.addAttribute("error", "<b>The passwords did not match reset again");
			model.addAttribute("ModeReseted", true);
			
		}
		}
		if (resetcode != null) {

			model.addAttribute("resetcode", resetcode);
			model.addAttribute("logout", "<b>Enter and Confirm Your password</b>");
			model.addAttribute("title", "Reset Password");
			model.addAttribute("ModeResetCode", true);

			return "welcome";

		}
		if (session != null) {

			model.addAttribute("logout", "<b>Your session has timed out.. </b>");
			model.addAttribute("ModeSessionEx", true);
		}
		if (withinreset != null) {

			model.addAttribute("logout", "<b>A password reset link has been sent to " + withinreset + " </b>");
			model.addAttribute("ModeSessionEx", true);
			model.addAttribute("Withinfooter", true);
			
		}

		model.addAttribute("title", "Login");
		model.addAttribute("ModeLogin", true);
		// model.addAttribute("welcome");

		return "welcome";

	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(Model model, @RequestParam(name = "resetCode", required = false) String resetCode, String email,
			String reset, String pnew, String within) throws JSONException {

		if (email != null) {

			User user;
			try {
				user = userService.findByEmail(email);
				if (user != null) {
					Random random = new Random();
					String Hex = new String();
					Hex = "";
					for (int x = 0; x < 6; x++) {
						int val = random.nextInt();

						Hex += Integer.toHexString(val);

					}

					user.setResetcode(Hex);
					userService.updateUser(user);
					String url = new String();
					url = "https://kalimanares.herokuapp.com/?resetcode=" + Hex;
					Mail mail = new Mail();
					mail.setFrom("no-reply@kalimagezi.com");
					mail.setTo(email);
					mail.setSubject(" Reset password Link");

					Map<String, Object> emodel = new HashMap<>();
					emodel.put("name", email);
					emodel.put("location", "Your location is.....");
					emodel.put("message",
							"Please Ignore if you dont intend to reset your password <br> Other wise click <a href='"
									+ url + "'>RESET MY PASSWORD</a> <br> or load " + url);
					emodel.put("signature", "https://kalimagezi.com");

					try {
						mailService.sendSimpleMessage(mail, emodel);
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TemplateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (pnew != null) {
						model.addAttribute("logout", "<b>Log into " + email + "<br> to set your new Password</b>");
					} else {
						model.addAttribute("logout", "<b>PASSWORD RESET LINK SENT TO " + email
								+ "<br> Go to your mail to access reset link</b>");
						return "redirect:/?withinreset= " + email;
					}

					return "shared/reset";

				} else {
					model.addAttribute("logout",
							"<b>User with email" + email + " not found<br><a href=\"javascript:void(0);\" id=\"regForm1\"> Register</a> </b>");
					return "shared/reset";
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		model.addAttribute("title", "Reset Password");
		model.addAttribute("ModeResetLink", true);
		// model.addAttribute("welcome");

		if (within != null) {

			return "redirect:/?withinreset= " + email;
		}

//			}else if(resetCode!=null) {
//				System.out.println("reset code is "+resetCode);
//								
//				model.addAttribute("resetCode",resetCode);
//				model.addAttribute("logout", "<b>Enter and Confirm Your password</b>");
//				model.addAttribute("title", "Reset Password");
//				model.addAttribute("ModeResetCode", true);
//
//				return "shared/reset";

		if (reset != null) {
			model.addAttribute("logout",
					"<b> Password did not match" + "<br> Go to your mail to access reset link</b>");
			model.addAttribute("title", "Reset Password");
			model.addAttribute("ModeResetLink", true);
			model.addAttribute("welcome");
			return "shared/reset";

		}
		model.addAttribute("logout", "<b>Enter your email to get reset link</b>");
		model.addAttribute("ModeReset", true);
		model.addAttribute("title", "Reset Password");
		model.addAttribute("welcome");
		return "shared/reset";

	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String resetPassword(@RequestParam("resetcode") String resetcode, @RequestParam("password") String password,
			@RequestParam("confirm") String confirm) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		if (resetcode != null) {

			User user = null;

			try {
				user = userService.findByResetcode(resetcode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user != null) {

				if (password.equals(confirm)) {
					user.setPassword(password);

					user.setResetcode(null);
					return userService.updateUser(user);

				} else {
					jsonObject.put("message", "The two passwords are not the same");
					jsonObject.put("status", "failed");
					return jsonObject.toString();
				}

			}

		}
		return "shared/reset";

	}

	@RequestMapping(value = "/resete", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String resetPassword(@RequestParam("email") String email) {
		JSONObject jsonObject = new JSONObject();
		if (email != null) {

			User user;
			try {
				user = userService.findByEmail(email);

				if (user != null) {
					jsonObject.put("message", user.getEmail() + " Was found and code sent successfully");
					jsonObject.put("email", user.getEmail());

					return jsonObject.toString();
				} else {
					jsonObject.put("message", "user with " + email + " Was not found");
					return jsonObject.toString();

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return "shared/reset";

	}

	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "session", required = false) String session) {
		// perform-logout
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findByEmail(authentication.getName());
			Notification notification = notificationService.getNotificationByUid(user.getId());
			notification.setJobad(0);
			notification.setEvents(0);
			notificationService.addNotification(notification);
			new SecurityContextLogoutHandler().logout(request, response, auth);

		}

		if (session != null) {
			return "redirect:/?session";
		}

		return "redirect:/?logout";

	}

}
