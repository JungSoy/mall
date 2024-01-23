package com.project.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.mall.model.CartVO;
import com.project.mall.model.UserVO;
import com.project.mall.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	//0 : 등록 실패
	//1 : 등록 성공
	//2 : 등록된 데이터 존재
	//5 : 로그인 필요
	
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPOST(CartVO cart, HttpServletRequest request) {
		
		//로그인 체크
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("user");
		if(uvo == null) {
			return "5";
		}
		
		// 카트 등록
		int result = cartService.addCart(cart);
		
		return result + "";

	}
}
