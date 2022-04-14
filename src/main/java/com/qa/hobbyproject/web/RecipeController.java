package com.qa.hobbyproject.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproject.domain.Recipe;

@RestController 
public class RecipeController {
	
	@PostMapping("/create")
	public Recipe addRecipe(Recipe recipe) {
		
	}


}
