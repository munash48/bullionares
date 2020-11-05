package com.kalimagezi.billionareskb.home;

import java.util.ArrayList;
import java.util.List;

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
	
	 @RequestMapping("/default")
	    public String defaultAfterLogin(HttpServletRequest request) {
	        if (request.isUserInRole("ROLE_ADMIN")) {
	            return "redirect:/admin";
	        }
	        return "redirect:/home";
	    }
  
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(name = "imgupload", required = false) String imgupload,
			@RequestParam(name = "userupdate", required = false) String userupdate,
			@RequestParam(name = "addressupdate", required = false) String addressupdate,
			@RequestParam(name = "companyupdate", required = false) String companyupdate,
			@RequestParam(name = "careerupdate", required = false) String careerupdate,
			@RequestParam(name = "educationupdate", required = false) String educationupdate,
			@RequestParam(name = "skillupdate", required = false) String skillupdate,
			@RequestParam(name = "updateAboutme", required = false) String updateAboutme,
			@RequestParam(name = "eventupdate", required = false) String eventupdate,
			@RequestParam(name = "articleCreated", required = false) String articleCreated,
			@RequestParam(name = "opinionCreated", required = false) String opinionCreated,
			@RequestParam(name = "voteAdded", required = false) String voteAdded,
			@RequestParam(name = "voteFailed", required = false) String voteFailed,
			@RequestParam(name = "reportFailed", required = false) String reportFailed,
			@RequestParam(name = "reportAdded", required = false) String reportAdded,
			@RequestParam(name = "advertAdded", required = false) String advertAdded,
			@RequestParam(name = "articleEmpty", required = false) String articleEmpty,
			@RequestParam(name = "opinionNotCreated", required = false) String opinionNotCreated,
			@RequestParam(name = "ReviewCreated", required = false) String ReviewCreated,
			@RequestParam(name = "ReviewNotCreated", required = false) String ReviewNotCreated,
			@RequestParam(name = "positiveFailed", required = false) String positiveFailed,
			@RequestParam(name = "negativeFailed", required = false) String negativeFailed,
			@RequestParam(name = "negativeAdded", required = false) String negativeAdded,
			@RequestParam(name = "positiveAdded", required = false) String positiveAdded,
			@RequestParam(name = "reviewFailed", required = false) String reviewFailed,
			@RequestParam(name = "goingFailed", required = false) String goingFailed,
			@RequestParam(name = "goingAdded", required = false) String goingAdded,
			@RequestParam(name = "notGoingFailed", required = false) String notGoingFailed,
			@RequestParam(name = "notGoingAdded", required = false) String notGoingAdded,
			@RequestParam(name = "jobaddAdded", required = false) String jobaddAdded,
			@RequestParam(name = "userinvited", required = false) String userinvited,
			@RequestParam(name = "inviteFailed", required = false) String inviteFailed,
			@RequestParam(name = "userExists", required = false) String userExists,
			@RequestParam(name = "recomendFailed", required = false) String recomendFailed,
			@RequestParam(name = "recomendAdded", required = false) String recomendAdded,
			@RequestParam(name = "notRecomendFailed", required = false) String notRecomendFailed,
			@RequestParam(name = "notRecomendAdded", required = false) String notRecomendAdded
					
			
			) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 User user = userService.findByEmail(authentication.getName());
		 Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome back to Billionares");
		mv.addObject("ModeLogged", true);
		 	 
	    Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
	    Company company = companyService.getUCompany(user.getId());
	    Career  career = careerService.getUCareer(user.getId());
	    Education  education = educationService.getUEducation(user.getId());
	    SkillTalent  skillTalent = skillTalentService.getUSkillTalent(user.getId());
	    Event  event = eventService.getUEvent(user.getId());
	    Counter  counter = counterService.getUCounter(user.getId());
	    Notification  notification = notificationService.getNotificationByUid(user.getId());
	    
	    
	    
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
		
		if(address.getCountry()==null||company.getName()==null||career.getJobTitle()==null||education.getLevel()==null ||
				skillTalent.getName1()==null||event.getEname()==null) {
			
			mv.addObject("ModeNotUpdated", true);
		}


		if (imgupload == null && userupdate == null && addressupdate==null && companyupdate == null && careerupdate == null
				
				&& educationupdate == null && skillupdate==null && updateAboutme==null && eventupdate==null && opinionCreated==null
				&& voteAdded==null && voteFailed==null && reportFailed==null&& reportAdded==null &&articleCreated==null &&advertAdded==null&&articleEmpty==null
				&&opinionNotCreated==null&&ReviewCreated==null&&ReviewNotCreated==null&&positiveFailed==null
				&&negativeFailed==null&&negativeAdded==null&&positiveAdded==null&&reviewFailed==null&& goingFailed==null&&goingAdded==null
				&&notGoingFailed==null&&notGoingAdded==null&&jobaddAdded==null&& userinvited==null&&inviteFailed==null&&userExists==null
				&& recomendAdded==null&&recomendFailed==null&&notRecomendAdded==null&&notRecomendFailed==null) {
			mv.addObject("ModeJustLogged", true);
		}
		mv.setViewName("index2");
		if (imgupload != null) {

			mv.addObject("imgupload", "<b>Your profile image has been updated </b>");
			mv.addObject("ModeImgUpload", true);

		}
		if (userupdate != null) {

			mv.addObject("imgupload", "<b>Your Bio Data has been updated</b>");
			mv.addObject("ModeImgUpload", true);

		}
		if (addressupdate != null) {

			mv.addObject("imgupload", "<b>Your Address has been updated</b>");
			mv.addObject("ModeImgUpload", true);

		}
		if (companyupdate != null) {

			mv.addObject("imgupload", "<b>Your Company Attachement has been updated</b>");
			mv.addObject("ModeImgUpload", true);

		}
		if (careerupdate != null) {

			mv.addObject("imgupload", "<b>Your Career Info has been updated</b>");
			mv.addObject("ModeImgUpload", true);

		}
		if (educationupdate != null) {
			
			mv.addObject("imgupload", "<b>Your Education Info has been updated</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (skillupdate != null) {
			
			mv.addObject("imgupload", "<b>Your Skills and Tallent Info has been updated</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (updateAboutme != null) {
			
			mv.addObject("imgupload", "<b>Your About me Info has been updated</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (eventupdate != null) {
			
			mv.addObject("imgupload", "<b>Your Event Info has been updated</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (notGoingAdded != null) {
			
			mv.addObject("imgupload", "<b>Your are not going to that event</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (recomendAdded != null) {
			
			mv.addObject("imgupload", "<b>Your are recomending people for the Job Add</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (opinionCreated != null) {
			
			mv.addObject("imgupload", "<b>Your opinion has been added</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (articleCreated != null) {
			
			mv.addObject("imgupload", "<b>Your new article has been added</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (userinvited != null) {
			
			mv.addObject("imgupload", "<b>your invitation to billionres has been sent</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (ReviewCreated != null) {
			
			mv.addObject("imgupload", "<b>Your Advert Review has been added</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (jobaddAdded != null) {
			
			mv.addObject("imgupload", "<b>Your Job Advert has been created</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (voteFailed != null) {
			mv.addObject("votefail", "<b>You already voted on  that article </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (userExists != null) {
			mv.addObject("votefail", "<b>The user you are trying to invite already exists </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (goingFailed != null) {
			mv.addObject("votefail", "<b>You already decided on that event </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (notGoingFailed != null) {
			mv.addObject("votefail", "<b>You already not Going to that event </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (recomendFailed != null) {
			mv.addObject("votefail", "<b>You already sent your recomendation</b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (notRecomendFailed != null) {
			mv.addObject("votefail", "<b>You already sent your NOT recomendation</b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (reviewFailed != null) {
			mv.addObject("votefail", "<b>You already reviewed the advert!!! </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (negativeFailed != null) {
			mv.addObject("votefail", "<b>You already Reviewed that advert </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (positiveFailed != null) {
			mv.addObject("votefail", "<b>You already reviewed  that advert </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (ReviewNotCreated != null) {
			mv.addObject("votefail", "<b>You Advert Review Cant be Empty!! </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (opinionNotCreated != null) {
			mv.addObject("votefail", "<b>Opinion can not be empty </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (reportFailed != null) {
			mv.addObject("votefail", "<b>You already crossed the same article </b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (inviteFailed != null) {
			mv.addObject("votefail", "<b>the invitation failed, check email, could already be invited</b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}
		if (voteAdded != null) {
	

			mv.addObject("imgupload", "<b>Your Vote has been Counted</b>");
			mv.addObject("ModeImgUpload", true);

		}
		if (negativeAdded != null) {
			
			
			mv.addObject("imgupload", "<b>Your negative Review has been added</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (goingAdded != null) {
			
			
			mv.addObject("imgupload", "<b>Your are going to the event</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (notRecomendAdded != null) {
			
			
			mv.addObject("imgupload", "<b>Your are NOT Recomending this advert</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (positiveAdded != null) {
			
			
			mv.addObject("imgupload", "<b>Your positive Review has been added</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (reportAdded != null) {
			
			
			mv.addObject("imgupload", "<b>Your Cross has been Counted</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (advertAdded != null) {
			
			
			mv.addObject("imgupload", "<b>Your paid advert has been created. Awaiting activation</b>");
			mv.addObject("ModeImgUpload", true);
			
		}
		if (articleEmpty != null) {
			
			
			mv.addObject("votefail", "<b>Article cant be empty !!</b>");
			mv.addObject("ModeJustFailedVote", true);
			
		}

		return mv;

	}



	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin(@RequestParam(name = "advertDisabled", required = false) String advertDisabled,@RequestParam(name = "advertEnabled", required = false) String advertEnabled) {
		
		List <Advert> disAdds = advertService.getAllDisabledAdverts();
		List <Advert> enabAdds = advertService.getAllEnabledAdverts();
	

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome admin");
		mv.addObject("ModeLogged", true);
		mv.addObject("disAdds",disAdds);
		mv.addObject("enabAdds",enabAdds);
      if (advertEnabled != null) {
			
			
			mv.addObject("message", "<b>The advert was successfully Enabled</b>");
			mv.addObject("advertEnabled", true);
			
		}
      if (advertDisabled != null) {
    	  
    	  
    	  mv.addObject("message", "<b>The advert was successfully Disabled</b>");
    	  mv.addObject("advertDisabled", true);
    	  
      }
		mv.setViewName("index");
		return mv;

	}
	

	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public String getChart(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Notification  notification = notificationService.getNotificationByUid(user.getId());
		notification.setChart(0);
		notificationService.addNotification(notification);
		

		return "/shared/chart";
	}
	@RequestMapping(value = "/mainpost", method = RequestMethod.GET)
	public String getMainpost(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		Notification  notification = notificationService.getNotificationByUid(user.getId());
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
		
		return "/shared/opinions";
	}
	

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(Model model, Integer wuid) {
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 User user = userService.findByEmail(authentication.getName());
		 Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);
		 	 

	    User wuser=userService.getUser(wuid).orElseThrow(null);
	    Notification  notification = notificationService.getNotificationByUid(user.getId());
		notification.setMessage(0);
		notificationService.addNotification(notification);
	    
	    String scatid="0";
	    Integer uid=user.getId();
		if (user.getId()<wuid) {
		
		scatid =uid.toString()+wuid;
		} else {
			scatid=wuid.toString()+uid;	
		}
		int catid = Integer.parseInt(scatid);
		
	    List <Message> messages= messageService.getMessageByCatid(catid);
	    model.addAttribute("myMassages",messages);
	    
	    model.addAttribute("user",user);
	    model.addAttribute("wuid",wuid);
	    model.addAttribute("wFullName", wuser.getFirstName()+ " "+wuser.getOtherNames());
	    model.addAttribute("wImageLink", wuser.getImageLink());
	   
		model.addAttribute("notification",notification);
		
		model.addAttribute("title", "Message");
		model.addAttribute("modeMessage", true);		
		
		return "/shared/chat";
		
	}
	
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ModelAndView events() {
		User user;

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userService.findByEmail(authentication.getName());
		
		Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);
		
		ModelAndView mv = new ModelAndView();
		
		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career  career = careerService.getUCareer(user.getId());
		Education  education = educationService.getUEducation(user.getId());
		SkillTalent  skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event  event = eventService.getUEvent(user.getId());
		Counter  counter = counterService.getUCounter(user.getId());
		Notification  notification = notificationService.getNotificationByUid(user.getId());
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
		
		Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);
		
		ModelAndView mv = new ModelAndView();
		
		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career  career = careerService.getUCareer(user.getId());
		Education  education = educationService.getUEducation(user.getId());
		SkillTalent  skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event  event = eventService.getUEvent(user.getId());
		Counter  counter = counterService.getUCounter(user.getId());
		Notification  notification = notificationService.getNotificationByUid(user.getId());
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
		if (wuid!=null) {
			user=userService.getUser(wuid).orElseThrow(null);
			
		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userService.findByEmail(authentication.getName());
		}
		Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);

		
		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career  career = careerService.getUCareer(user.getId());
		Education  education = educationService.getUEducation(user.getId());
		SkillTalent  skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event  event = eventService.getUEvent(user.getId());
		Counter  counter = counterService.getUCounter(user.getId());
		Notification  notification = notificationService.getNotificationByUid(user.getId());
		
		
		model.addAttribute("user",user);
		
		model.addAttribute("category",category);
		model.addAttribute("address",address);
		model.addAttribute("company",company);
		model.addAttribute("career",career);
		model.addAttribute("education",education);
		model.addAttribute("skillTalent",skillTalent);
		model.addAttribute("event",event);
		model.addAttribute("counter",counter);
		model.addAttribute("notification",notification);
	
		
	model.addAttribute("title", "profile");
	model.addAttribute("modeProfile", true);
	
	return "/shared/profile";
}	
	
	
	@RequestMapping(value = "/profile-print", method = RequestMethod.GET)
	public ModelAndView printprofile(@RequestParam(name = "wuid", required = false) Integer wuid) {
		
		
		User user;
		if (wuid!=null) {
			user=userService.getUser(wuid).orElseThrow(null);
		
		} else {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			user = userService.findByEmail(authentication.getName());
		}
		Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);
		
		ModelAndView mv = new ModelAndView();
		
		Address address = addressService.getUAddress(user.getId()).orElseThrow(null);
		Company company = companyService.getUCompany(user.getId());
		Career  career = careerService.getUCareer(user.getId());
		Education  education = educationService.getUEducation(user.getId());
		SkillTalent  skillTalent = skillTalentService.getUSkillTalent(user.getId());
		Event  event = eventService.getUEvent(user.getId());
		Counter  counter = counterService.getUCounter(user.getId());
		
		
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
		List<Display> displays= new ArrayList<Display>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		 Category category =categoryService.getCategory(user.getCatid()).orElseThrow(null);
		 
		 List <Article> articles =articleService.getArticlesByCat(category.getCatid());
		
		 
		 for(Article article: articles) {
			 Display display= new Display();
			 
			 User user2 = userService.getUser(article.getUid()).orElseThrow(null);
			 List <Opinion> opinions =opinionService.getOpinionsByAid(article.getId());
			 
			display.setFullName(user2.getFirstName() +" "+ user2.getOtherNames());
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
			
			List <DisplayOpinion> dopinions= new ArrayList<DisplayOpinion>();
			
			
			for(Opinion opinion: opinions) {
				 User user3 = userService.getUser(opinion.getUid()).orElseThrow(null);
				
				DisplayOpinion dopinion= new DisplayOpinion();
				
				dopinion.setFullName(user3.getFirstName() + " "+ user3.getOtherNames());
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
		List<DisplayAdd> displayadds= new ArrayList<DisplayAdd>();
		
		List <Advert> adverts =advertService.getAllEnabledAdverts();
		
		
		for(Advert advert: adverts) {
			DisplayAdd displayAdd= new DisplayAdd();
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
			
		

			
			List <Review> reviews= new ArrayList<Review>();
			
			reviews= reviewService.getAReviews(advert.getId());
			displayAdd.setReviews(reviews);
			
	
			
			
			displayadds.add(displayAdd);
		}
		
		
		
		return displayadds;
		
	}
	@ModelAttribute("topCounter")
	private Counter getTopCounter() {
		
		Counter topCounter =counterService.getTopCounter();
						
		return topCounter;
		
	}
	@ModelAttribute("topCatCounter")
	private Counter getTopCatCounter() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		
		Counter topCatCounter =counterService.getTopCatCounter(user.getCatid());
		
		return topCatCounter;
	}
	@ModelAttribute("top10CatCounters")
	private List<DisplayCounter> getTop10CatCounter() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		
		List<Counter> top10CatCounters =counterService.getTop10CatCounter(user.getCatid());
		List <DisplayCounter> dcounters= new ArrayList<DisplayCounter>();
		int i=0;
		int totals=0;
		int percentage=0;
		String[] colors = {"progress-bar-success", "progress-bar-info", "progress-bar-warning", "progress-bar-danger","progress-bar-success", 
				           "progress-bar-info", "progress-bar-warning", "progress-bar-danger","progress-bar-success", "progress-bar-info"};
		for(Counter counter: top10CatCounters) {
			totals+=counter.getTotal();
		}
		
		
		for(Counter counter: top10CatCounters) {
			i++;
			DisplayCounter dcounter=new DisplayCounter();
			dcounter.setSnumber(i);
			User nuser=userService.getUser(counter.getUid()).orElseThrow(null);

			dcounter.setFullName(nuser.getFirstName() + " "+ nuser.getOtherNames());
			percentage=(counter.getTotal()*100)/totals;

			dcounter.setPercentage(percentage);
			dcounter.setColor(colors[i-1]);
			
			dcounters.add(dcounter);
				
		}
		
		
		
		return dcounters;
	}
	@ModelAttribute("top10Counters")
	private List<DisplayCounter> getTop10Counter() {

		
		List<Counter> top10Counters =counterService.getTop10Counter();
		List <DisplayCounter> dcounters= new ArrayList<DisplayCounter>();
		int i=0;
		int totals=0;
		int percentage=0;
		String[] colors = {"progress-bar-success", "progress-bar-info", "progress-bar-warning", "progress-bar-danger","progress-bar-success", 
				"progress-bar-info", "progress-bar-warning", "progress-bar-danger","progress-bar-success", "progress-bar-info"};
		for(Counter counter: top10Counters) {
			totals+=counter.getTotal();
		}
		
		
		for(Counter counter: top10Counters) {
			i++;
			DisplayCounter dcounter=new DisplayCounter();
			dcounter.setSnumber(i);
			User nuser=userService.getUser(counter.getUid()).orElseThrow(null);
			Category category =categoryService.getCategory(nuser.getCatid()).orElseThrow(null);
			dcounter.setFullName(nuser.getFirstName() + " "+ nuser.getOtherNames());
			percentage=(counter.getTotal()*100)/totals;
			dcounter.setCategory(category.getCatName());
			dcounter.setPercentage(percentage);
			dcounter.setColor(colors[i-1]);
			
			dcounters.add(dcounter);
			
		}
		
		
		
		return dcounters;
	}
	
	
	
	@ModelAttribute("catEvents")
	private List<Devent> getCatEvent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		
		List<Event> events=eventService.getCatEvents(user.getCatid());
		
		List<Devent> devents= new ArrayList<Devent>();
		
		
		for (Event event: events) {
			Devent devent  = new Devent();
			devent.setEname(event.getEname());
			devent.setDescription(event.getDescription());
			devent.setEventDate(event.getEventDate());
			devent.setGoing(event.getGoing());
			devent.setId(event.getId());
			devent.setImageLink(event.getImageLink());
			devent.setNotGoing(event.getNotGoing());
			devent.setUid(event.getUid());
			User euser= userService.getUser(event.getUid()).orElseThrow(null);
			devent.setByname(euser.getFirstName()+ " "+ euser.getOtherNames());
			
			devents.add(devent);
		}
		
		return devents;
		
	}
	@ModelAttribute("catJobadds")
	private List<Jobadd> getCatJobs() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		
		List<Jobadd> catJobadds=jobaddService.getCatJobadd(user.getCatid());
		
		return catJobadds;
		
	}
	@ModelAttribute("dmessages")
	private List<Dmessage> getTopmessage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		List <Message> topmessages= messageService.getMessageWuid(user.getId());
		
		List<Dmessage> dmessages= new ArrayList<Dmessage>();
		Dmessage dmessage = new Dmessage();
		for(Message message: topmessages) {
			
			dmessage.setDuid(message.getUid());
			User muser = userService.getUser(message.getUid()).orElseThrow(null);
			dmessage.setDfullName(muser.getFirstName()+ " "+muser.getOtherNames());
			dmessage.setDimageLink(muser.getImageLink());
			dmessage.setDmdate(message.getMdate());
			dmessage.setDmessage(message.getMessage());
			
			dmessages.add(dmessage);
			
		}
		
		return dmessages;
		
	}
	
	@ModelAttribute("cUsers")
	private List<User> getCatUsers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
	
		List<User> cUsers=userService.getAllByCatid(user.getCatid());
		
		
		return cUsers;
		
	}
	@ModelAttribute("noCUsers")
	private int getNoCatUsers() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(authentication.getName());
		
		List<User> cUsers=userService.getAllByCatid(user.getCatid());
		int noCUsers=0;
		for(User cuser: cUsers) {
			
			noCUsers++;
		}
			
		
		return noCUsers;
		
	}
	
	
	
	

}
