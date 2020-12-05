package com.kalimagezi.billionareskb.user;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date; 
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kalimagezi.billionareskb.addess.Address;
import com.kalimagezi.billionareskb.addess.AddressService;
import com.kalimagezi.billionareskb.career.Career;
import com.kalimagezi.billionareskb.career.CareerService;
import com.kalimagezi.billionareskb.category.Category;
import com.kalimagezi.billionareskb.category.CategoryService;
import com.kalimagezi.billionareskb.company.Company;
import com.kalimagezi.billionareskb.company.CompanyService;
import com.kalimagezi.billionareskb.connection.Connection;
import com.kalimagezi.billionareskb.connection.ConnectionService;
import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.education.Education;
import com.kalimagezi.billionareskb.education.EducationService;
import com.kalimagezi.billionareskb.event.Event;
import com.kalimagezi.billionareskb.event.EventService;
import com.kalimagezi.billionareskb.going.Going;
import com.kalimagezi.billionareskb.going.GoingService;
import com.kalimagezi.billionareskb.invite.Invite;
import com.kalimagezi.billionareskb.jobadd.Jobadd;
import com.kalimagezi.billionareskb.jobadd.JobaddService;
import com.kalimagezi.billionareskb.notification.Notification;
import com.kalimagezi.billionareskb.notification.NotificationService;
import com.kalimagezi.billionareskb.skillTalent.SkillTalent;
import com.kalimagezi.billionareskb.skillTalent.SkillTalentService;

@Controller
public class UserController {

	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/uploads";

	@Autowired
	private CategoryService categoryService;	 
	@Autowired
	private UserService userService;
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
	private CounterService counterService;
	@Autowired
	private ConnectionService connectionService;
	@Autowired
	private JobaddService jobaddService;
	@Autowired
	private GoingService goingService;
	@Autowired
	private NotificationService notificationService;

	/*
	 * public void initBider (WebDataBinder binder) { SimpleDateFormat dateFormat =
	 * new SimpleDateFormat("yyyy-mm-dd"); binder.registerCustomEditor(Date.class,
	 * "birthDate",new CustomDateEditor(dateFormat,true)); }
	 */



	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerUser(@RequestBody User mUser) {
		
		// add new user
		try {
			return userService.addUser(mUser); 
			//might throw exception
			
					
		} catch(Exception e) {
		    //Email Address already exists
			return "/shared/register?opt=fail";
		}
	

	}
	
	@RequestMapping(value="/uploadImage", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String uploadImge (@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("uImageId") int id, @RequestParam("email") String email) {
		JSONObject jsonObject = new JSONObject();
		try {
			long tday = new Date().getTime(); 
			String pname=tday+".jpg";
			User user = userService.findByEmail(email);
			Counter counter2= counterService.getUCounter(user.getId());
			if (user.getImageLink().isEmpty()) {
			
			counter2.setNoVotes(counter2.getNoVotes()+2);
			counter2.setTotal(counter2.getNoArticles()+counter2.getNoConnections()+counter2.getNoInvites()+counter2.getNoOpinions()-
		       		 counter2.getNoReports()+counter2.getNoVotes());
						
			}

			
			user.setImageLink(pname);
			try {
				userService.updateUser(user);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ppath=uploadDirectory+"/"+id+"/profile/";
			userService.saveImage(imageFile,ppath,pname);
			try {
				String image="<img class='profile-user-img img-responsive img-rounded' src='/uploads/"+user.getId()+"/profile/"+user.getImageLink()+"' alt='User profile picture.' data-toggle='tooltip'data-placement='top' title='click edit to update'>";
				String pimage="<img class='user-image' src='/uploads/"+user.getId()+"/profile/"+user.getImageLink()+"' alt='User Image'>";
				jsonObject.put("message", user.getFirstName()+", Your Image has been uploaded successfully");
				jsonObject.put("noVotes", counter2.getNoVotes());
				jsonObject.put("noTVotes", counter2.getTotal());
				jsonObject.put("img", image);
				jsonObject.put("pimg", pimage);
				
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
	}

	
	@PostMapping(value="/updateUser", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser ( @RequestBody User user1) throws JSONException {
		
		     User user= userService.getUser(user1.getId()).orElseThrow(null);
		     
		     if (user.getAboutme()==null && user.getBirthDate()==null) {
		
			Counter counter= counterService.getUCounter(user1.getId());
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
		       		counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		     }


		return  userService.updateUser(user1);
		
	}
	
	
	
	public void createUseradons(User mUser) {

		User user1 =userService.findByEmail(mUser.getEmail());
		Address address= new Address();
		address.setUid(user1.getId());
		addressService.addAddress(address);
		
		Company company= new Company();
		company.setUid(user1.getId());
		companyService.addCompany(company);
		
		Career career= new Career();
		career.setUid(user1.getId());
		careerService.addCareer(career);
		
		Education education = new Education();
		education.setUid(user1.getId());
		educationService.addEducation(education);
		
		SkillTalent skillTalent = new SkillTalent();
		skillTalent.setUid(user1.getId());
		skillTalentService.addSkillTalent(skillTalent);
		
		Connection connection = new Connection();
		connection.setUid(user1.getId());
		connection.setCuid(user1.getCatid());
		connectionService.addConnection(connection);
		
		Notification notification =new Notification();
		notification.setUid(user1.getId());
		notification.setChart(1);
		notificationService.addNotification(notification);
		
		
		Counter counter = new Counter();
		counter.setUid(user1.getId());
		counter.setCid(user1.getCatid());
		counter.setNoVotes(2);
		counter.setTotal(2);
		counterService.addCounter(counter);
		
		Invite invite = new Invite();
		invite.setEmail(user1.getEmail());
		invite.setUid(user1.getId());
		invite.setMessage(user1.getFirstName() +" " +user1.getOtherNames() +" has invited you to join Billonares" );
		
		List<Jobadd> catJobadds=jobaddService.getCatJobadd(user1.getCatid());
		
		if (catJobadds.isEmpty()) {
			
			Jobadd jobadd = new Jobadd();
			jobadd.setCid(user1.getCatid());
			jobadd.setUid(user1.getId());
			jobadd.setRecomended(1);
			
			jobaddService.addJobadd(jobadd);
			
		}
			
			Event event = new Event();
			event.setUid(user1.getId());
			event.setCid(user1.getCatid());
			eventService.addEvent(event);
			Going going=new Going();
			going.setEid(event.getId());
			going.setUid(user1.getId());
			goingService.addGoing(going);
			
	}

//	@RequestMapping(value = "/register-d", method = RequestMethod.GET)
//	public ModelAndView register(@RequestParam(name="opt",required=false) String opt) {
//		ModelAndView mv = new ModelAndView();
//	
//		if(opt!=null) {
//			
//			if(opt.equals("fail")) {
//				mv.addObject("failed", "<b>The email your using is already taken</b>");
//				mv.addObject("ModeJustRegistered", true);				
//			}
//						
//		}
//		
//		mv.addObject("title", "Register");
//		mv.addObject("ModeRegister", true);
//		mv.setViewName("welcome");
//		User nUser = new User();
//		mv.addObject("user", nUser);
//
//		return mv;
//
//	}
//	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model,String opt ) {
		if(opt!=null) {
			model.addAttribute("failed", "<b>The email your using is already taken</b>");
			model.addAttribute("ModeJustRegistered", true);				
		}
		model.addAttribute("title", "Register");
		model.addAttribute("ModeRegister", true);
		User nUser = new User();
		model.addAttribute("user", nUser);


		return "/shared/register";
	}

	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public ModelAndView home2() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", "Welcome to billionares");
		
		mv.addObject("ModeLogged", true);
		mv.setViewName("index");
		return mv;

	}
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public ModelAndView accessdenied() {

		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("title", "403 - Access denied");
		mv.addObject("errorTitle", "Ahaaaa caught you ");
		mv.addObject("errorDescription", "You are not allowed to to access this page");
		mv.addObject("modeErrorAccess", true);
		return mv;

	}

	@ModelAttribute("ecategories")
	public List<Category> getAllEnabledCategories() {
		return categoryService.getAllEnabledCategories();

	}

}
