package com.SwagLabs;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.SwagLab_POM.Slider_POM;

public class slider extends Base{

	@Test
	public void slider() {
	File file = new File("C:\\Users\\USHA PRAMOD\\Desktop\\html projects for selenium\\slider.html");
	
	String filePath = "file:///" + file.getAbsolutePath();
	driver.get(filePath);
	
	
	
Slider_POM slider = new Slider_POM(driver);

}
}