package com.szamraj.recipe_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.recipe_app.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
