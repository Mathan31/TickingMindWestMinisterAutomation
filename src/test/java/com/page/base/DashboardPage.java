package com.page.base;

import com.config.ConfigurationManager;
import com.microsoft.playwright.Page;
import com.pages.Admin.AdminPage;

public class DashboardPage extends MenuPage{
	
	private String headerProfileMouseHover = "//label[@class='header__profile__dropdown__trigger__label']";
	
	
	private String adminHover = "#navbar-nav__admin";
	private String adminLink = "//span[text()='Admin']";
	private String saveBtn = "//div[@aria-label='Save']";
	private String clientSelectDrpDown = "(//div[@class='dx-dropdowneditor-icon'])[1]";
    private String logout = "//span[text()='Logout']";
    
    public MenuPage clickOnLogout() {
    	if(mouseOver(headerProfileMouseHover, "Header Profile MouseHover")) {
    		click(logout, "Logout");
    	}else {
    		reportFailAndThrowException("Mouser Hover on Header Profile is failed");
    	}
    	return new MenuPage();
    }
     
    public DashboardPage validateDashBoardElements() {
    	waitForLoaderToDisappear();
		//waitForElementToLoad(dashboardHover);
		if(getPage().title().contains("Dashboard | Westminster")) {
			reportPass("User reaches to the right Dashboard page");
		} else {
			reportFailAndThrowException("Dashboard page is not loaded.");
		}
		return this;
	}
    
    public AdminPage clickOnAdmin() {
    	mouseHoverOnDashboard();
    	click(adminLink, "Admin Link");
    	return new AdminPage();
    }
    
    public DashboardPage clickOnHomePage() { 
    	click(homeLink, "Home Link");
    	waitForLoaderToDisappear();
    	return this;
    }
    
	
}
