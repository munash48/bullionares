package com.kalimagezi.billionareskb.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public void addArticle(Article article) {

		articleRepository.save(article);
	}

	public Optional<Article> getArticle(int id) {

		return articleRepository.findById(id);

	}

	public List<Article> getAllArticles() {

		List<Article> articles = new ArrayList<>();
		articleRepository.findAll().forEach(articles::add);
		return articles;

	}

	public void updateArticle(Article article) {

		articleRepository.save(article);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteById(id);

	}

	public List<Article> getArticlesByCat(int catid) {
		// TODO Auto-generated method stub
		List<Article> articles = new ArrayList<>();
		articleRepository.findTop10ByCatIdOrderByCreateDateDesc(catid).forEach(articles::add);
		return articles;
	}

}
