package com.page.base;

public class MenuPage extends WestMinsterPageHook{
		
		protected String emailField = "//input[@name='username']";
		protected String passwordField = "//input[@name='password']";
		protected String loginWithPassword = "//span[text()='Login with Password']";
		protected String dashboardHover = "#navbar-nav__dashboard";
		protected String homeLink = "//a[@aria-label='Go to Home']/img";
		protected String loaderIcon = "(//div[@class='dx-loadindicator-icon'])[1]";
		//protected String loaderIcon = "(//div[text()='Loading...'])[1]";
		
		
	public void waitForLoaderToDisappear() {
		if(waitForDisappearance(loaderIcon)) {
			reportPass("Loader is disappeared");
		}else {
			reportFail("Loader is not disappeared");
		}
	}
	public MenuPage userNameIsVisible() {
		isVisible(emailField, "Username"); 
		return this;
	}
	
	public MenuPage passwordIsVisible() {
		isVisible(passwordField, "Password");
		return this;
	}
	
	public MenuPage signInIsEnabled() {
		isEnabled(loginWithPassword, "Login With Password");
		return this;
	}
	
	public MenuPage signInIsDisabled() {
		isDisabled(loginWithPassword, "Login With Password");
		return this;
	}
	
	public MenuPage typeUserName(String username) {
		//type(emailField, username, "Username");
		typeWithType(emailField, username, "Username");
		return this;
	}
	
	public MenuPage typePassword(String password) {
		//type(passwordField, password, "Password");
		typeWithType(passwordField, password, "Username");
		return this;
	}
	
	public MenuPage clickLoginWithPassword() {
		click(loginWithPassword, "Login With Password");
		return this;
	}
	
	public MenuPage validateLoginElements() {
		waitForLoaderToDisappear();
		waitForElementToLoad(emailField);
		if(getPage().title().contains("Login | Westminster")) {
			reportPass("User reaches to the right Sign In page");
			userNameIsVisible()
			.passwordIsVisible()
			.signInIsDisabled();
		} else {
			reportFailAndThrowException("Sign-In Page is not loaded.");
		}
		return this;
	}
	
	  public DashboardPage mouseHoverOnDashboard() {
	    	if(mouseOver(dashboardHover, "Dashboard MouseHover")) {
	    		reportPass("Mouse Hover on Dashboard is success.");
	    	}else {
	    		reportFailAndThrowException("Mouser Hover on Dashboard is failed");
	    	}
	    	return new DashboardPage();
	    }
	
	public DashboardPage doLogin(String userName,String password) {
		validateLoginElements()
		.typeUserName(userName)
		.typePassword(password);
		if(isEnabled(loginWithPassword, "Login With Password")) {
			clickLoginWithPassword();
		}else {
			reportFailAndThrowException("login With Password is not enabled");
		}
		pause("medium");
		waitForLoaderToDisappear();
		return new DashboardPage();
	}
	

}
