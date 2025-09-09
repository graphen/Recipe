package com.szamraj.recipe_app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.recipe_app.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	public Optional<UnitOfMeasure> findByDescription(String description);
}
