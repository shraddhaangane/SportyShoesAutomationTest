package com.sportyshoes.login;

import static com.sportyshoes.helper.Constants.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.sportyshoes.config.BaseConfigurationTests;
import com.sportyshoes.handler.CommonHandler;
import com.sportyshoes.handler.EditProfileHandler;
import com.sportyshoes.handler.MemberLoginHandler;

public class EditProfileTests extends BaseConfigurationTests {
	private static final Logger log = LoggerFactory.getLogger(EditProfileTests.class);
	CommonHandler commonHandler = new CommonHandler();
	MemberLoginHandler loginHandler = new MemberLoginHandler();
	EditProfileHandler editProfileHandler = new EditProfileHandler();

	// Verify member should able to view edit profile page
	@Test(description = "Verify member should able to view edit profile page")
	public void verifyMemberAbleToViewEditProfilePage() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(EDIT_PROFILE_LINK)).click();
	}

	// Verify member should not allow to update password with invalid password
	@Test(description = "Verify member should not allow to update password with invalid password")
	public void verifyMemberNotAllowToUpdatePasswordWithInvalidPassword() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, INVALID_PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME);
		validateErrorMessage(driver, PASSWORD_DO_NOT_MATCH);
	}

	// Verify member should not allow to update password with invalid confirm
	// password
	@Test(description = "Verify member should not allow to update password with invalid confirm password")
	public void verifyMemberNotAllowToUpdatePasswordWithInvalidConfirmPassword() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, INVALID_PASSWORD, FIRST_NAME, LAST_NAME);
		validateErrorMessage(driver, PASSWORD_DO_NOT_MATCH);
	}

	// Verify member should not allow to update empty first name filed
	@Test(description = "Verify member should not allow to update empty first name filed")
	public void verifyNotAllowtoUpdateEmptyFname() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, CONFIRM_PASSWORD, EMPTY_STR, LAST_NAME);
		validateErrorMessage(driver, FNAME_IS_REQUIRED);
	}

	// Verify member should not allow to update empty last name filed
	@Test(description = "Verify member should not allow to update empty first name filed")
	public void verifyNotAllowtoUpdateEmptyLname() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, EMPTY_STR);
		validateErrorMessage(driver, LNAME_IS_REQUIRED);
	}
	
	// Verify member able to update edit profile
	@Test(description = "Verify member able to update edit profile")
	public void verifyMemberAbleToEditProfile() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME);
		
	}	

	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		log.info("expectedErrorMessage==> {}", expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}
}
