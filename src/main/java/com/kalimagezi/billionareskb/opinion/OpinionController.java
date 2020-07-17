package com.kalimagezi.billionareskb.opinion;


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
public class OpinionController {

	@Autowired
	private OpinionService opinionService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/home/createOpinion", method = RequestMethod.POST)
	public String createOpinion ( @RequestParam("artid") Integer aid, 
			@RequestParam("description") String description,
			@RequestParam("uid") int uid

			) {
		
		if (description!="") {
		
		Opinion  opinion = new Opinion();

		opinion.setDescription(description);
		opinion.setAid(aid);
		opinion.setUid(uid);
		Counter counter= counterService.getUCounter(uid);
		counter.setNoOpinions(counter.getNoOpinions()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
		Article article = articleService.getArticle(aid).orElseThrow(null);
		article.setNoOpinions(article.getNoOpinions()+1);		
		opinionService.addOpinion(opinion);


		return "redirect:/home?opinionCreated=success";
		}
		return "redirect:/home?opinionNotCreated=success";
		
		
	}
}
