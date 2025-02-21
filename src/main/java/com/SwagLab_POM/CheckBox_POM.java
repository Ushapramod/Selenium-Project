package com.SwagLab_POM;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

public class CheckBox_POM {
	public WebDriverWait wait;
	SoftAssert softassert;
	 WebDriver driver;
	 int count=0;

	public static Logger log = LogManager.getLogger(DropDown_POM.class);
	@FindBy(xpath = "//input[@type='checkbo'] ")
	private List<WebElement> checkboxes;

	public CheckBox_POM(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		log.info("DropDown PAge Initilized");
		this.softassert = new SoftAssert();
		this.driver=driver;
	}
	
	public void checkBoxes()
	{
		for(WebElement checkbox:checkboxes)
		{
			if(checkbox.isSelected())
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
