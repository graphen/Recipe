package com.szamraj.spring_guru_9_spring_webapp3.command;

import java.math.BigDecimal;

public class RecipeIngredientCommand {
	private Long id;
	private Long recipeId;
	private Long ingredientId;
	private String ingredientDescription;
	private BigDecimal amount;
	private Long unitOfMeasureId;
	private String unitOfMeasureDescription;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRecipeId() {
		return recipeId;
	}
	
	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
	
	public Long getIngredientId() {
		return ingredientId;
	}
	
	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public String getIngredientDescription() {
		return ingredientDescription;
	}
	
	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Long getUnitOfMeasureId() {
		return unitOfMeasureId;
	}
	
	public void setUnitOfMeasureId(Long unitOfMeasureId) {
		this.unitOfMeasureId = unitOfMeasureId;
	}
	
	public String getUnitOfMeasureDescription() {
		return unitOfMeasureDescription;
	}
	
	public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
		this.unitOfMeasureDescription = unitOfMeasureDescription;
	}
}
