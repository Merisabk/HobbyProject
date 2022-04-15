package com.qa.hobbyproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable=false)
	private String recipeName;
	
	@Column (nullable=false)
	private String recipeCategory;
	
	@Column (nullable=false)
	private Integer servings;
	
	@Column 
	private String cookingTime;
	
	@Column (nullable=false)
	private String ingredients;
	
	public Recipe() {
		super();
	}
	
	public Recipe(Integer id, String recipeName, String recipeCategory, Integer servings, String cookingTime,
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

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
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
