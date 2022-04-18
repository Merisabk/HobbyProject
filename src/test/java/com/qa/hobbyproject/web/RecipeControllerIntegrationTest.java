package com.qa.hobbyproject.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbyproject.domain.Recipe;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@AutoConfigureMockMvc 
	@Sql(scripts = {"classpath:recipe-schema.sql", "classpath:recipe-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
	@ActiveProfiles("test")
	public class RecipeControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Recipe testRecipe = new Recipe(null, "2 eggs, 2 tablespoon mayonnaise, 1 teaspoon mustard, parsley", "20 minutes", 2, "savoury", "Stuffed Eggs");
		String testRecipeAsJSON = this.mapper.writeValueAsString(testRecipe); 
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testRecipeAsJSON);
		
		Recipe testcreatedRecipe = new Recipe(3,"2 eggs, 2 tablespoon mayonnaise, 1 teaspoon mustard, parsley", "20 minutes", 2, "savoury", "Stuffed Eggs");
		String testcreatedRecipeAsJSON = this.mapper.writeValueAsString(testcreatedRecipe);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testcreatedRecipeAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testGetAll() throws Exception {
		RequestBuilder req = get("/getAll");
		List<Recipe> testRecipes = List.of(new Recipe (1, "250g uncooked pasta, 1 tablespoon butter, 1 teapoon flour, 2-3 cloves garlic, 1/4cup chicken broth, 1 cup heavy cream, 1/3 cup grated parmesan cheese, salt, pepper, fresh parsley", "15 minutes" , 4, "savoury","Creamy Garlic Pasta"), new Recipe (2, "4 tablespoon flour, 5 tablespoon sugar, 3 tablespoon cocoa powder, 1 pinch of salt, 1 egg, 3 tablespoon milk, 3 tablepoon butter, 3 tablespoon chocolate chips, 1 teaspoon vanilla extract", "5 minutes", 2, "sweet","Chocolate mug cake"));
		String json = this.mapper.writeValueAsString(testRecipes);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetById() throws Exception {
		RequestBuilder req = get("/get/1");
		Recipe testRecipeById = new Recipe (1, "250g uncooked pasta, 1 tablespoon butter, 1 teapoon flour, 2-3 cloves garlic, 1/4cup chicken broth, 1 cup heavy cream, 1/3 cup grated parmesan cheese, salt, pepper, fresh parsley", "15 minutes" , 4, "savoury","Creamy Garlic Pasta");
		String json = this.mapper.writeValueAsString(testRecipeById);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdate() throws Exception {
		Recipe testRecipe = new Recipe(null, "250g uncooked pasta, 1 tablespoon butter, 1 teapoon flour, 2-3 cloves garlic, 1/4cup chicken broth, 1 cup heavy cream, 1/3 cup grated parmesan cheese, salt, pepper, fresh parsley", "15 minutes" , 4, "savoury","Creamy Garlic Pasta");
		String testRecipeAsJSON = this.mapper.writeValueAsString(testRecipe);
		RequestBuilder req = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(testRecipeAsJSON);
		
		Recipe testUpdatedRecipe = new Recipe (1, "250g uncooked pasta, 1 tablespoon butter, 1 teapoon flour, 2-3 cloves garlic, 1/4cup chicken broth, 1 cup heavy cream, 1/3 cup grated parmesan cheese, salt, pepper, fresh parsley", "15 minutes" , 4, "savoury","Creamy Garlic Pasta");
		String testUpdatedRecipeAsJSON = this.mapper.writeValueAsString(testUpdatedRecipe);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testUpdatedRecipeAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	void testDeleteRecipe() throws Exception {
		this.mvc.perform(delete("/delete/1")).andExpect(status().isNoContent());
	}
	
	@Test
	void testGetByName() throws Exception {
		RequestBuilder req = get("/getByName/Chocolate mug cake");
		List<Recipe> testRecipeByName = List.of(new Recipe(1, "250g uncooked pasta, 1 tablespoon butter, 1 teapoon flour, 2-3 cloves garlic, 1/4cup chicken broth, 1 cup heavy cream, 1/3 cup grated parmesan cheese, salt, pepper, fresh parsley", "15 minutes" , 4, "savoury","Creamy Garlic Pasta"));
		String json = this.mapper.writeValueAsString(testRecipeByName);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetByCategory() throws Exception {
		RequestBuilder req = get("/getByCategory/savoury");
		List<Recipe> testRecipeByCategory = List.of(new Recipe(1, "250g uncooked pasta, 1 tablespoon butter, 1 teapoon flour, 2-3 cloves garlic, 1/4cup chicken broth, 1 cup heavy cream, 1/3 cup grated parmesan cheese, salt, pepper, fresh parsley", "15 minutes" , 4, "savoury","Creamy Garlic Pasta"));
		String json = this.mapper.writeValueAsString(testRecipeByCategory);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
}
