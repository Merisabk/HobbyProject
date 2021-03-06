package com.qa.hobbyproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.domain.Recipe;


	@Repository
	public interface RecipeRepo extends JpaRepository<Recipe, Integer> {
		//Spring will auto-generate the basic CRUD functionality.
		
		List<Recipe> findByRecipeNameIgnoreCase(String recipeName);
		List<Recipe> findByCategoryIgnoreCase(String category);
	}
	
	