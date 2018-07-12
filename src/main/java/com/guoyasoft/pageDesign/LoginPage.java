package com.guoyasoft.pageDesign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.guoyasoft.common.BaseUI;

public class LoginPage extends BaseUI{
	
	@FindBy(id="userName")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="checkCode")
	private WebElement checkCode;
	
	@FindBy(id="loginBtn")
	private WebElement loginBtn;
	
	@FindBy(xpath="//input[@Type='reset']")
	private WebElement reset;
	
	
	public void login(LoginBean bean){
		text(userName, bean.getUserNameValue());
		text(password, bean.getPasswordValue());
		text(checkCode, bean.getCheckcodeValue());
		click(loginBtn);
		contains(bean.getExpection());
	}
	
	public void reset(){
		text(userName, "wuling23");
		text(password, "qweasd");
		text(checkCode, "12345");
		click(reset);
		String userNameValue=userName.getAttribute("value");
		boolean actual=userNameValue==null || "".equals(userNameValue);
		Assert.assertEquals(actual, true);
	}

}
