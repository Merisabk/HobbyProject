package com.qa.hobbyproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Dog;
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
	
	
	@PostMapping("/create")
	public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
		Recipe added = this.service.create(recipe);
		ResponseEntity<Recipe> response = new ResponseEntity<Recipe> (created, HttpStatus.CREATED);
		return response;
	}
	
	// READ ALL
	@GetMapping("/getAll") 
	public ResponseEntity<List<Recipe>> getAllListOfRecipes() {
		return ResponseEntity.ok(this.service.getAll());
	}

}

