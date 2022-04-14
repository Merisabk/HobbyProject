package com.qa.hobbyproject.domain;

public class Recipe {
	
	private Integer id;
	private String recipeName;
	private String recipeCategory;
	private Integer servings;
	private Double cookingTime;
	private String ingredients;
	
	public Recipe() {
		super();
	}
	
	public Recipe(Integer id, String recipeName, String recipeCategory, Integer servings, Double cookingTime,
			String ingredients) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.recipeCategory = recipeCategory;
		this.servings = servings;
		this.cookingTime = cookingTime;
		this.ingredients = ingredients;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeCategory() {
		return recipeCategory;
	}

	public void setRecipeCategory(String recipeCategory) {
		this.recipeCategory = recipeCategory;
	}

	public Integer getServings() {
		return servings;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public Double getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(Double cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeName=" + recipeName + ", recipeCategory=" + recipeCategory + ", servings="
				+ servings + ", cookingTime=" + cookingTime + ", ingredients=" + ingredients + "]";
	}
	
	
	
	

}
