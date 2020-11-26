package com.kalimagezi.billionareskb.vote;

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
public class VoteController {
	@Autowired
	private VoteService voteService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private ArticleService articleService;
	

	@RequestMapping(value = "/addVote", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addVote(@RequestParam("aid") Integer aid, @RequestParam("uid") Integer uid,
			@RequestParam("duid") Integer duid

	) {
		
		JSONObject jsonObject = new JSONObject();
		
		List <Vote> uvotes = voteService.getAllVotesByAid(aid);
		
	
		Vote vote = new Vote();

		vote.setAid(aid);
		vote.setUid(uid);
		
		for(Vote uvote: uvotes) {
			
			if (vote.getUid()==uvote.getUid()) {
				
				try {
					jsonObject.put("message", "You have already voted for this Article");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
				
			}
		}
		
		Counter counter = counterService.getUCounter(duid);
		counter.setNoVotes(counter.getNoVotes()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		
		Article article = articleService.getArticle(aid).orElseThrow(null);
		article.setNoVotes(article.getNoVotes()+1);
				
				voteService.addVote(vote);
				counterService.addCounter(counter);
				articleService.addArticle(article);
				

				try {
					jsonObject.put("message", "You have Voted Article No" + article.getId());
					jsonObject.put("newvotes",  "Votes ("+article.getNoVotes()+")");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
		
			
		
		
		


	}
}