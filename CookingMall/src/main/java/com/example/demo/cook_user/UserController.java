package com.example.demo.cook_user;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

	public static String basePath = "C:\\cookingmallImg\\";

	@Autowired
	private UserService user_Service;

	// index濡� �씠�룞
	@RequestMapping(value = "/index")
	public ModelAndView index() {

		System.out.println("泥섏쓬 �떆�옉 index text");
		ModelAndView mav = new ModelAndView("/index");

//		ArrayList<Product> list = (ArrayList<Product>) product_Service.selectProductAll();
//		Product p = new Product();
//		ArrayList<Product> indexList = new ArrayList<Product>();
//		System.out.println("list = " + list);
//
//		ArrayList<String> fileList = new ArrayList<String>();
//		String path = "";
//
//		try {
//			// 泥� 硫붿씤�럹�씠�젣 �긽�뭹 4媛쒕쭔 媛��졇�삩�떎
//			System.out.println("list.size : " + list.size());
//			for (int i = 0; i < 4; i++) {
//				System.out.println("諛섎났臾� i : " + i);
//				// �쟾泥� �긽�뭹�닔媛� 4媛� 誘몃쭔�씪 �븣
//				if (list.size() < 4) {
//					// 留덉�留� �긽�뭹�쑝濡� 梨꾩슫�떎
//					if (i < list.size()) {
//						p = list.get(i);
//						System.out.println("諛섎났臾� if list.get(i) : " + i + " " + p);
//					} else {
//						p = list.get(list.size() - 1);
//						System.out.println("諛섎났臾� else list.get(i) : " + i + " " + p);
//					}
//					path = basePath + p.getProduct_num() + "\\";
//					File imgDir = new File(path);
//
//					if (imgDir.exists()) {
//						String[] files = imgDir.list();
//						fileList.add(files[0]);
//					}
//					indexList.add(p);
//					System.out.println("if臾� p = " + p);
//				} else {
//					p = list.get(i);
//					path = basePath + p.getProduct_num() + "\\";
//					File imgDir = new File(path);
//
//					if (imgDir.exists()) {
//						String[] files = imgDir.list();
//						fileList.add(files[0]);
//					}
//					System.out.println("p = " + p);
//					indexList.add(p);
//					System.out.println("indexList�뿉 add �꽦怨�" + i + "踰덉��");
//				}
//			}
//			System.out.println(indexList);
//			System.out.println("fileList : " + fileList);
//			mav.addObject("fileList", fileList);
//			mav.addObject("indexList", indexList);
//
//		} catch (IndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		return mav;
	}

	// loginForm�쑝濡� �씠�룞
	@GetMapping(value = "/user/login")
	public void login() {

	}

	// registerAgree濡� �씠�룞
	@RequestMapping(value = "/user/registerAgree")
	public void registerAgree() {

	}

	// registerForm濡� �씠�룞
	@RequestMapping(value = "/user/registerForm")
	public void registerForm() {

	}

	// find_pwdForm�쑝濡� �씠�룞
	@RequestMapping(value = "/user/find_pwd")
	public void findPwForm() {

	}

	// ==================== �뼯 Page Control �뼯 ====================

	// �쉶�썝媛��엯 Service �떎�뻾 �썑 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "/user/register")
	public String join(User u) {

		user_Service.addUser(u);

		return "redirect:/user/login";
	}

	// 濡쒓렇�씤 �썑 硫붿씤�럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "/user/login")
	public String loginOk(HttpServletRequest request, @RequestParam(value = "user_id") String user_id) {

		User u = user_Service.checkUserId(user_id);
		HttpSession session = request.getSession();
		session.setAttribute("user_id", u.getUser_id());
		session.setAttribute("user_nickname", u.getUser_nickname());
		session.setAttribute("user_type", u.getUser_type());

		if (u.getUser_type() == 1) {
			return "redirect:/index";
		} else if (u.getUser_type() == 2) {
			return "/admin/adminMain";
		}

		return null;
	}

	// �쉶�썝寃��깋�븯�뿬 �닔�젙李쎌쓣 �쓣�슦�뒗 硫붿냼�뱶
	@RequestMapping(value = "/user/userEdit")
	public ModelAndView userEdit(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/user/userEdit");
		HttpSession session = request.getSession(false);
		String user_id = (String) session.getAttribute("user_id");

		User u = user_Service.checkUserId(user_id);
		mav.addObject("u", u);

		return mav;
	}

	// �쉶�썝�젙蹂� �닔�젙�쓣 �떎�뻾�븯�뒗 硫붿냼�뱶
	@RequestMapping(value = "user/edit")
	public String edit(HttpServletRequest request, RedirectAttributes redirect, User u,
						@RequestParam(value = "user_id") String user_id) {

		HttpSession session = request.getSession(false);
		session.setAttribute("user_nickname", u.getUser_nickname());

		user_Service.editUser(u);

		redirect.addAttribute("user_id", user_id);

		return "redirect:/user/userProfile";
	}

	// 濡쒓렇�븘�썐 �썑 硫붿씤�럹�씠吏�濡� �씠�룞
	@RequestMapping(value = "/user/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		session.removeAttribute("user_id");
		session.invalidate();

		return "redirect:/index";
	}

	// �쉶�썝 �깉�눜瑜� �떎�뻾�븯�뒗 硫붿냼�뱶
	@RequestMapping(value = "/user/userDelete")
	public String userDelete(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		String user_id = (String) session.getAttribute("user_id");
		user_Service.deleteUser(user_id);

		session.removeAttribute("user_id");
		session.invalidate();

		return "redirect:/index";
	}

	// �븘�씠�뵒 以묐났 寃��궗
	@RequestMapping(value = "/user/IdCheck")
	@ResponseBody
	public String checkId(@RequestParam(value = "user_id") String user_id) {
		
		int id_result = user_Service.idCheck(user_id);
		
		if (id_result != 0) {
			return "fail"; // 以묐났�맆 �븣
		} else {
			return "success"; // 以묐났�릺吏� �븡�쓣 �븣
		}
	}

	// �땳�꽕�엫 以묐났 寃��궗
	@RequestMapping(value = "/user/nicknameCheck")
	@ResponseBody
	public String checkName(@RequestParam(value = "user_nickname") String user_nickname) {
		
		int name_result = user_Service.nicknameCheck(user_nickname);
		
		if (name_result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}

	// �씠硫붿씪 以묐났 寃��궗
	@RequestMapping(value = "/user/emailCheck")
	@ResponseBody
	public String checkEmail(@RequestParam(value = "user_email") String user_email) {
		
		int name_result = user_Service.emailCheck(user_email);
		
		if (name_result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}

	// �엫�떆 鍮꾨�踰덊샇李얘린
	@RequestMapping(value = "/user/pwCheck")
	public ModelAndView findPw(@RequestParam(value = "user_email") String user_email) {
		
		ModelAndView mav = new ModelAndView("/user/pwCheck");
		String result = "";
		User u = user_Service.selectUserEmail(user_email);

		if (u == null) {
			result = "�쑀�슚�븯吏��븡�� �씠硫붿씪";
		} else {
			result = u.getUser_nickname() + " �떂�쓽 鍮꾨�踰덊샇�뒗 " + u.getUser_pwd() + " �엯�땲�떎.";
		}
		mav.addObject("result", result);

		return mav;
	}
	
	// 濡쒓렇�씤 �떆 �븘�씠�뵒 & 鍮꾨�踰덊샇 泥댄겕
	@RequestMapping(value = "/user/userLoginCheck")
	public ModelAndView loginCheck(@RequestParam(value = "user_id") String user_id, @RequestParam(value = "user_pw") String user_pw) {
		
		ModelAndView mav = new ModelAndView("user/userLoginCheckJSON");
		User u = user_Service.checkUserId(user_id);
		String pwd2 = u.getUser_pwd();
		String result = "";
		
		if (!user_pw.equals(pwd2)) {
			result = "鍮꾨�踰덊샇媛� 留욎� �븡�뒿�땲�떎";
			mav.addObject("result", result);
		} else {
			mav.addObject("result", result);
			mav.addObject("user_id", user_id);
		}
		
		return mav;
	}

}

