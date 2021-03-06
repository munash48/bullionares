package com.kalimagezi.billionareskb.article;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.report.Report;
import com.kalimagezi.billionareskb.report.ReportService;
import com.kalimagezi.billionareskb.user.UserService;
import com.kalimagezi.billionareskb.vote.Vote;
import com.kalimagezi.billionareskb.vote.VoteService;


@Controller
public class ArticleController {
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/uploads";

	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value="/createArticle", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateUser ( @RequestParam("cid") Integer cid, 
			@RequestParam("description") String description,
			@RequestParam(name = "videoLink", required = false) String videoLink,
			@RequestParam(name = "imageFile", required = false) MultipartFile imageFile,
	
			@RequestParam("uid") int uid

			) {
		JSONObject jsonObject = new JSONObject();
		
		if(!description.isEmpty()) {
		
		Article  article = new Article();

		article.setDescription(description);
		article.setCatId(cid);
		article.setUid(uid);
		Counter counter= counterService.getUCounter(uid);
		counter.setNoArticles(counter.getNoArticles()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
		 if(!videoLink.isEmpty()) {
			String str = videoLink; 
	        String[] arrOfStr = str.split("=", 2); 
	  
	        String videoLink2=arrOfStr[1];
	        article.setVideoLink(videoLink2);
	        try {
	        	jsonObject.put("thisVideo", "<iframe width='90%' height='315' src='https://www.youtube.com/embed/"+article.getVideoLink()+"?&autoplay=0'frameborder='0' allowfullscreen></iframe>");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			
		 if(!imageFile.isEmpty()) {
	
			try {
			long tday = new Date().getTime(); 
			String pname=tday+".jpg";
			
			System.out.println(pname);
			if (imageFile!=null) {
			article.setImageLink(pname);
			try {
				jsonObject.put("thisImage", "<img class='img-responsive' src='/uploads/"+article.getUid()+"/articles/"+article.getImageLink()+"' alt='Photo'>");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ppath=uploadDirectory+"/"+uid+"/articles/";
			userService.saveImage(imageFile,ppath,pname);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		
		
		
			
	    articleService.addArticle(article);
	    try {
			jsonObject.put("message", "Article " +article.getId() +" Added  successfully. ");
			jsonObject.put("noArticle", counter.getNoArticles());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("thisArticle", article.getDescription());
						
			jsonObject.put("status", "success");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Article article2 = articleService.getArticle(article.getId()).orElseThrow(null);
	    
	    Vote vote = new Vote();

		vote.setAid(article2.getId());
		voteService.addVote(vote);
		

		
		Report report = new Report();

		report.setAid(article2.getId());
		reportService.addReport(report);
		


		return jsonObject.toString();
		
		}
		
		try {
			jsonObject.put("message", "Article Is Empty indescription");
			jsonObject.put("status", "failed");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
	}
}
