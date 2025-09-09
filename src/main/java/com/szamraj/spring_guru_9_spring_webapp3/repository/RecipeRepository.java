package com.szamraj.spring_guru_9_spring_webapp3.repository;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.spring_guru_9_spring_webapp3.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
