package com.kalimagezi.billionareskb.opinion;


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
			@RequestParam("uid") int uid,
			@RequestParam("artuid") int artuid

			) {
		JSONObject jsonObject = new JSONObject();
		
		List<Opinion> opinions = opinionService.getOpinionsByAid(aid);

		for (Opinion opinion : opinions) {

			if (uid == opinion.getUid()) {
				
				try {
					jsonObject.put("message", "You already made an opinion on this article.");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}
		
		
		if (!description.isEmpty()) {
		
		Opinion  opinion = new Opinion();

		opinion.setDescription(description);
		opinion.setAid(aid);
		opinion.setUid(uid);
		Counter counter2= counterService.getUCounter(artuid);
		counter2.setNoOpinions(counter2.getNoOpinions()+1);
		Counter counter= counterService.getUCounter(uid);
		counter.setNoOpinions(counter.getNoOpinions()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		
			counterService.addCounter(counter);
			counterService.addCounter(counter2);
		Article article = articleService.getArticle(aid).orElseThrow(null);
		article.setNoOpinions(article.getNoOpinions()+1);		
		opinionService.addOpinion(opinion);
		try {
			jsonObject.put("message", "Opinion  " +opinion.getAid() +" Created  successfully.");
			jsonObject.put("status", "success");
			jsonObject.put("newOpinion",  "Opinions ("+article.getNoOpinions()+")");
			jsonObject.put("id", article.getId());
			jsonObject.put("opinion", opinion.getDescription());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("noOpinion", counter.getNoOpinions());
			
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
