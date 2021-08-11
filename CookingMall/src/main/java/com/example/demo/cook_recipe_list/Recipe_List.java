package com.example.demo.cook_recipe_list;

public class Recipe_List {

	private int rl_num;
	private int rl_product_num;
	private String title;
	
	public Recipe_List() {
		super();
	}

	public Recipe_List(int rl_num, int rl_product_num, String title) {
		super();
		this.rl_num = rl_num;
		this.rl_product_num = rl_product_num;
		this.title = title;
	}

	public int getRl_num() {
		return rl_num;
	}

	public void setRl_num(int rl_num) {
		this.rl_num = rl_num;
	}

	public int getRl_product_num() {
		return rl_product_num;
	}

	public void setRl_product_num(int rl_product_num) {
		this.rl_product_num = rl_product_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Recipe_List [rl_num=" + rl_num + ", rl_product_num=" + rl_product_num + ", title=" + title + "]";
	}
	
}