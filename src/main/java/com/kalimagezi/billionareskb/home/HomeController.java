package com.kalimagezi.billionareskb.home;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kalimagezi.billionareskb.addess.Address;
import com.kalimagezi.billionareskb.addess.AddressService;
import com.kalimagezi.billionareskb.advert.Advert;
import com.kalimagezi.billionareskb.advert.AdvertService;
import com.kalimagezi.billionareskb.analysis.Analysis;
import com.kalimagezi.billionareskb.analysis.AnalysisService;
import com.kalimagezi.billionareskb.article.Article;
import com.kalimagezi.billionareskb.article.ArticleService;
import com.kalimagezi.billionareskb.career.Career;
import com.kalimagezi.billionareskb.career.CareerService;
import com.kalimagezi.billionareskb.category.Category;
import com.kalimagezi.billionareskb.category.CategoryService;
import com.kalimagezi.billionareskb.company.Company;
import com.kalimagezi.billionareskb.company.CompanyService;
import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.education.Education;
import com.kalimagezi.billionareskb.education.EducationService;
import com.kalimagezi.billionareskb.event.Event;
import com.kalimagezi.billionareskb.event.EventService;
import com.kalimagezi.billionareskb.jobadd.Jobadd;
import com.kalimagezi.billionareskb.jobadd.JobaddService;
import com.kalimagezi.billionareskb.message.Message;
import com.kalimagezi.billionareskb.message.MessageService;
import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;
import com.kalimagezi.billionareskb.opinion.Opinion;
import com.kalimagezi.billionareskb.opinion.OpinionService;
import com.kalimagezi.billionareskb.recomendations.Recommendations;
import com.kalimagezi.billionareskb.recomendations.RecommendationsService;
import com.kalimagezi.billionareskb.review.Review;
import com.kalimagezi.billionareskb.review.ReviewService;
import com.kalimagezi.billionareskb.skillTalent.SkillTalent;
import com.kalimagezi.billionareskb.skillTalent.SkillTalentService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CareerService careerService;
	@Autowired
	private EducationService educationService;
	@Autowired
	private SkillTalentService skillTalentService;
	@Autowired
	private EventService eventService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private OpinionService opinionService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private JobaddService jobaddService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private AnalysisService analysisService;
	@Autowired
	private RecommendationsService recommendationsServices;

	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin";
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Counter counter =counterService.getUCounter(user.getId());
		counter.setNoVotes(counter.getNoVotes()+1);
		
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome back to Billionares");
		mv.addObject("ModeLogged", true);

		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career career = careerService.getUCareer(user.getId());
		Education education = educationService.getUEducation(user.getId());
		SkillTalent skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event event = eventService.getUEvent(user.getId());
		
		Counter counter = counterService.getUCounter(user.getId());
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		counterService.addCounter(counter);
		Notification notification = notificationService.getNotificationByUid(user.getId());

		mv.addObject(user);
		mv.addObject(category);
		mv.addObject(address);
		mv.addObject(company);
		mv.addObject(career);
		mv.addObject(education);
		mv.addObject(skillTalent);
		mv.addObject(event);
		mv.addObject(counter);
		mv.addObject(notification);

		if (address.getCountry() == null || company.getName() == null || career.getJobTitle() == null
				|| education.getLevel() == null || skillTalent.getName1() == null || event.getEname() == null) {

			mv.addObject("ModeNotUpdated", true);
		}
		mv.setViewName("index2");

		

		return mv;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin(@RequestParam(name = "advertDisabled", required = false) String advertDisabled,
			@RequestParam(name = "advertEnabled", required = false) String advertEnabled ,
	@RequestParam(name = "resetCounter", required = false) String resetCounter) 
	
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
        int noNewAdds=0;
        int noEnabledAdds=0;
        int noAllUsers=0;
        int totalCash=0;
        Notification notification = notificationService.getNotificationByUid(user.getId());
		List<Advert> disAdds = advertService.getAllDisabledAdverts();
		List<Advert> enabAdds = advertService.getAllEnabledAdverts();
		for(Advert eadds:enabAdds) {
			noEnabledAdds++;
		}
		for(Advert disAdd:disAdds) {
			
			if(disAdd.getIsNew().equals("new")) {
				noNewAdds++;
			}
		}
		notification.setMessage(noNewAdds);
		List<User> users=userService.getAllUsers();
		for(User user1:users) {
			noAllUsers++;
		}
		List<Advert> allAdverts = advertService.getAllAdverts();
		for(Advert add: allAdverts) {
			
			if(add.getIsNew().equals("")) {
				totalCash+=add.getAdvertAmount();
			}
		}
		
		
		

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome admin");
		mv.addObject("ModeLogged", true);
		mv.addObject("disAdds", disAdds);
		mv.addObject("enabAdds", enabAdds);
		mv.addObject("noEnabledAdds", noEnabledAdds);
		mv.addObject("noNewAdds", noNewAdds);
		mv.addObject("noAllUsers", noAllUsers);
		mv.addObject("totalCash", totalCash);
		mv.addObject(notification);
		if (advertEnabled != null) {

			mv.addObject("message", "<b>The advert was successfully Enabled</b>");
			mv.addObject("advertEnabled", true);

		}
		if (advertDisabled != null) {

			mv.addObject("message", "<b>The advert was successfully Disabled</b>");
			mv.addObject("advertDisabled", true);

		}
		if (resetCounter != null) {
			
			mv.addObject("message", "<b>All counters have been reset</b>");
			mv.addObject("advertDisabled", true);

			
		}
		mv.setViewName("index");
		return mv;

	}

	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String getChart(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Notification notification = notificationService.getNotificationByUid(user.getId());
		notification.setChart(0);
		notificationService.addNotification(notification);

		return "/shared/chart";
	}

	@RequestMapping(value = "/mainpost", method = RequestMethod.GET)
	public String getMainpost(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Notification notification = notificationService.getNotificationByUid(user.getId());
		notification.setChart(0);
		notificationService.addNotification(notification);

//		

		return "/shared/mainpost";
	}

	@RequestMapping(value = "/opinions", method = RequestMethod.GET)
	public String getOpinions(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
//		Notification  notification = notificationService.getNotificationByUid(user.getId());
//		notification.setChart(0);
//		notificationService.addNotification(notification);
//		

//		

		return "/shared/mainpost2";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(Model model, Integer wuid) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		User wuser = userService.getUser(wuid).orElseThrow(null);
		Notification notification = notificationService.getNotificationByUid(user.getId());
		notification.setMessage(0);
		notificationService.addNotification(notification);

		String scatid = "0";
		Integer uid = user.getId();
		if (user.getId() < wuid) {

			scatid = uid.toString() + wuid;
		} else {
			scatid = wuid.toString() + uid;
		}
		int catid = Integer.parseInt(scatid);

		List<Message> messages = messageService.getMessageByCatid(catid);
		model.addAttribute("myMassages", messages);

		model.addAttribute("user", user);
		model.addAttribute("wuid", wuid);
		model.addAttribute("wFullName", wuser.getFirstName() + " " + wuser.getOtherNames());
		model.addAttribute("wImageLink", wuser.getImageLink());

		model.addAttribute("notification", notification);

		model.addAttribute("title", "Message");
		model.addAttribute("modeMessage", true);

		return "/shared/chat";

	}

	@RequestMapping(value = "/articleReact", method = RequestMethod.GET)
	public String articleReact(Model model, Integer id) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Notification notification = notificationService.getNotificationByUid(user.getId());
		notification.setMessage(0);
		notificationService.addNotification(notification);
		Article article = articleService.getArticle(id).orElseThrow(null);
		User user2 = userService.getUser(article.getUid()).orElseThrow(null);

		Display display = new Display();

		List<Opinion> opinions = opinionService.getOpinionsByAid(article.getId());

		display.setFullName(user2.getFirstName() + " " + user2.getOtherNames());
		display.setUserImageLink(user2.getImageLink());
		display.setArtDescription(article.getDescription());
		display.setArtImageLink(article.getImageLink());
		display.setArtCreateDate(article.getCreateDate());
		display.setNoOpinions(article.getNoOpinions());
		display.setNoReports(article.getNoReports());
		display.setNoVotes(article.getNoVotes());
		display.setUid(user2.getId());
		display.setCatid(article.getCatId());
		display.setArtid(article.getId());
		display.setArtVideoLink(article.getVideoLink());

		List<DisplayOpinion> dopinions = new ArrayList<DisplayOpinion>();

		for (Opinion opinion : opinions) {
			User user3 = userService.getUser(opinion.getUid()).orElseThrow(null);

			DisplayOpinion dopinion = new DisplayOpinion();

			dopinion.setFullName(user3.getFirstName() + " " + user3.getOtherNames());
			dopinion.setOpCreateDate(opinion.getCreateDate());
			dopinion.setOpDescription(opinion.getDescription());
			dopinion.setOpImageLink(user3.getImageLink());
			dopinion.setOpUid(opinion.getUid());

			dopinions.add(dopinion);

		}

		display.setOpinions(dopinions);

		model.addAttribute("notification", notification);
		model.addAttribute("display", display);

		model.addAttribute("title", "Message");
		model.addAttribute("articleReact", true);

		return "/shared/mainpost3";

	}

	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ModelAndView events() {
		User user;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user = userService.findByEmail(authentication.getName());

		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		ModelAndView mv = new ModelAndView();

		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career career = careerService.getUCareer(user.getId());
		Education education = educationService.getUEducation(user.getId());
		SkillTalent skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event event = eventService.getUEvent(user.getId());
		Counter counter = counterService.getUCounter(user.getId());
		Notification notification = notificationService.getNotificationByUid(user.getId());
		notification.setEvents(0);
		notificationService.addNotification(notification);

		mv.addObject(user);

		mv.addObject(category);
		mv.addObject(address);
		mv.addObject(company);
		mv.addObject(career);
		mv.addObject(education);
		mv.addObject(skillTalent);
		mv.addObject(event);
		mv.addObject(counter);
		mv.addObject(notification);

		mv.addObject("greeting", "Welcome to live chat");
		mv.addObject("modeEvents", true);
		mv.setViewName("index2");

		return mv;

	}

	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public ModelAndView jobss() {
		User user;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user = userService.findByEmail(authentication.getName());

		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		ModelAndView mv = new ModelAndView();

		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career career = careerService.getUCareer(user.getId());
		Education education = educationService.getUEducation(user.getId());
		SkillTalent skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event event = eventService.getUEvent(user.getId());
		Counter counter = counterService.getUCounter(user.getId());
		Notification notification = notificationService.getNotificationByUid(user.getId());
		notification.setJobad(0);
		notificationService.addNotification(notification);

		mv.addObject(user);

		mv.addObject(category);
		mv.addObject(address);
		mv.addObject(company);
		mv.addObject(career);
		mv.addObject(education);
		mv.addObject(skillTalent);
		mv.addObject(event);
		mv.addObject(counter);
		mv.addObject(notification);

		mv.addObject("greeting", "Welcome to live chat");
		mv.addObject("modeJobs", true);
		mv.setViewName("index2");

		return mv;

	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfile(Model model, Integer wuid) {

		User user;
		if (wuid != null) {
			user = userService.getUser(wuid).orElseThrow(null);

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userService.findByEmail(authentication.getName());
		}
		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career career = careerService.getUCareer(user.getId());
		Education education = educationService.getUEducation(user.getId());
		SkillTalent skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event event = eventService.getUEvent(user.getId());
		Counter counter = counterService.getUCounter(user.getId());
		Notification notification = notificationService.getNotificationByUid(user.getId());

		model.addAttribute("user", user);

		model.addAttribute("category", category);
		model.addAttribute("address", address);
		model.addAttribute("company", company);
		model.addAttribute("career", career);
		model.addAttribute("education", education);
		model.addAttribute("skillTalent", skillTalent);
		model.addAttribute("event", event);
		model.addAttribute("counter", counter);
		model.addAttribute("notification", notification);

		model.addAttribute("title", "profile");
		model.addAttribute("modeProfile", true);

		return "/shared/profile";
	}

	@RequestMapping(value = "/profile-print", method = RequestMethod.GET)
	public ModelAndView printprofile(@RequestParam(name = "wuid", required = false) Integer wuid) {

		User user;
		if (wuid != null) {
			user = userService.getUser(wuid).orElseThrow(null);

		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userService.findByEmail(authentication.getName());
		}
		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		ModelAndView mv = new ModelAndView();

		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career career = careerService.getUCareer(user.getId());
		Education education = educationService.getUEducation(user.getId());
		SkillTalent skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event event = eventService.getUEvent(user.getId());
		Counter counter = counterService.getUCounter(user.getId());

		mv.addObject(user);

		mv.addObject(category);
		mv.addObject(address);
		mv.addObject(company);
		mv.addObject(career);
		mv.addObject(education);
		mv.addObject(skillTalent);
		mv.addObject(event);
		mv.addObject(counter);

		mv.addObject("modeProfile", true);
		mv.setViewName("print");

		return mv;

	}

	@ModelAttribute("displays")
	public List<Display> getDisplay() {
		List<Display> displays = new ArrayList<Display>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);

		List<Article> articles = articleService.getArticlesByCat(category.getCatid());

		for (Article article : articles) { 
			Display display = new Display();

			User user2 = userService.getUser(article.getUid()).orElseThrow(null);
			List<Opinion> opinions = opinionService.getOpinionsByAid(article.getId());

			display.setFullName(user2.getFirstName() + " " + user2.getOtherNames());
			display.setUserImageLink(user2.getImageLink());
			display.setArtDescription(article.getDescription());
			display.setArtImageLink(article.getImageLink());
			display.setArtCreateDate(article.getCreateDate());
			display.setNoOpinions(article.getNoOpinions());
			display.setNoReports(article.getNoReports());
			display.setNoVotes(article.getNoVotes());
			display.setUid(user2.getId());
			display.setCatid(article.getCatId());
			display.setArtid(article.getId());
			display.setArtVideoLink(article.getVideoLink());

			List<DisplayOpinion> dopinions = new ArrayList<DisplayOpinion>();

			for (Opinion opinion : opinions) {
				User user3 = userService.getUser(opinion.getUid()).orElseThrow(null);

				DisplayOpinion dopinion = new DisplayOpinion();

				dopinion.setFullName(user3.getFirstName() + " " + user3.getOtherNames());
				dopinion.setOpCreateDate(opinion.getCreateDate());
				dopinion.setOpDescription(opinion.getDescription());
				dopinion.setOpImageLink(user3.getImageLink());
				dopinion.setOpUid(opinion.getUid());

				dopinions.add(dopinion);

			}

			display.setOpinions(dopinions);

			displays.add(display);
		}

		return displays;

	}

	@ModelAttribute("displayadds")
	public List<DisplayAdd> getDisplayadd() {
		List<DisplayAdd> displayadds = new ArrayList<DisplayAdd>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Category category = categoryService.getCategory(user.getCatid()).orElseThrow(null);
		
		List<Advert> catadverts = advertService.getAllEnabledAdvertsByCat(category.getCatid());
		

		for (Advert advert : catadverts) {
			DisplayAdd displayAdd = new DisplayAdd();
			displayAdd.setId(advert.getId());
			displayAdd.setUid(advert.getUid());
			displayAdd.setItemAmount(advert.getItemAmount());
			displayAdd.setTitle(advert.getTitle());
			displayAdd.setDescription(advert.getDescription());
			displayAdd.setImageLink(advert.getImageLink());
			displayAdd.setNoClicks(advert.getNoClicks());
			displayAdd.setNoReviews(advert.getNoReviews());
			displayAdd.setNoPositives(advert.getNoPositives());
			displayAdd.setNoNegatives(advert.getNoNegatives());
			displayAdd.setNoDays(advert.getNoDays());
			displayAdd.setWebsite(advert.getWebsite());
			displayAdd.setIsNew(advert.getIsNew());

			List<DisplayReview> dreviews = new ArrayList<DisplayReview>();

			List<Review> reviews = reviewService.getAReviews(advert.getId());
			for (Review review : reviews) {
				User user3 = userService.getUser(review.getUid()).orElseThrow(null);

				DisplayReview dreview = new DisplayReview();

				dreview.setFullName(user3.getFirstName() + " " + user3.getOtherNames());
				dreview.setrCreateDate(review.getCreateDate());
				dreview.setrDescription(review.getDescription());
				dreview.setrImageLink(user3.getImageLink());
				dreview.setrUid(review.getUid());

				dreviews.add(dreview);

			}

			displayAdd.setDreviews(dreviews);

			displayadds.add(displayAdd);
		}

		return displayadds;

	}

	@ModelAttribute("topCounter")
	private Counter getTopCounter() {

		Counter topCounter = counterService.getTopCounter();

		return topCounter;

	}

		
		


	@ModelAttribute("topCatCounter")
	private Counter getTopCatCounter() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());

		Counter topCatCounter = counterService.getTopCatCounter(user.getCatid());

		return topCatCounter;
	}
	@ModelAttribute("userCat")
	private Category getUserCat() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Category category=categoryService.getCategory(user.getCatid()).orElseThrow(null);
	
		
		return category;
	}

	@ModelAttribute("top10CatCounters")
	private List<DisplayCounter> getTop10CatCounter() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());

		List<Counter> top10CatCounters = counterService.getTop10CatCounter(user.getCatid());
		List<DisplayCounter> dcounters = new ArrayList<DisplayCounter>();
		int i = 0;
		int totals = 0;
		int percentage = 0;
		String[] colors = { "progress-bar-success", "progress-bar-info", "progress-bar-warning", "progress-bar-danger",
				"progress-bar-success progress-bar-striped", "progress-bar-info progress-bar-striped", "progress-bar-warning progress-bar-striped", "progress-bar-danger progress-bar-striped",
				"progress-bar-success", "progress-bar-info" };
		for (Counter counter : top10CatCounters) {
			totals += counter.getTotal();
		}

		for (Counter counter : top10CatCounters) {
			i++;
			DisplayCounter dcounter = new DisplayCounter();
			dcounter.setSnumber(i);
			User nuser = userService.getUser(counter.getUid()).orElseThrow(null);

			dcounter.setFullName(nuser.getFirstName() + " " + nuser.getOtherNames());
			percentage = (counter.getTotal() * 100) / totals;
			dcounter.setTotal(counter.getTotal());
			dcounter.setPercentage(percentage);
			dcounter.setColor(colors[i - 1]);

			dcounters.add(dcounter);

		}

		return dcounters;
	}

	@ModelAttribute("top10Counters")
	private List<DisplayCounter> getTop10Counter() {

		List<Counter> top10Counters = counterService.getTop10Counter();
		List<DisplayCounter> dcounters = new ArrayList<DisplayCounter>();
		int i = 0;
		int totals = 0;
		int percentage = 0;
		String[] colors = { "progress-bar-success", "progress-bar-info", "progress-bar-warning", "progress-bar-danger",
				"progress-bar-success progress-bar-striped", "progress-bar-info progress-bar-striped", "progress-bar-warning progress-bar-striped", "progress-bar-danger progress-bar-striped",
				"progress-bar-success", "progress-bar-info" };
		for (Counter counter : top10Counters) {
			totals += counter.getTotal();
		}

		for (Counter counter : top10Counters) {
			if(counter.getCid()!=1) {
			i++;
			DisplayCounter dcounter = new DisplayCounter();
			dcounter.setSnumber(i);
			User nuser = userService.getUser(counter.getUid()).orElseThrow(null);
			Category category = categoryService.getCategory(nuser.getCatid()).orElseThrow(null);
			dcounter.setFullName(nuser.getFirstName() + " " + nuser.getOtherNames());
			percentage = (counter.getTotal() * 100) / totals;
			dcounter.setCategory(category.getCatName());
			dcounter.setPercentage(percentage);
			dcounter.setColor(colors[i - 1]);
            dcounter.setTotal(counter.getTotal());
			dcounters.add(dcounter);
			}

		}

		return dcounters;
	}

	@ModelAttribute("dcatEvents")
	private List<Devent> getCatEvent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());

		List<Event> events = eventService.getCatEvents(user.getCatid());

		List<Devent> devents = new ArrayList<Devent>();

		for (Event event : events) {
			Devent devent = new Devent();
			if(event.getEname()!=null) {
			devent.setEname(event.getEname());
			devent.setDescription(event.getDescription());
			devent.setEventDate(event.getEventDate());
			devent.setGoing(event.getGoing());
			devent.setId(event.getId());
			devent.setImageLink(event.getImageLink());
			devent.setNotGoing(event.getNotGoing());
			devent.setUid(event.getUid());
			devent.setNoAnalysis(event.getNoAnalyis());
						
			User euser = userService.getUser(event.getUid()).orElseThrow(null);
			devent.setByname(euser.getFirstName() + " " + euser.getOtherNames());

			List<DisplayAnalysis> danalysiss = new ArrayList<DisplayAnalysis>();

			List<Analysis> analysiss = analysisService.getAnalysissByEid(event.getId());
			
			for (Analysis analysis : analysiss) {
				User user3 = userService.getUser(analysis.getUid()).orElseThrow(null);

				DisplayAnalysis danalysis = new DisplayAnalysis();

				danalysis.setFullName(user3.getFirstName() + " " + user3.getOtherNames());
				danalysis.setaCreateDate(analysis.getCreateDate());
				danalysis.setaDescription(analysis.getDescription());
				danalysis.setaImageLink(user3.getImageLink());
				danalysis.setaUid(analysis.getUid());

				danalysiss.add(danalysis);

			}
			
			
			devent.setDanalysiss(danalysiss);
			
			devents.add(devent);
			
			
			}
			
		}
		
		

		return devents;

	}

	@ModelAttribute("dcatJobadds")
	private List<DisplayJobAdd> getDCatJobs() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());

		List<Jobadd> catJobadds = jobaddService.getCatJobadd(user.getCatid());
		
		List<DisplayJobAdd> dcatJobadds = new ArrayList<DisplayJobAdd>();
		
		for (Jobadd catjobadd : catJobadds) {
			DisplayJobAdd dcatJobadd = new DisplayJobAdd();
			if(catjobadd.getJobTitle()!=null) {
				dcatJobadd.setJaid(catjobadd.getId());
				dcatJobadd.setJauid(catjobadd.getUid());
				dcatJobadd.setCompName(catjobadd.getCompName());
				dcatJobadd.setAdByName(user.getFirstName()+ " "+user.getOtherNames());
				dcatJobadd.setCompWeb(catjobadd.getCompWeb());
				dcatJobadd.setJobTitle(catjobadd.getJobTitle());
				dcatJobadd.setDescription(catjobadd.getDescription());
				dcatJobadd.setImageLink(catjobadd.getImageLink());
				dcatJobadd.setJobCategory(catjobadd.getJobCategory());
				dcatJobadd.setSalary(catjobadd.getSalary());
				dcatJobadd.setNoPositions(catjobadd.getNoPositions());
				dcatJobadd.setAddDate(catjobadd.getAddDate());
				dcatJobadd.setDeadline(catjobadd.getDeadline());
				dcatJobadd.setNoRecomendations(catjobadd.getNoRecomends());
				dcatJobadd.setNoRecom(catjobadd.getRecomended());
				dcatJobadd.setNoNotRecom(catjobadd.getNotRecomended());
				

			List<Recommendations> recommends = recommendationsServices.getRecommendationssByJaid(catjobadd.getId());
			List<DisplayWrittenReco> dRecommends = new ArrayList<DisplayWrittenReco>();
			for (Recommendations recommend : recommends) {
				
				User user3 = userService.getUser(recommend.getUid()).orElseThrow(null);

				DisplayWrittenReco drecomend = new DisplayWrittenReco();

				drecomend.setFullName(user3.getFirstName() + " " + user3.getOtherNames());
				drecomend.setrCreateDate(recommend.getCreateDate());
				drecomend.setrDescription(recommend.getDescription());
				drecomend.setrImageLink(user3.getImageLink());
				drecomend.setrUid(recommend.getUid());

				dRecommends.add(drecomend);

			}
			
			
			dcatJobadd.setDwRecos(dRecommends);
			
			dcatJobadds.add(dcatJobadd);
			
			
			}
			
		}


		return dcatJobadds;

	}

	@ModelAttribute("dmessages")
	private List<Dmessage> getTopmessage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		List<Message> topmessages = messageService.getMessageWuid(user.getId());

		List<Dmessage> dmessages = new ArrayList<Dmessage>();
		Dmessage dmessage = new Dmessage();
		for (Message message : topmessages) {

			dmessage.setDuid(message.getUid());
			User muser = userService.getUser(message.getUid()).orElseThrow(null);
			dmessage.setDfullName(muser.getFirstName() + " " + muser.getOtherNames());
			dmessage.setDimageLink(muser.getImageLink());
			dmessage.setDmdate(message.getMdate());
			dmessage.setDmessage(message.getMessage());

			dmessages.add(dmessage);

		}

		return dmessages;

	}
	@ModelAttribute("dtopmessages")
	private List<Dmessage> getTopNewmessage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		List<Message> Ntopmessages = messageService.getMessageWuid(user.getId());	
		List<Dmessage> dtmessages = (List<Dmessage>) new CopyOnWriteArrayList<Dmessage>();

		
		
		for (Message message : Ntopmessages) {
			Dmessage dtmessage = new Dmessage();
			if (dtmessages.isEmpty()) {
				dtmessage.setDuid(message.getUid());
				User muser = userService.getUser(message.getUid()).orElseThrow(null);
				dtmessage.setDfullName(muser.getFirstName() + " " + muser.getOtherNames());
				dtmessage.setDimageLink(muser.getImageLink());
				dtmessage.setDmdate(message.getMdate());
				dtmessage.setDmessage(message.getMessage());
				
				dtmessages.add(dtmessage);
			
			} else {
							
			for (Dmessage dnmessage: dtmessages) {
				if (dnmessage.getDuid()!=message.getUid()) {
					dtmessage.setDuid(message.getUid());
					User muser = userService.getUser(message.getUid()).orElseThrow(null);
					dtmessage.setDfullName(muser.getFirstName() + " " + muser.getOtherNames());
					dtmessage.setDimageLink(muser.getImageLink());
					dtmessage.setDmdate(message.getMdate());
					dtmessage.setDmessage(message.getMessage());					
					dtmessages.add(dtmessage);
					
				}
			}
			}
		}
		
	
		return dtmessages;
		
	}

	@ModelAttribute("cUsers")
	private List<User> getCatUsers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());

		List<User> cUsers = userService.getAllByCatid(user.getCatid());

		return cUsers;

	}

	@ModelAttribute("noCUsers")
	private int getNoCatUsers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());

		List<User> cUsers = userService.getAllByCatid(user.getCatid());
		int noCUsers = 0;
		for (User cuser : cUsers) {

			noCUsers++;
		}

		return noCUsers;

	}

}
