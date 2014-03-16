package com.supermarket.action;

import javax.servlet.http.HttpSession;

import com.mvc.http.aware.HttpAware;

public class SuperMarketAction extends HttpAware {

	//退出系統
	public String logout(){
		HttpSession session = request.getSession();
		//使session失效
		session.invalidate();
		return SUCCESS;
	}
	
	//返回首頁
	public String main() {
		return SUCCESS;
	}
}
