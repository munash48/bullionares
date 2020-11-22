package com.kalimagezi.billionareskb.opinion;


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
public class OpinionController {

	@Autowired
	private OpinionService opinionService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/createOpinion", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion ( @RequestParam("artid") Integer aid, 
			@RequestParam("description") String description,
			@RequestParam("uid") int uid

			) {
		JSONObject jsonObject = new JSONObject();
		
		
		if (!description.isEmpty()) {
		
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
		try {
			jsonObject.put("message", "Opinion  " +opinion.getAid() +" Created  successfully.");
			jsonObject.put("newOpinion",  "Analysis ("+article.getNoOpinions()+")");
			jsonObject.put("id", article.getId());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return jsonObject.toString();
		}
		try {
			jsonObject.put("message", "Opinion cant be empty in description");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
		
	}
}
