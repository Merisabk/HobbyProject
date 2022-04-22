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
	private String category;
	
	@Column (nullable=false)
	private Integer servings;
	
	@Column (nullable=false)
	private String cookingTime;
	
	@Column (nullable=false)
	private String ingredients;
	
	public Recipe() {
		super();
	}
	
	public Recipe(Integer id, String recipeName, String category, Integer servings, String cookingTime,
			String ingredients) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
		return "Recipe [id=" + id + ", recipeName=" + recipeName + ", recipeCategory=" + category + ", servings="
				+ servings + ", cookingTime=" + cookingTime + ", ingredients=" + ingredients + "]";


	}
	
	

}
