package com.pages.Admin;

import org.testng.Assert;

import com.page.base.DashboardPage;

public class UserSecurityPage extends AdminPage {

   private String userAndsecurityText = "//h1[text()='Users & Security']";
   private String usersTab = "//span[text()='Users']";
   private String addNewUserBtn = "//span[text()='Add a new user']";
   private String addNewClientBtn = "//span[text()='Add a new client']";
   private String addNewUserText = "//div[text()='Add New user']";
   private String clientGridFirstRow = "(//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines'])[1]/td[1]";
   private String searchClient = "(//div[@class='dx-icon dx-icon-search']/following-sibling::input)[1]";
   private String searchUser = "(//div[@class='dx-icon dx-icon-search']/following-sibling::input)[2]";
   
   public UserSecurityPage validateUserSecurityPage() {
		waitForElementToLoad(userAndsecurityText);
		if(isVisible(adminText, "Admin Text")) {
			reportPass("User reaches to the right Admin page");
		} else {
			reportFailAndThrowException("Admin Page is not loaded.");
		}
		return this;
	}
   
   public UserSecurityPage clickOnUserTab() {
	   click(usersTab, "User Tab");
	   pause("low");
	   waitForLoaderToDisappear();
	   waitForAppearance(addNewUserBtn);
	   return this;
   }
   
   public AddNewUserPage clickOnaddNewUsrBtn() {
	   pause("low");
	   waitForLoaderToDisappear();
	  // waitForElementToLoad(addNewUserBtn);
	   waitForAppearance(addNewUserBtn);
	   click(addNewUserBtn, "Add New User");
	   return new AddNewUserPage();
   }
   
   public AddNewClientPage clickOnaddNewClientBtn() {
	   click(addNewClientBtn, "Add New Client");
	   return new AddNewClientPage();
   }
   
   public UserSecurityPage validateAddNewUserPage() {
		waitForElementToLoad(addNewUserText);
		if(isVisible(addNewUserText, "Add New User Text")) {
			reportPass("User reaches to the right Add New User page");
		} else {
			reportFailAndThrowException("Add New User Page is not loaded.");
		}
		return this;
	}
   
   public String frameClientDetailsLocator(String placeholder) {
	  return "//span[text()='"+placeholder+"']/ancestor::label/following-sibling::div//input";
   }
   
   public String frameClientDetailsLocator(String placeholder,int index) {
	  return "(//span[text()='"+placeholder+"']/ancestor::label/following-sibling::div//input)["+index+"]";
   }
   
   public String frameClientSelectDropDownLocator(String placeholder) {
	  return "//div[@class='wdx-custom-dropdown__text']/div[text()='"+placeholder+"']";
   }
   
   
   public String selectRolesCheckBox(String placeholder) {
	   return "//div[text()='"+placeholder+"']/preceding-sibling::div";
   }
   
   public String frameUserSelectDropDownLocator(String placeholder) {
		  return "//div[@class='dx-item dx-list-item']/div[text()='"+placeholder+"']";
	   }
   
   public String frameUserSearchResult(String placeholder) {
		  return "//span[text()='"+placeholder+"']";
	   }
   
   public UserSecurityPage typeSearchClient(String clientName) {
	   waitForLoaderToDisappear();
	   type(searchClient, clientName, "Search Clients");
	   pause("low");
	   return this;
   }
   
   public UserSecurityPage typeSearchUser(String userDisplayName) {
	   type(searchUser, userDisplayName, "Search User");
	   pause("low");
	   return this;
   }
   
   public DashboardPage validateClientInformation(String clientName) {
	   waitForLoaderToDisappear();
	   typeSearchClient(clientName);
	   boolean verifyExactText = verifyExactText(clientGridFirstRow, clientName);
	   Assert.assertTrue(verifyExactText);
	   return new DashboardPage();
   }
   
   public DashboardPage validateUserInformation(String userName) {
	   waitForLoaderToDisappear();
	   pause("medium");
	   waitForLoaderToDisappear();
	   typeSearchUser(userName);
	   waitForElementToLoad(frameUserSearchResult(userName));
	   boolean verifyExactText = isVisible(frameUserSearchResult(userName));
	   Assert.assertTrue(verifyExactText);
	   return new DashboardPage();
   }
   
  
}


