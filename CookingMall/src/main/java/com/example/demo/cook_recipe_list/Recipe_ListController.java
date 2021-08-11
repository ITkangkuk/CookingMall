package com.example.demo.cook_recipe_list;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class Recipe_ListController {

	@Controller
	public class NoticeController {

		@Autowired
		private Recipe_ListService Recipe_ListService;

		// 공지사항 작성 폼으로 이동
		@GetMapping(value = "/Recipe_List/Recipe_List_writing")
		public void Recipe_ListForm() {

		}

		// 공지사항 작성
		@RequestMapping(value = "/Recipe_List/Recipe_List_writing")
		public String insert(Recipe_List rl) {
			
			Recipe_ListService.addNotice(rl);
			
			return "redirect:/Recipe_List/Recipe_List_board";
		}
		
		// 공지사항 전체 출력
		@RequestMapping(value = "/Recipe_List/Recipe_List_board")
		public ModelAndView list() {

			ModelAndView mav = new ModelAndView("/notice/notice_board");
			ArrayList<Recipe_List> list = (ArrayList<Recipe_List>) Recipe_ListService.selectAllRecipe_List();
			mav.addObject("list", list);

			return mav;
		}

		// 공지사항 수정
		@RequestMapping(value = "/Recipe_List/Recipe_List_edit")
		public String edit(Recipe_List rl) {

			Recipe_ListService.editRecipe_List(rl);

			return "redirect:/notice/notice_board";
		}

		// 공지사항 삭제
		@RequestMapping(value = "/notice/notice_delete")
		public String delete(@RequestParam(value = "notice_num") int rl_num) {

			Recipe_ListService.delete(rl_num);

			return "redirect:/notice/notice_board";
		}
	}

	
}
