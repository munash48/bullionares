package com.kalimagezi.billionareskb.home;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
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
			if(session!=null) {
				
				mv.addObject("logout", "<b>Your session has timed out.. </b>");
				mv.addObject("ModeSessionEx", true);
				
				
			}
			
			mv.addObject("title", "Login");
			mv.addObject("ModeLogin", true);
			mv.setViewName("welcome");
			
			return mv;

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


