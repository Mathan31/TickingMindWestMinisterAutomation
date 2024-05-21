package com.page.base;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.config.ConfigurationManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.ui.base.ProjectHooks;

public class WestMinsterPageHook extends ProjectHooks{
	

	public static String userLevel = ConfigurationManager.configuration().appUserName();
	public static String password = ConfigurationManager.configuration().appPassword();
	public static final ThreadLocal<String> clientCompanyName = new ThreadLocal<>();
	public static final ThreadLocal<String> userFirstName = new ThreadLocal<>();
	public static final ThreadLocal<String> userLastName = new ThreadLocal<>();
	
	/**
	 * Will be invoked before once for every test case execution and
	 * a) will launch the browser based on config
	 * b) create reporting structure
	 * c) store login state (if configured)
	 * d) create context, page
	 * e) set default time out based on config
	 * f) maximize and load the given URL
	 * @author Mathan
	 */
	@Parameters("Browser")
	@BeforeClass
	public void initBrowserAndDoLogin(@Optional("chrome") String browser) {
		try {
			// Launch the browser (based on configuration) in head(less) mode (based on configuration)
			setBrowser(browser, ConfigurationManager.configuration().headless());

			// Set the extent report node for the test
			setNode();
			NewContextOptions newContext;
			// Default Settings
			if(!ConfigurationManager.configuration().browser().equalsIgnoreCase("cloud")) {
				newContext = new Browser.NewContextOptions()
						.setIgnoreHTTPSErrors(true)
						.setRecordVideoDir(Paths.get(folderName));
			}else {
				
				newContext = new Browser.NewContextOptions()
						.setIgnoreHTTPSErrors(true);
			}
			

			// Auto Login if enabled
			if(ConfigurationManager.configuration().autoLogin()) {
				newContext.setStorageStatePath(Paths.get("storage/login.json"));
			} 

			// Store for Auto Login, Set the video recording ON using context
			context.set(getBrowser().newContext(newContext));
			
			getContext().setDefaultNavigationTimeout(ConfigurationManager.configuration().timeout());

			// Create a new page and assign to the thread local
			page.set(getContext().newPage());

			// Set the timeout based on the configuration
			getPage().setDefaultTimeout(ConfigurationManager.configuration().timeout());

			// 	enable Tracing
			if(ConfigurationManager.configuration().enableTracing())
				getContext().tracing().start(new Tracing.StartOptions().setName(testcaseName).setSnapshots(true).setTitle(testcaseName));

			// Get the screen size and maximize
			//maximize();

			// Load the page with URL based on configuration
			navigate(ConfigurationManager.configuration().baseStagingUrl());
			new MenuPage().doLogin(userLevel, password);

		} catch (Exception e) {
			reportStep("The browser and/or the URL could not be loaded as expected", "fail");
		}
	}
	

}
