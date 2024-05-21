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
public class TC02_FileManager extends WestMinsterPageHook{

	@BeforeTest
	public void setReportValues() {
		testcaseName = "File Upload";
		testDescription = "Create File Upload";
		authors = "Mathan";
		category = "Regression";

	}

	@Test(priority = 1, groups = {TestGroups.Feature.ADMIN})
	public void fileManager() {
		clientCompanyName.set(FakerDataFactory.getCompanyNameWithoutSpace());
		new DashboardPage()
		.validateDashBoardElements()
		.clickOnAdmin()
		.validateAdminPage()
		.clickOnFileManager()
		.validateFileManagerPage()
		.clickOnHomePage();
		
	}
	
}
