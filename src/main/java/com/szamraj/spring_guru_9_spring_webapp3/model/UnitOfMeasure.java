package com.szamraj.spring_guru_9_spring_webapp3.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UnitOfMeasure {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
    // Optional: reverse mapping to RecipeIngredient if needed for bidirectional queries
    @OneToMany(mappedBy = "unitOfMeasure")
    private Set<RecipeIngredient> usages = new HashSet<>();

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

	public Set<RecipeIngredient> getUsages() {
		return usages;
	}

	public void setUsages(Set<RecipeIngredient> usages) {
		this.usages = usages;
	}
}
