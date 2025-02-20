package com.SwagLabs;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.SwagLab_POM.DropDown_POM;

public class dropDown extends Base {

	@Test
	public void checkDropDownFunctionality() {
		File file = new File("C:\\Users\\USHA PRAMOD\\Desktop\\html projects for selenium\\dropdown.html"); // Update
																											// with
																											// actual
																											// file path
		String filePath = "file:///" + file.getAbsolutePath();
		driver.get(filePath);

		DropDown_POM dropdown = new DropDown_POM(driver);
		dropdown.PrimaryDropdown();

		dropdown.SecondaryDropdown();
	}
}
