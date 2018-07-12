package com.guoyasoft.pageDesign;

import org.testng.Assert;

import com.guoyasoft.common.BaseUI;

public class UserListPage extends BaseUI{
	
	public void checkSearchResult(){
		switchToFrame("result");
		contains("吴令");
	}
}
