package com.qa.hobbyproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproject.domain.Recipe;
import com.qa.hobbyproject.service.RecipeService;

@RestController 
public class RecipeController {
	
	private RecipeService service;
	
	@Autowired 
	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}
	

	@RequestMapping("/create")
	@PostMapping("/create")
	public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
		Recipe added = this.service.create(recipe);
		ResponseEntity<Recipe> response = new ResponseEntity<Recipe> (added, HttpStatus.CREATED);
		return response;
	}
	
	// READ ALL
	@RequestMapping("/getAll")
	@GetMapping("/getAll") 
	public ResponseEntity<List<Recipe>> getAllListOfRecipes() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	// READ ONE
	@RequestMapping("/get/{id}")
	@GetMapping("/get/{id}")
	public Recipe getRecipe(@PathVariable Integer id){
		return this.service.getOne(id);
	}
	
	//Update 
	@RequestMapping("/update/{id}")
	@PutMapping("/update/{id}")
	public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe newRecipe){
		Recipe body = this.service.update(id, newRecipe);
		ResponseEntity<Recipe> response = new ResponseEntity<Recipe>(body, HttpStatus.ACCEPTED);
		return response;
	}
	//Delete 
	@RequestMapping("/delete/{id}") 
	@DeleteMapping("/delete/{id}") 
	public ResponseEntity<?> deleteRecipe(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//Read by name 
	@RequestMapping("/getByName/{name}")
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Recipe>> getRecipeByName(@PathVariable String name){
	List<Recipe> found = this.service.getRecipeByName(name);
	return ResponseEntity.ok(found);
	}
	
	//read by category 
	@RequestMapping("/getByCategory/{category}")
	@GetMapping("/getByCategory/{category}")
	public ResponseEntity<List<Recipe>> getRecipesByCategory(@PathVariable String category) {
		List<Recipe> found = this.service.getRecipeByCategory(category);
		return ResponseEntity.ok(found);
	}

}

