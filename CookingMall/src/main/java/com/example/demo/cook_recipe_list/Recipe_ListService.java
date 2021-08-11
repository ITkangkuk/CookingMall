package com.example.demo.cook_recipe_list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Recipe_ListService {

	@Autowired
	private Recipe_ListMapper mapper;
	
	public void addNotice(Recipe_List rl) {
		mapper.insertRecipe_List(rl);
	}
	
	public List selectAllRecipe_List() {
		return mapper.selectAllRecipe_List();
	}
	
	public Recipe_List selectRecipe_ListByNum(int rl_num) {
		return mapper.selectRecipe_List(rl_num);
	}
	
	public void editRecipe_List(Recipe_List rl) {
		mapper.updateRecipe_List(rl);
	}
	
	public void delete(int rl_num) {
		mapper.deleteRecipe_List(rl_num);
	}
}
