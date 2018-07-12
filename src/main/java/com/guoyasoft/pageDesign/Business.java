package com.guoyasoft.pageDesign;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guoyasoft.common.BaseUI;

public class Business extends BaseUI{
	@Test
	@Parameters({"userName","password","checkcode","expection"})
	public void testLoginModel(String userNameValue,String passwordValue,String checkcodeValue,String expection){
		
		LoginBean bean=new LoginBean();
		bean.setUserNameValue(userNameValue);
		bean.setPasswordValue(passwordValue);
		bean.setCheckcodeValue(checkcodeValue);
		bean.setExpection(expection);
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.reset();
		loginPage.login(bean);
		
		QueryUserPage queryUserPage=PageFactory.initElements(driver, QueryUserPage.class);
		queryUserPage.search();
		
		UserListPage userListPage=PageFactory.initElements(driver, UserListPage.class);
		userListPage.checkSearchResult();
	}
}
