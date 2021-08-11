package com.example.demo.cook_admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.cook_user.User;
import com.example.demo.cook_user.UserService;

@Controller
public class AdminController {

   @Autowired
   private AdminService admin_Service;

   @Autowired
   private UserService user_Service;
   
//   @Autowired
//   private ProductService product_Service;
   
//   @Autowired
//   private WishService wish_Service;

   // ==================== �뼹 Page Control �뼹 ====================

   // 濡쒓렇�씤 �썑 愿�由ъ옄 硫붿씤�럹�씠吏�濡� �씠�룞
   @RequestMapping("/admin/adminMain")
   public void adminMain() {
   //that
   }
   

   // 愿�由ъ옄 �솃�럹�씠吏� �젙蹂대줈 �씠�룞
   @RequestMapping("/admin/adminHomePage")
   public ModelAndView adminHomePage() {
      ModelAndView mav = new ModelAndView("/admin/adminHomePage");
      
      int totalUserNum = user_Service.getTotalUserNum();
      mav.addObject("totalUserNum", totalUserNum);
      
      int todayUserNum = user_Service.getTodayUserNum();
      mav.addObject("todayUserNum", todayUserNum);
      
//      int totalProductNum = product_Service.getTotalProductNum();
//      mav.addObject("totalProductNum", totalProductNum);
      
//      int todayProductNum = product_Service.getTodayProductNum();
//      mav.addObject("todayProductNum", todayProductNum);
      
      return mav;
   }


   // 愿�由ъ옄 移댄뀒怨좊━濡� �씠�룞
   @GetMapping("admin/adminCategory")
   public void adminCategory() {

   }

   // 愿�由ъ옄 �쉶�썝愿�由щ줈 �씠�룞
   @GetMapping("admin/adminUser")
   public void adminUser() {

   }

   // 愿�由ъ옄 �긽�뭹愿�由щ줈 �씠�룞
   @GetMapping("admin/adminProduct")
   public void adminProduct() {

   }



   @RequestMapping("admin/selectAdminPage")
   public ModelAndView selectAdminPage(@RequestParam(value = "adminPageType") String adminPageType) {

      ModelAndView mav = new ModelAndView("admin/adminMain");

      int type = 0;
      switch (adminPageType) {
      case "�솃�럹�씠吏��젙蹂�":
         type = 1;
         break;

      case "�쉶�썝愿�由�":
         type = 2;
         break;

      case "�긽�뭹愿�由�":
         type = 3;
         break;

      case "移댄뀒怨좊━愿�由�":
         type = 4;
         break;

      case "怨듭��궗�빆":
         type = 5;
         break;

      case "QnA":
         type = 6;
         break;

      case "�떊怨좉쾶�떆�뙋":
         type = 7;
         break;

      }
      mav.addObject("type", type);
      return mav;

   }

   // ==================== �뼯 Page Control �뼯 ====================

   // 濡쒓렇�븘�썐 �썑 硫붿씤�럹�씠吏�濡� �씠�룞
   @RequestMapping(value = "/admin/logout")
   public String logout(HttpServletRequest request) {

      HttpSession session = request.getSession(false);
      session.removeAttribute("user_Id");
      session.invalidate();

      return "redirect:/index";
   }

// ==================== Category ====================

   // DB�뿉 移댄뀒怨좊━ 異붽� (�럹�씠吏�X)
   // adminCategory �럹�씠吏��뿉�꽌 異붽� 踰꾪듉 �닃���쓣 �븣
   @RequestMapping(value = "/admin/addCategory")
   public ModelAndView addCategory(@RequestParam(value = "ca_name") String ca_name,
         @RequestParam(value = "parent_category_num") int parent_category_num,
         @RequestParam(value = "category_type") int category_type) {
      int ca_num;
      Category c = null;
      ModelAndView mav = new ModelAndView("/admin/categoryJSON");

      if (category_type == 1) {
         ca_num = admin_Service.getNum(category_type);
         c = new Category(ca_num, ca_name);
      } else if (category_type == 2) {
    	  ca_num = admin_Service.getNum(category_type);
         c = new Category(ca_num, ca_name, parent_category_num);
      } 
      
   
   		
      System.out.println(c);
      System.out.println(category_type);
      admin_Service.insertCategory(c, category_type);
      
      ArrayList<Category> category_list = null;

      switch (category_type) {
      	case 1:
      		category_list = (ArrayList<Category>) admin_Service.selectAllCategory(0, 1);
      		break;
      	case 2:
      		category_list = (ArrayList<Category>) admin_Service.selectAllCategory(parent_category_num, 2);
      		break;
      }
      mav.addObject("category_list", category_list);

      return mav;
   }

   // �솕硫댁뿉 異쒕젰
   @RequestMapping(value = "/admin/getCategory")
   public ModelAndView getCategory(@RequestParam(value = "parent_category_num") int parent_category_num,
         @RequestParam(value = "category_type") int category_type) {

      System.out.println("異쒕젰 parent_category_num : " + parent_category_num);
      System.out.println("異쒕젰 category_type : " + category_type);

      ModelAndView mav = new ModelAndView("/admin/categoryJSON");
      ArrayList<Category> category_list = null;

      switch (category_type) {
      case 1:
         category_list = (ArrayList<Category>) admin_Service.selectAllCategory(0, 1);
         break;
      case 2:
         category_list = (ArrayList<Category>) admin_Service.selectAllCategory(parent_category_num, 2);
         break;
      }
      mav.addObject("category_list", category_list);

      return mav;
   }

   // 移댄뀒怨좊━ �닔�젙
   @RequestMapping(value = "/admin/updateCategory")
   public ModelAndView updateCategory(@RequestParam(value = "category_type") int category_type,
         @RequestParam(value = "ca_num") int ca_num,
         @RequestParam(value = "ca_name") String ca_name) {
      System.out.println("�닔�젙 ca_num : " + ca_num);
      System.out.println("�닔�젙 category_type : " + category_type);
      System.out.println("�닔�젙 ca_name : " + ca_name);

      // �닔�젙 �쟾 移댄뀒怨좊━
      Category c1 = admin_Service.selectCategory(ca_num, category_type);
      // �닔�젙 �썑 移댄뀒怨좊━
      Category c2 = new Category(ca_num, ca_name, c1.getParent_category_num());
      admin_Service.updateCategory(c2, category_type);

      ModelAndView mav = new ModelAndView("/admin/categoryJSON");
      ArrayList<Category> category_list = null;

      switch (category_type) {
      case 1:
         category_list = (ArrayList<Category>) admin_Service.selectAllCategory(0, 1);
         break;
      case 2:
         category_list = (ArrayList<Category>) admin_Service.selectAllCategory(c2.getParent_category_num(), 2);
         break;
      }
      mav.addObject("category_list", category_list);

      return mav;
   }

   // 移댄뀒怨좊━ �궘�젣
   @RequestMapping(value = "/admin/deleteCategory")
   public ModelAndView updateCategory(@RequestParam(value = "category_type") int category_type,
         @RequestParam(value = "ca_num") int ca_num) {
      System.out.println("�궘�젣�슜 ca_num : " + ca_num);
      System.out.println("�궘�젣�슜 category_type : " + category_type);

      Category c1 = admin_Service.selectCategory(ca_num, category_type);
      admin_Service.deleteCategory(ca_num, category_type);

      ModelAndView mav = new ModelAndView("/admin/categoryJSON");
      ArrayList<Category> category_list = null;

      switch (category_type) {
      case 1:
         category_list = (ArrayList<Category>) admin_Service.selectAllCategory(0, 1);
         break;
      case 2:
         category_list = (ArrayList<Category>) admin_Service.selectAllCategory(c1.getParent_category_num(), 2);
         break;
      }
      mav.addObject("category_list", category_list);

      return mav;
   }
   // ==================== User ====================

   // �쉶�썝 寃��깋
   @RequestMapping(value = "/admin/selectUser")
   public ModelAndView selectUser(@RequestParam(value = "user_id") String user_id) {

      ModelAndView mav = new ModelAndView("/admin/userJSON");

      // user_id濡� DB�뿉�꽌 User �젙蹂� 媛��졇�삤湲�
      User u = user_Service.checkUserId(user_id);

      // �쉶�썝�씠 議댁옱�븯吏� �븡�쓣 �븣
      if (u == null) {
         mav.addObject("user_id", "");
         mav.addObject("user_name", "");
         mav.addObject("user_nickname", "");
         mav.addObject("user_type", 3);
      } else {
         mav.addObject("user_id", u.getUser_id());
         mav.addObject("user_name", u.getUser_name());
         mav.addObject("user_nickname", u.getUser_nickname());
         mav.addObject("user_type", u.getUser_type());
      }

      return mav;
   }

   // �쉶�썝 �궘�젣
   @RequestMapping(value = "/admin/deleteUser")
   public ModelAndView deleteUser(@RequestParam("user_id") String user_id) {

      System.out.println("愿�由ъ옄 �쉶�썝 �궘�젣 controller"+user_id);
      ModelAndView mav = new ModelAndView("/admin/userJSON");

      User u = user_Service.checkUserId(user_id);
      System.out.println(u);
      if (u == null) {
         System.out.println("愿�由ъ옄 �쉶�썝 �궘�젣 controller : 議댁옱�븯吏� �븡�뒗 �쉶�썝");
         mav.addObject("user_id", "");
         mav.addObject("user_name", "");
         mav.addObject("user_nickname", "");
         mav.addObject("user_type", 3);
      } else {
         System.out.println("愿�由ъ옄 �쉶�썝 �궘�젣 controller : 愿�由ъ옄 or �쉶�썝");
         mav.addObject("user_id", u.getUser_id());
         mav.addObject("user_name", u.getUser_name());
         mav.addObject("user_nickname", u.getUser_nickname());
         mav.addObject("user_type", u.getUser_type());
         
         if (u.getUser_type() == 1) {
 //       	 wish_Service.delwishAll(user_id);
        	 user_Service.deleteUser(user_id);
            System.out.println("愿�由ъ옄 �쉶�썝 �궘�젣 controller : �쉶�썝 �넂 �궘�젣�셿猷�");
         } 
      }

      return mav;
   }

}