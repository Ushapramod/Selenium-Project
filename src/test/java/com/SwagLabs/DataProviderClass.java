package com.SwagLabs;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "loginTestDataProvider")
	public Object[][] loginTestdata() {
		return new Object[][] { { "standard_user", "secret_sauce" } };
	}
}
