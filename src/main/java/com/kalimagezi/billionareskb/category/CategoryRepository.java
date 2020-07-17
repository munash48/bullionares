package com.kalimagezi.billionareskb.category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	public Iterable<Category> findByEnabledTrue();
	

}
