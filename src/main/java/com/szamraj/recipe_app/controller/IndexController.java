package com.szamraj.recipe_app.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szamraj.recipe_app.model.Category;
import com.szamraj.recipe_app.model.UnitOfMeasure;
import com.szamraj.recipe_app.repository.CategoryRepository;
import com.szamraj.recipe_app.repository.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	CategoryRepository categoryRepository;
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"/", "", "index", "index.html"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		Optional<Category> category1 = categoryRepository.findByDescription("Italian");
		if(category1.isPresent()) {
			System.out.println("Category found: " + category1.get().getDescription());
		} else {
			System.out.println("Category not found");
		}
		
		Optional<Category> category2 = categoryRepository.findByDescription("Mexican");
		if(category2.isPresent()) {
			System.out.println("Category found: " + category2.get().getDescription());
		} else {
			System.out.println("Category not found");
		}
		
		Optional<UnitOfMeasure> uom1 = unitOfMeasureRepository.findByDescription("Teaspoon");
		if(uom1.isPresent()) {
			System.out.println("UOM found: " + uom1.get().getDescription());
		} else {
			System.out.println("UOM not found");
		}
		
		Optional<UnitOfMeasure> uom2 = unitOfMeasureRepository.findByDescription("Cupa");
		if(uom2.isPresent()) {
			System.out.println("UOM found: " + uom2.get().getDescription());
		} else {
			System.out.println("UOM not found");
		}

		return "index";
	}
}
