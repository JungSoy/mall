package com.project.mall.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BookVO {

	private int bookId, authId, bookPrice, bookStock, bookDiscount;
	private String bookName, bookPublisher, cateId, bookDel;
	private Date bookPyear;
}
