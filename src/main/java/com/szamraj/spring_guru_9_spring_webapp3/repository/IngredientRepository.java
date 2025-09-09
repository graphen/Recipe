package com.szamraj.spring_guru_9_spring_webapp3.repository;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.spring_guru_9_spring_webapp3.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
