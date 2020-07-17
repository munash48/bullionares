package com.kalimagezi.billionareskb.vote;

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
public class VoteController {
	@Autowired
	private VoteService voteService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private ArticleService articleService;
	

	@RequestMapping(value = "/home/addVote", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("aid") Integer aid, @RequestParam("uid") int uid,
			@RequestParam("ouid") int ouid

	) {
		
		List <Vote> uvotes = voteService.getAllVotesByAid(aid);
		Counter counter = counterService.getUCounter(ouid);
		counter.setNoVotes(counter.getNoVotes()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		Article article = articleService.getArticle(aid).orElseThrow(null);
		article.setNoVotes(article.getNoVotes()+1);
		Vote vote = new Vote();

		vote.setAid(aid);
		vote.setUid(uid);
		
		for(Vote uvote: uvotes) {
			
			if (vote.getUid()==uvote.getUid()) {
				
				return "redirect:/home?voteFailed=failed";
				
			}
		}
				
				voteService.addVote(vote);
				counterService.addCounter(counter);
				articleService.addArticle(article);
				

				return "redirect:/home?voteAdded=success";
		
			
		
		
		


	}
}