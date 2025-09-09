package com.szamraj.spring_guru_9_spring_webapp3.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.szamraj.spring_guru_9_spring_webapp3.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	public Optional<Category> findByDescription(String description);
}
