package com.SwagLab_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest_POM {
	public WebDriverWait wait;
	public static Logger log = LogManager.getLogger(LoginTest_POM.class);

	@FindBy(id = "user-nam")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	public LoginTest_POM(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		log.info("Login Page Object Initialized");
	}

	public void userName(String user_Name) {
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(user_Name);
	}

	public void password(String pass_word) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass_word);
	}

	public void loginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
	}

}
