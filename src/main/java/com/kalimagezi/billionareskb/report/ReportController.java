package com.kalimagezi.billionareskb.report;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalimagezi.billionareskb.article.Article;
import com.kalimagezi.billionareskb.article.ArticleService;
import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private ArticleService articleService;
	

	@RequestMapping(value = "/addCross", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("uid") Integer uid,
			@RequestParam("duid") Integer duid

	) {
		
		JSONObject jsonObject = new JSONObject();
		
		List <Report> ureports = reportService.getAllReportsByAid(aid);

		
		Counter counter = counterService.getUCounter(duid);
		counter.setNoReports(counter.getNoReports()+1);
		Article article = articleService.getArticle(aid).orElseThrow(null);
		article.setNoReports(article.getNoReports()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		
		Report report = new Report();

		report.setAid(aid);
		report.setUid(uid);
		
		for(Report ureport: ureports) {
			
			if (ureport.getUid()==report.getUid()) {
				
				try {
					jsonObject.put("message", "You have already crossed for this Article");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
											
				return jsonObject.toString();
				
			} 
			
		}
				
			    reportService.addReport(report);
				counterService.addCounter(counter);
				articleService.addArticle(article);
				
				try {
					jsonObject.put("message", "You have crossed Article No" + article.getId());
					jsonObject.put("status", "success");
					jsonObject.put("newCrosses",  "Crosses ("+article.getNoReports()+")");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				

				return jsonObject.toString();
				
				
		
		
	}
}
