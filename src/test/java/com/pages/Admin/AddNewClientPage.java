package com.pages.Admin;


public class AddNewClientPage extends UserSecurityPage {


   private String addNewClientText = "//div[text()='Add New client']";
   private String applyBtn = "//span[text()='Apply']";
   
   public AddNewClientPage validateNewClientPage() {
		waitForElementToLoad(addNewClientText);
		if(isVisible(addNewClientText, "Add New Client Text")) {
			reportPass("User reaches to the right Add New Client page");
		} else {
			reportFailAndThrowException("Add New Client Page is not loaded.");
		}
		return this;
	}
   
   public AddNewClientPage typeCompanyName(String companyName) {
	   typeWithType(frameClientDetailsLocator("Company Name"), companyName, "companyName");
	   return this;
   }
   
   public AddNewClientPage typeWRAClientID(String wraClientID) {
	   type(frameClientDetailsLocator("WRA Client ID"), wraClientID, "WRAClientID");
	   return this;
   }
   
   public AddNewClientPage typeFTPFolderAcronym(String ftpFolderAcronym) {
	   typeWithType(frameClientDetailsLocator("FTP Folder Acronym"), ftpFolderAcronym, "FTPFolderAcronym");
	   return this;
   }
   
   public AddNewClientPage typeAdminFirstName(String adminFirstName) {
	   type(frameClientDetailsLocator("Admin Contact First Name"), adminFirstName, "AdminFirstName");
	   return this;
   }
   
   public AddNewClientPage typeAdminLastName(String adminLastName) {
	   type(frameClientDetailsLocator("Admin Contact Last Name"), adminLastName, "AdminLastName");
	   return this;
   }
   
   public AddNewClientPage typeAdminContactEmail(String adminContactEmail) {
	   typeWithType(frameClientDetailsLocator("Admin Contact Email"), adminContactEmail, "AdminContactEmail");
	   return this;
   }
   
   public AddNewClientPage typeAdminContactPhoneNo(String adminContactPhoneNo) {
	   type(frameClientDetailsLocator("Admin Contact Phone Number",2), adminContactPhoneNo, "AdminContactPhoneNo");
	   return this;
   }
   
   public AddNewClientPage clickAndselectDateFormating(String dateFormat) {
	   clickAndChoose(frameClientDetailsLocator("Date Formatting",2), frameClientSelectDropDownLocator(dateFormat), dateFormat, "Date Format");
	   return this;
   }
   
   public AddNewClientPage clickAndselectLocalTimeZone(String localTimeZone) {
	   clickAndChoose(frameClientDetailsLocator("Local Timezone",2), localTimeZone, localTimeZone, "Local TimeZone");
	   return this;
   }
   
   public AddNewClientPage clickAndselectTimeFormating(String timeFormat) {
	   clickAndChoose(frameClientDetailsLocator("Time Formatting",2), timeFormat, timeFormat, "Time Format");
	   return this;
   }
   
   public AddNewClientPage clickAndselectNumberFormating(String numberFormat) {
	   clickAndChoose(frameClientDetailsLocator("Number Formatting",2), numberFormat, numberFormat, "Number Format");
	   return this;
   }
   
   public AddNewClientPage clickAndselectMasterCurrency(String masterCurrency) {
	   clickAndChoose(frameClientDetailsLocator("Master Currency",2), masterCurrency, masterCurrency, "Master Currency");
	   return this;
   }
   
   public AddNewClientPage fillClientInformation(String companyName,String ftpFolderAcronym,String adminFirstName,String adminLastName,String adminContactEmail,String dateFormat,String localTimeZone,
		   String timeFormat,String numberFormat,String masterCurrency) {
	    typeCompanyName(companyName)
	   .typeFTPFolderAcronym(ftpFolderAcronym)
	   .typeAdminFirstName(adminFirstName)
	   .typeAdminLastName(adminLastName)
	   .typeAdminContactEmail(adminContactEmail)
	   .clickAndselectDateFormating(dateFormat);
//	   .clickAndselectLocalTimeZone(localTimeZone)
//	   .clickAndselectTimeFormating(timeFormat)
//	   .clickAndselectNumberFormating(numberFormat)
//	   .clickAndselectMasterCurrency(masterCurrency);
	    return this;
   }
      
   public UserSecurityPage clickOnApplyBtn() {
	   click(applyBtn, "Apply Button");
	   return new UserSecurityPage();
   }
   
   
  
}


