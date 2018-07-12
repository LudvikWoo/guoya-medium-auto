package com.guoyasoft.pageDesign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.guoyasoft.common.BaseUI;

public class QueryUserPage extends BaseUI{
	
	@FindBy(name="realName")
	private WebElement realName;
	
	@FindBy(name="userName")
	private WebElement userName;
	
	@FindBy(name="education")
	private WebElement education;
	
	@FindBy(name="startTime")
	private WebElement startTime;
	
	@FindBy(name="endTime")
	private WebElement endTime;
	
	@FindBy(name="minAge")
	private WebElement minAge;

	@FindBy(name="maxAge")
	private WebElement maxAge;
	
	@FindBy(xpath="//input[@type='submit'")
	private WebElement submit;
	
	public void search(){
		text(realName, "");
		text(userName, "");
		textDate("startTime", "2018-07-07");
		textDate("endTime",  "2018-07-07");
		text(minAge, "20");
		text(maxAge, "30");
		click(submit);
	}
	
	public void searchByRealName(){
		text(realName, "");
		click(submit);
	}
	
	public void searchByUserName(){
		text(userName, "");
		click(submit);
	}
}
