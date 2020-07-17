package com.kalimagezi.billionareskb.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CategoryControllerApi {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/categories")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	@RequestMapping("/category/{id}")
	public Optional<Category> getCategory(@PathVariable int id){
		return categoryService.getCategory(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/category")
	public void addCategory(@RequestBody Category category ){
		categoryService.addCategory(category);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/category/{id}")
	public void updateCategory(@RequestBody Category category, @PathVariable int id){
		categoryService.updateCategory(category);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/category/{id}")
	public void deleteCategory(@PathVariable int id ){
		categoryService.deleteCategory(id);
	}

}
