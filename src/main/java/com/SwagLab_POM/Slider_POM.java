package com.SwagLab_POM;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Slider_POM {
	public WebDriverWait wait;
	SoftAssert softassert;
	public static Logger log = LogManager.getLogger(Slider_POM.class);
	

	
	@FindBy(id = "slider")
	private WebElement slider;

	

	public Slider_POM(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		log.info("DropDown PAge Initilized");
		this.softassert = new SoftAssert();
		
	}

	@Test
	public void method1()
	{System.out.println("slidermethod 1");}
	
	@Test
	public void method2()
	{System.out.println("slidermethod 2");}
	
	@Test
	public void method3()
	{System.out.println("slidermethod 3");}
	@Test
	public void method4()
	{System.out.println("slidermethod 4");}
	@Test
	public void method5()
	{System.out.println("slidermethod 5");}
	@Test
	public void method6()
	{System.out.println("slidermethod 6");}
	@Test
	public void method7()
	{System.out.println("slidermethod 7");}
	@Test
	public void method8()
	{System.out.println("slidermethod 8");}
	@Test
	public void method9()
	{System.out.println("slidermethod 9");}
	@Test
	public void method10()
	{System.out.println("slidermethod 10");}
}
