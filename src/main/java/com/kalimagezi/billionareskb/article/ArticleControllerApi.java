package com.kalimagezi.billionareskb.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArticleControllerApi {

	
	@Autowired
	private ArticleService articlesService;
	
	@RequestMapping("/articles")
	public List<Article> getAllArticles(){
		return articlesService.getAllArticles();
	}
	@RequestMapping("/article/{id}")
	public Optional<Article> getArticles(@PathVariable int id){
		return articlesService.getArticle(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/article")
	public void addArticles(@RequestBody Article articles ){
		articlesService.addArticle(articles);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/article/{id}")
	public void updateArticles(@RequestBody Article articles, @PathVariable int id){
		articlesService.updateArticle(articles);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/article/{id}")
	public void deleteArticles(@PathVariable int id ){
		articlesService.deleteArticle(id);
	}
}
