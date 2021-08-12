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

	// index嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/index")
	public ModelAndView index() {

		System.out.println("筌ｌ꼷�벉 占쎈뻻占쎌삂 index text");
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
//			// 筌ｏ옙 筌롫뗄�뵥占쎈읂占쎌뵠占쎌젫 占쎄맒占쎈�� 4揶쏆뮆彛� 揶쏉옙占쎌죬占쎌궔占쎈뼄
//			System.out.println("list.size : " + list.size());
//			for (int i = 0; i < 4; i++) {
//				System.out.println("獄쏆꼶�궗�눧占� i : " + i);
//				// 占쎌읈筌ｏ옙 占쎄맒占쎈�뱄옙�땾揶쏉옙 4揶쏉옙 沃섎챶彛뷂옙�뵬 占쎈르
//				if (list.size() < 4) {
//					// 筌띾뜆占쏙쭕占� 占쎄맒占쎈�뱄옙�몵嚥∽옙 筌�袁⑹뒲占쎈뼄
//					if (i < list.size()) {
//						p = list.get(i);
//						System.out.println("獄쏆꼶�궗�눧占� if list.get(i) : " + i + " " + p);
//					} else {
//						p = list.get(list.size() - 1);
//						System.out.println("獄쏆꼶�궗�눧占� else list.get(i) : " + i + " " + p);
//					}
//					path = basePath + p.getProduct_num() + "\\";
//					File imgDir = new File(path);
//
//					if (imgDir.exists()) {
//						String[] files = imgDir.list();
//						fileList.add(files[0]);
//					}
//					indexList.add(p);
//					System.out.println("if�눧占� p = " + p);
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
//					System.out.println("indexList占쎈퓠 add 占쎄쉐�⑨옙" + i + "甕곕뜆占쏙옙");
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

	// loginForm占쎌몵嚥∽옙 占쎌뵠占쎈짗
	@GetMapping(value = "/user/login")
	public void login() {

	}

	// registerAgree嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/user/signup_agree")
	public void signup_agree() {

	}

	// registerForm嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/user/signupform")
	public void signupform() {

	}

	// find_pwdForm占쎌몵嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/user/find_pwd")
	public void findPwForm() {

	}

	// ==================== 占쎈섞 Page Control 占쎈섞 ====================

	// 占쎌돳占쎌뜚揶쏉옙占쎌뿯 Service 占쎈뼄占쎈뻬 占쎌뜎 嚥≪뮄�젃占쎌뵥 占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/user/signup")
	public String join(User u) {

		user_Service.addUser(u);

		return "redirect:/user/login";
	}

	// 嚥≪뮄�젃占쎌뵥 占쎌뜎 筌롫뗄�뵥占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/user/login")
	public String loginOk(HttpServletRequest request, @RequestParam(value = "id") String user_id) {

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

	// 占쎌돳占쎌뜚野껓옙占쎄퉳占쎈릭占쎈연 占쎈땾占쎌젟筌≪럩�뱽 占쎌뱽占쎌뒭占쎈뮉 筌롫뗄�꺖占쎈굡
	@RequestMapping(value = "/user/userEdit")
	public ModelAndView userEdit(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("/user/userEdit");
		HttpSession session = request.getSession(false);
		String user_id = (String) session.getAttribute("user_id");

		User u = user_Service.checkUserId(user_id);
		mav.addObject("u", u);

		return mav;
	}

	// 占쎌돳占쎌뜚占쎌젟癰귨옙 占쎈땾占쎌젟占쎌뱽 占쎈뼄占쎈뻬占쎈릭占쎈뮉 筌롫뗄�꺖占쎈굡
	@RequestMapping(value = "user/edit")
	public String edit(HttpServletRequest request, RedirectAttributes redirect, User u,
						@RequestParam(value = "user_id") String user_id) {

		HttpSession session = request.getSession(false);
		session.setAttribute("user_nickname", u.getUser_nickname());

		user_Service.editUser(u);

		redirect.addAttribute("user_id", user_id);

		return "redirect:/user/userProfile";
	}

	// 嚥≪뮄�젃占쎈툡占쎌뜍 占쎌뜎 筌롫뗄�뵥占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗
	@RequestMapping(value = "/user/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		session.removeAttribute("user_id");
		session.invalidate();

		return "redirect:/index";
	}

	// 占쎌돳占쎌뜚 占쎄퉱占쎈닚�몴占� 占쎈뼄占쎈뻬占쎈릭占쎈뮉 筌롫뗄�꺖占쎈굡
	@RequestMapping(value = "/user/userDelete")
	public String userDelete(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		String user_id = (String) session.getAttribute("user_id");
		user_Service.deleteUser(user_id);

		session.removeAttribute("user_id");
		session.invalidate();

		return "redirect:/index";
	}

	// 占쎈툡占쎌뵠占쎈탵 餓λ쵎�궗 野껓옙占쎄텢
	@RequestMapping(value = "/user/IdCheck")
	@ResponseBody
	public String checkId(@RequestParam(value = "user_id") String user_id) {
		
		int id_result = user_Service.idCheck(user_id);
		
		if (id_result != 0) {
			return "fail"; // 餓λ쵎�궗占쎈쭍 占쎈르
		} else {
			return "success"; // 餓λ쵎�궗占쎈┷筌욑옙 占쎈륫占쎌뱽 占쎈르
		}
	}

	// 占쎈빏占쎄퐬占쎌뿫 餓λ쵎�궗 野껓옙占쎄텢
	@RequestMapping(value = "/user/nicknameCheck")
	@ResponseBody
	public String checkName(@RequestParam(value = "nickname") String user_nickname) {
		
		int name_result = user_Service.nicknameCheck(user_nickname);
		
		if (name_result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}

	// 占쎌뵠筌롫뗄�뵬 餓λ쵎�궗 野껓옙占쎄텢
	@RequestMapping(value = "/user/emailCheck")
	@ResponseBody
	public String checkEmail(@RequestParam(value = "email") String user_email) {
		
		int name_result = user_Service.emailCheck(user_email);
		
		if (name_result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}

	// 占쎌뿫占쎈뻻 �뜮袁⑨옙甕곕뜇�깈筌≪뼐由�
	@RequestMapping(value = "/user/pwdCheck")
	public ModelAndView findPwd(@RequestParam(value = "email") String user_email) {
		
		ModelAndView mav = new ModelAndView("/user/pwdCheck");
		String result = "";
		User u = user_Service.selectUserEmail(user_email);

		if (u == null) {
			result = "占쎌�占쎌뒞占쎈릭筌욑옙占쎈륫占쏙옙 占쎌뵠筌롫뗄�뵬";
		} else {
			result = u.getUser_nickname() + " 占쎈뻷占쎌벥 �뜮袁⑨옙甕곕뜇�깈占쎈뮉 " + u.getUser_pwd() + " 占쎌뿯占쎈빍占쎈뼄.";
		}
		mav.addObject("result", result);

		return mav;
	}
	
	// 嚥≪뮄�젃占쎌뵥 占쎈뻻 占쎈툡占쎌뵠占쎈탵 & �뜮袁⑨옙甕곕뜇�깈 筌ｋ똾寃�
	@RequestMapping(value = "/user/userLoginCheck")
	public ModelAndView loginCheck(@RequestParam(value = "user_id") String user_id, @RequestParam(value = "user_pwd") String user_pwd) {
		
		ModelAndView mav = new ModelAndView("user/userLoginCheckJSON");
		User u = user_Service.checkUserId(user_id);
		String pwd2 = u.getUser_pwd();
		String result = "";
		
		if (!user_pwd.equals(pwd2)) {
			result = "鍮꾨�踰덊샇媛� 留욎� �븡�뒿�땲�떎.";
			mav.addObject("result", result);
		} else {
			mav.addObject("result", result);
			mav.addObject("user_id", user_id);
		}
		
		return mav;
	}

}

