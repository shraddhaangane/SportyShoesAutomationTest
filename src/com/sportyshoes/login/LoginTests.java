package com.sportyshoes.login;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.sportyshoes.helper.Constants.*;

import com.sportyshoes.config.BaseConfigurationTests;
import com.sportyshoes.handler.CommonHandler;
import com.sportyshoes.handler.MemberLoginHandler;

public class LoginTests extends BaseConfigurationTests {
	private static final Logger log = LoggerFactory.getLogger(LoginTests.class);
	CommonHandler commonHandler = new CommonHandler();
	MemberLoginHandler loginHandler = new MemberLoginHandler();

	// Verify member login page with valid user details
	@Test(description = "Verify login page with valid user details")
	public void verifyLoginPageWithValidUserDetails() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);

	}

	// Verify member login page with Invalid email id
	@Test(description = "Verify login page with Invalid email id")
	public void verifyLoginPageWithInvalidEmailId() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, INVALID_EMAIL, PASSWORD);
		validateErrorMessage(driver, MESSAGE_LOGIN_FAILD);

	}

	// Verify member login page with valid email id and invalid password
	@Test(description = "Verify login page with valid emaild id and invalid password")
	public void verifyLoginPageWithvalidEmailIdandInvalidPassword() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, INVALID_PASSWORD);
		validateErrorMessage(driver, MESSAGE_LOGIN_FAILD);

	}

	@Test(description = "Verify login page with Invalid emaild id and invalid password")
	public void verifyLoginPageWithInvalidEmailIdandInvalidPassword() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, INVALID_EMAIL, INVALID_PASSWORD);
		validateErrorMessage(driver, MESSAGE_LOGIN_FAILD);
	}

	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		log.info("expectedErrorMessage==> {} ", expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}

}
