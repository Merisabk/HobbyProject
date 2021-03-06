package com.qa.hobbyproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hobbyproject.domain.Recipe;
import com.qa.hobbyproject.repo.RecipeRepo;

@Service 
	public class RecipeService implements ServiceInterface<Recipe> {
	
	private RecipeRepo repo;
	
	@Autowired
	public RecipeService(RecipeRepo repo) {
		super();
		this.repo = repo;
	}
	
	//CRUD


	//Insert into Recipe
	public Recipe create(Recipe recipe) {
		Recipe created = this.repo.save(recipe);
		return created;
	}

	//Select * from recipe
	public List<Recipe> getAll() {
		return this.repo.findAll();
	}

	
	// select * from recipe where id =? 
	public Recipe getOne(Integer id) {
	Optional<Recipe> found = this.repo.findById(id);
		return found.get();
	}

	
	//Update
	public Recipe update(Integer id, Recipe newRecipe) {
		Recipe existing = this.repo.findById(id).get();
		existing.setRecipeName(newRecipe.getRecipeName());
		existing.setCategory(newRecipe.getCategory());
		existing.setCookingTime(newRecipe.getCookingTime());
		existing.setIngredients(newRecipe.getIngredients());
		existing.setServings(newRecipe.getServings());
		Recipe updated = this.repo.save(existing);
		return updated;
	}

	
	// DELETE from Recipe where id = ? 
	public void remove(Integer id) {
		this.repo.deleteById(id);
	}

// Select * from recipe where recipeName = ?
public List<Recipe> getRecipeByName(String recipeName) {
	List<Recipe> found = this.repo.findByRecipeNameIgnoreCase(recipeName);
	return found;
}

// Select * from recipe where category =?
public List<Recipe> getRecipeByCategory(String category){
	List<Recipe> found = this.repo.findByCategoryIgnoreCase(category);
	return found;
}
}
	


