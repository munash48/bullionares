package com.kalimagezi.billionareskb.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome to billionares");
		mv.addObject("ModeLogged", true);
		mv.setViewName("index2");
		return mv;

	}
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public ModelAndView home2() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome to billionares");
		mv.addObject("ModeLogged", true);
		mv.setViewName("index");
		return mv;

	}

}
