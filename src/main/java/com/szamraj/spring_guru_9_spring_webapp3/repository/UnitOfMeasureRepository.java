package com.szamraj.spring_guru_9_spring_webapp3.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.spring_guru_9_spring_webapp3.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	public Optional<UnitOfMeasure> findByDescription(String description);
}
