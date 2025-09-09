package com.szamraj.spring_guru_9_spring_webapp3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.szamraj.spring_guru_9_spring_webapp3.model.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {
	public boolean existsByIngredientId(Long id);
	
    @Query("SELECT COUNT(DISTINCT ri.recipe.id) FROM RecipeIngredient ri WHERE ri.ingredient.id = :id")
	public Long countByIngredientId(Long id);
    
    public boolean existsByUnitOfMeasureId(Long id);
    public Long countByUnitOfMeasureId(Long id);
    
    boolean existsByRecipeId(Long id);
    long countByRecipeId(Long id);
}
