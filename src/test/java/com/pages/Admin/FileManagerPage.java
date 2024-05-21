package com.pages.Admin;

import org.testng.Assert;

import com.page.base.DashboardPage;

public class FileManagerPage extends AdminPage {

   private String fileManagerText = "//h1[text()='File Manager']";
  
   
   public DashboardPage validateFileManagerPage() {
		waitForElementToLoad(fileManagerText);
		if(isVisible(fileManagerText, "FileManagerText")) {
			reportPass("User reaches to the right File Manager  page");
		} else {
			reportFailAndThrowException("File Manager Page is not loaded.");
		}
		return new DashboardPage();
	}
   
  
}


