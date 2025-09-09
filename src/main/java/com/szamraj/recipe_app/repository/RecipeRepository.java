package com.szamraj.recipe_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.recipe_app.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
