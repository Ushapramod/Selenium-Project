package com.SwagLab_POM;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class DropDown_POM {
	public WebDriverWait wait;
	SoftAssert softassert;
	public static Logger log = LogManager.getLogger(DropDown_POM.class);
	

	
	@FindBy(id = "primaryDropdown")
	private WebElement primaryDropdown;

	@FindBy(id = "secondaryDropdown")
	private WebElement secondaryDropdown;

	public DropDown_POM(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		log.info("DropDown PAge Initilized");
		this.softassert = new SoftAssert();
		
	}

	public void PrimaryDropdown() {
		
		wait.until(ExpectedConditions.visibilityOf(primaryDropdown));
		primaryDropdown.click();
		Select select = new Select(primaryDropdown);
		select.selectByIndex(1);
		softassert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1","Primary Dropdown Selection Failed");
		log.info("Primary dropDownSelected");
	}

	public void SecondaryDropdown() {
		wait.until(ExpectedConditions.visibilityOf(secondaryDropdown));
		secondaryDropdown.click();
		Select select = new Select(primaryDropdown);
		select.selectByIndex(1);
		softassert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1","Secondary dropdown selection failed");
		softassert.assertAll();
	}

}
