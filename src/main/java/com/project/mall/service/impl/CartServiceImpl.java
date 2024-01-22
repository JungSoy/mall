package com.project.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mall.mapper.CartMapper;
import com.project.mall.model.CartVO;
import com.project.mall.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper; 
	
	@Override
	public int addCart(CartVO cart) {
		
		// 장바구니 데이터 체크
		CartVO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
