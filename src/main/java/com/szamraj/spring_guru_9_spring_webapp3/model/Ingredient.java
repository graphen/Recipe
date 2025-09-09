package com.szamraj.spring_guru_9_spring_webapp3.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
    // Optional: reverse mapping to RecipeIngredient if needed
    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
}
