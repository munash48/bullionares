package com.kalimagezi.billionareskb.home;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kalimagezi.billionareskb.email.Mail;
import com.kalimagezi.billionareskb.email.MailService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;

import freemarker.template.TemplateException;

@Controller
public class WelcomeController {
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;
	
	
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView welcome() {

			ModelAndView mv = new ModelAndView();
			mv.addObject("title", "Welcome");
			mv.addObject("ModeWelcome", true);
			mv.setViewName("welcome");
			return mv;

		}
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView login(@RequestParam(name="error",required=false) String error,
				@RequestParam(name="logout",required=false) String logout,
				@RequestParam(name="reset",required=false) String reset,
				@RequestParam(name="session",required=false) String session
				) {

			ModelAndView mv = new ModelAndView();
			if(error!=null) {
				
				if(error.equals("reg")) {
					mv.addObject("success", "<b>You have successfully registered <br> Now you can login</b>");
					mv.addObject("ModeJustRegistered", true);
					
				} else {
					
					mv.addObject("error", "<b>bad credentials <br>Check your email and password</b>");
					mv.addObject("logingin", true);
				}
									
			}
			if(logout!=null) {

					mv.addObject("logout", "<b>You have successfully logged out </b>");
					mv.addObject("ModeJustLoggedOut", true);
					
									
			}
			if(reset!=null) {
				
				mv.addObject("logout", "<b>Your password has been successfuly reset </b>");
				mv.addObject("ModeReseted", true);
				
				
			}
			if(session!=null) {
				
				mv.addObject("logout", "<b>Your session has timed out.. </b>");
				mv.addObject("ModeSessionEx", true);
				
				
			}

			
			mv.addObject("title", "Login");
			mv.addObject("ModeLogin", true);
			mv.setViewName("welcome");
			
			return mv;

		}
		
		@RequestMapping(value = "/reset", method = RequestMethod.GET)
		public ModelAndView reset(
				@RequestParam(name="email",required=false) String email,
				@RequestParam(name="reset",required=false) String reset,
				@RequestParam(name="pnew",required=false) String pnew,
				@RequestParam(name="resetcode",required=false) String resetcode
				) {
			
			ModelAndView mv = new ModelAndView();

			if(email!=null) {
				
				User user = userService.findByEmail(email);
				if(user!=null) {
					Random random = new Random();
					String Hex = new String();
					Hex="";
					for(int x=0;x<6;x++) {
			        int val = random.nextInt();
			       			        
			        Hex+= Integer.toHexString(val);
					}
					
					user.setResetcode(Hex);
					userService.addUser(user);
					String url = new String();
					url="http//localhost:8080/reset?resetcode="+Hex;
					 Mail mail = new Mail();
				        mail.setFrom("no-reply@kalimagezi.com");
				        mail.setTo(email);
				        mail.setSubject( " Reset password Link");

				        Map<String, Object> model = new HashMap<>();
				        model.put("name", email);
				        model.put("location", "Your location is.....");
				        model.put("message",  "Please Ignore if you dont intend to reset your password <br> Other wise click <a href='"+url+"'>RESET MY PASSWORD</a>");
				        model.put("signature", "https://kalimagezi.com");
				       

				        try {
							mailService.sendSimpleMessage(mail, model);
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
				        
				        if (pnew!=null) {
				        	mv.addObject("logout", "<b>Log into "+email +"<br> to set your new Password</b>");
				        } else {
				        	mv.addObject("logout", "<b>PASSWORD RESET LINK SENT TO "+email +"<br> Go to your mail to access reset link</b>");
				        }
				        					
					
					
					
				} else {
					mv.addObject("logout", "<b>Email not found "+email +"<br><a href=\"/register\"> Register</a> </b>");
				}
									
				mv.addObject("title", "Reset Password");
				mv.addObject("ModeResetLink", true);
				mv.setViewName("welcome");
				return mv;
				
			}else if(resetcode!=null) {
								
				mv.addObject("resetcode",resetcode);
				mv.addObject("logout", "<b>Enter and Confirm Your password</b>");
				mv.addObject("title", "Reset Password");
				mv.addObject("ModeResetCode", true);
				mv.setViewName("welcome");
				return mv;
				
			}else if (reset!=null){
				mv.addObject("logout", "<b> Password did not match"+"<br> Go to your mail to access reset link</b>");
				mv.addObject("title", "Reset Password");
				mv.addObject("ModeResetLink", true);
				mv.setViewName("welcome");
				return mv;
				
			}
				mv.addObject("logout", "<b>Enter your email to get reset link</b>");
				mv.addObject("ModeReset", true);
				mv.addObject("title", "Reset Password");
				mv.setViewName("welcome");
				return mv;
			
			
		}
		
		@RequestMapping(value="/reset", method = RequestMethod.POST)
		public String resetPassword ( @RequestParam("resetcode") String resetcode,@RequestParam("password") String password,@RequestParam("confirm") String confirm) {
			if(resetcode!=null) {
				
				User user = null;
				
				try {
					user = userService.findByResetcode(resetcode);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(user!=null) {
					
					if(password.equals(confirm)) {
						user.setPassword(password);
						
						user.setResetcode(null);
						userService.addUser(user);
						return "redirect:/login?reset=success";
					} else {
						return "redirect:/reset?reset=failed";
					}
					
					
				}
			}
		  return "redirect:/reset";
			

			
		}
			
		@RequestMapping(value="/resete", method = RequestMethod.POST)
		public String resetPassword ( @RequestParam("email") String email) {
			if(email!=null) {
				User user = userService.findByEmail(email);
				
				if(user!=null) {
					return "redirect:/reset?email="+email;				
				}
			}
			return "redirect:/reset";
			
			
			
		}
		
		
		@RequestMapping(value = "/perform-logout" )
		public String  logout(HttpServletRequest request, HttpServletResponse response,@RequestParam(name = "session", required = false) String session) {
			//perform-logout
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth!=null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
				
			}
			
			if(session!=null) {
				return "redirect:/login?session";
			}
				
			
			return "redirect:/login?logout";

		}
		

	}


