package com.szamraj.recipe_app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.recipe_app.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	public Optional<Category> findByDescription(String description);
}
