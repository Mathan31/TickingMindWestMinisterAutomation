package com.westminster.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.data.dynamic.FakerDataFactory;
import com.listener.TestListener;
import com.page.base.DashboardPage;
import com.page.base.WestMinsterPageHook;
import com.ui.utilities.TestGroups;

@Listeners(TestListener.class)
public class TC01_AdminScenarios extends WestMinsterPageHook{

	@BeforeTest
	public void setReportValues() {
		testcaseName = "Create Admin";
		testDescription = "Create New Admin and validate";
		authors = "Mathan";
		category = "Regression";

	}

	@Test(priority = 1, groups = {TestGroups.Feature.ADMIN})
	public void createAllotment() {
		clientCompanyName.set(FakerDataFactory.getCompanyNameWithoutSpace());
		new DashboardPage()
		.validateDashBoardElements()
		.clickOnAdmin()
		.validateAdminPage()
		.clickOnUserSecurity()
		.validateUserSecurityPage()
		.clickOnaddNewClientBtn()
		.validateNewClientPage()
		.fillClientInformation(clientCompanyName.get(), FakerDataFactory.getFTPFolderAcronym(), FakerDataFactory.getFirstName(), FakerDataFactory.getLastName(), 
				FakerDataFactory.getEmailAddress(), "MM/DD/YYYY", "", "", "", "")
		.clickOnApplyBtn()
		.validateClientInformation(clientCompanyName.get())
		.clickOnHomePage();
		
	}
	
	@Test(priority = 2, groups = {TestGroups.Feature.ADMIN})
	public void createUser() {
		testcaseName = "Create User";
		testDescription = "Create New User and Validate";
		startTestCase();
		setNode();
		userFirstName.set(FakerDataFactory.getFirstName());
		userLastName.set(FakerDataFactory.getLastName());
		String displayName = userFirstName.get()+" "+userLastName.get();
		new DashboardPage()
		.validateDashBoardElements()
		.clickOnAdmin()
		.validateAdminPage()
		.clickOnUserSecurity()
		.validateUserSecurityPage()
		.clickOnUserTab()
		.clickOnaddNewUsrBtn()
		.fillUserInformation(userFirstName.get(), userLastName.get(), FakerDataFactory.getEmailAddress(), FakerDataFactory.getContactNumber(), "Tier 1", "demo_user_role")
		.clickOnApplyBtn()
		.validateUserInformation(displayName)
		.clickOnHomePage();
	}

	

}
