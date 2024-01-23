package com.project.mall.model;

import java.sql.Date;

import lombok.Data;

@Data
public class UserVO {

	private int userNo, adminCk, userMoney, userPoint;
	private String userId, userPw, userEmail, userName, userAddr1, userAddr2, userAddr3, userDel;
	private Date userReg;
	
	
}
