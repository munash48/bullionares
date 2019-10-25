package com.kalimagezi.billionareskb.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		public ModelAndView login() {

			ModelAndView mv = new ModelAndView();
			mv.addObject("title", "Login");
			mv.addObject("ModeLogin", true);
			mv.setViewName("welcome");
			
			return mv;

		}
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public ModelAndView register() {

			ModelAndView mv = new ModelAndView();
			mv.addObject("title", "Register");
			mv.addObject("ModeRegister", true);
			mv.setViewName("welcome");
			
			return mv;

		}

	}


