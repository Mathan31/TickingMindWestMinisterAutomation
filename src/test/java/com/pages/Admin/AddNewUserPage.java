package com.pages.Admin;


public class AddNewUserPage extends UserSecurityPage {


   private String addNewUserText = "//div[text()='Add New user']";
   private String applyBtn = "//span[text()='Apply']";
  
   
   public AddNewUserPage validateNewClientPage() {
		waitForElementToLoad(addNewUserText);
		if(isVisible(addNewUserText, "Add New User Text")) {
			reportPass("User reaches to the right Add New User page");
		} else {
			reportFailAndThrowException("Add New User Page is not loaded.");
		}
		return this;
	}
     
   public AddNewUserPage typeFirstName(String userFirstName) {
	   type(frameClientDetailsLocator("First Name"), userFirstName, "UserFirstName");
	   return this;
   }
   
   public AddNewUserPage typeLastName(String userLastName) {
	   pause("low");
	   type(frameClientDetailsLocator("Last Name"), userLastName, "UserLastName");
	   return this;
   }
   
   public AddNewUserPage typeUserEmail(String email) {
	   typeWithType(frameClientDetailsLocator("Email"), email, "Email");
	   pause("low");
	   return this;
   }
   
   public AddNewUserPage typePhoneNo(String phoneNo) {
	   type(frameClientDetailsLocator("Phone Number",2), phoneNo, "PhoneNo");
	   return this;
   }
   
   public AddNewUserPage clickAndselectTier(String tier) {
	   clickAndChoose(frameClientDetailsLocator("Tier",2), frameUserSelectDropDownLocator(tier), tier, "Tier");
	   return this;
   }
   
   public AddNewUserPage clickAndselectRole(String role) {
	   pause("low");
	   clickAndChoose(frameClientDetailsLocator("Roles",1), selectRolesCheckBox(role), role, "Roles");
	   return this;
   }
   
  
   public AddNewUserPage fillUserInformation(String firstName,String lastName,String email,String phoneNo,String tier,String role) {
	   waitForElementToLoad(frameClientDetailsLocator("First Name"));
	   typeFirstName(firstName)
	   .typeLastName(lastName)
	   .typeUserEmail(email)
	   .typePhoneNo(phoneNo)
	   .clickAndselectTier(tier)
	   .clickAndselectRole(role);
	    return this;
   }
      
   public UserSecurityPage clickOnApplyBtn() {
	   click(applyBtn, "Apply Button");
	   pause("medium");
	   return new UserSecurityPage();
   }
   
   
  
}


