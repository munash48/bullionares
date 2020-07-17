package com.kalimagezi.billionareskb.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	

	@RequestMapping(value = "/home/addReportVote", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("uid") Integer uid,
			@RequestParam("ouid") Integer ouid

	) {
		
		List <Report> ureports = reportService.getAllReportsByAid(aid);

		
		Counter counter = counterService.getUCounter(ouid);
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
											
				return "redirect:/home?reportFailed=failed";
				
			} 
			
		}
				
			    reportService.addReport(report);
				counterService.addCounter(counter);
				articleService.addArticle(article);
				

				return "redirect:/home?reportAdded=success";
				
				
		
		
	}
}
