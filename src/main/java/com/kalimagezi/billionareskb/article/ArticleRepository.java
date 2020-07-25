package com.kalimagezi.billionareskb.article;


import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

   
	Iterable<Article> findTop10ByCatIdOrderByCreateDateDesc(int catid);

}
