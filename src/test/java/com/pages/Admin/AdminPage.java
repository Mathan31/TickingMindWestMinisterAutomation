package com.pages.Admin;

import com.page.base.MenuPage;

public class AdminPage extends MenuPage {

   protected String userAndSecurity = "//span[contains(text(),'Users & Security')]";
   protected String fileManager = "//span[contains(text(),'File Manager')]";
   protected String adminText = "//h1[text()='Admin']";
   
   public AdminPage validateAdminPage() {
		waitForElementToLoad(adminText);
		if(isVisible(adminText, "Admin Text")) {
			reportPass("User reaches to the right Admin page");
		} else {
			reportFailAndThrowException("Admin Page is not loaded.");
		}
		return this;
	}
   
   public UserSecurityPage clickOnUserSecurity() {
	   click(userAndSecurity, "User & Security");
	   waitForLoaderToDisappear();
	   return new UserSecurityPage();
   }

   public FileManagerPage clickOnFileManager() {
	   click(fileManager, "FileManager");
	   waitForLoaderToDisappear();
	   return new FileManagerPage();
   }

}
