package com.example.demo.cook_recipe_list;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Recipe_ListMapper {

	void insertRecipe_List(Recipe_List rl);			//레시피 추가

	List selectAllRecipe_List();					//레시피 리스트 출력
	
	Recipe_List selectRecipe_List(int Recipe_num);	//Recipe_num으로 공지사항 출력
	
	void updateRecipe_List(Recipe_List rl);			//레시피 수정
	
	void deleteRecipe_List(int Recipe_num);		//공지사항 삭제
}
