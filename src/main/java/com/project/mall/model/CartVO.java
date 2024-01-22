package com.project.mall.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class CartVO {
	
	//cart
	private int cartId, userNo, bookId, cartCount;
	
	//book
	private String bookName;
	private int bookPrice;
	private double bookDiscount;
	
	@Setter(AccessLevel.NONE)
	private int salePrice, totalPrice;
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.bookDiscount));
		this.totalPrice = this.salePrice*this.cartCount;
	}
	
}
