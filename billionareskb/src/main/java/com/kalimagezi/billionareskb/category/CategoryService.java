package com.kalimagezi.billionareskb.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {

		categoryRepository.save(category);
	}

	public Optional<Category> getCategory(int id) {

		return categoryRepository.findById(id);

	}

	public List<Category> getAllCategories() {

		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;

	}
	public List<Category> getAllEnabledCategories() {

		List<Category> ecategories = new ArrayList<>();
		categoryRepository.findByEnabledTrue().forEach(ecategories::add);
		return ecategories;

	}

	public void updateCategory(Category category) {

		categoryRepository.save(category);
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);

	}

}
