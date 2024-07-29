package com.sportyshoes.signup;

import static com.sportyshoes.helper.Constants.*;
import static org.testng.Assert.assertTrue;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.sportyshoes.database.DatabaseOperations;
import com.sportyshoes.config.BaseConfigurationTests;
import com.sportyshoes.handler.CommonHandler;
import com.sportyshoes.handler.SignUpHandler;

public class SignUpTests extends BaseConfigurationTests{
	private static final Logger log = LoggerFactory.getLogger(SignUpTests.class);

	CommonHandler commonHandler = new CommonHandler();
	SignUpHandler signUpHandler = new SignUpHandler();
	DatabaseOperations databaseOperations = new DatabaseOperations();

	@Test(description = "Verify signup page with valid member details")
	public void verifySignUpPageWithValidUserDetails() {
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, AGE,ADDRESS);
		validateMessage(driver, SIGNUP_CONFIRMATION_MESSAGE);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);

	}

	// Verify sign up page with Empty User Details
	@Test(description = "Verify signup page with Empty User Details")
	public void verifySignUpPageWithEmptyUserDetails() {
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setEmptyMemberDetails(driver, EMPTY_STR, EMPTY_STR, EMPTY_STR, EMPTY_STR, EMPTY_STR, EMPTY_STR,EMPTY_STR);
		validateMessage(driver, SIGNUP_CONFIRMATION_MESSAGE);

	}

	// Verify signup page with email is blank
	@Test(description = "signup page with Email is blank")
	public void verifyEmailIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMPTY_STR, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, AGE,ADDRESS);
		validateMessage(driver, EMAIL_ID_REQUIRED);

	}

	// Verify signup page with password is blank
	@Test(description = "signup page with password is blank")
	public void verifyPasswordIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, EMPTY_STR, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, AGE,ADDRESS);
		validateMessage(driver, PASSWORD_INCOMPLETE);

	}

	// Verify signup page with Confirm password is blank
	@Test(description = "signup page with Confirm password is blank")
	public void verifyConfirmPasswordIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, EMPTY_STR, FIRST_NAME, LAST_NAME, AGE, ADDRESS);
		validateMessage(driver, PASSWORD_INCOMPLETE);
			

	}

	// Verify signup page with first name is blank
	@Test(description = "signup page with first name is blank")
	public void verifyFirstNameIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, EMPTY_STR, LAST_NAME, AGE,ADDRESS);
		validateMessage(driver, FIRST_NAME_REQUIRED);

	}

	// Verify signup page with last name is blank
	@Test(description = "signup page with last name is blank")
	public void verifyLastNameIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, EMPTY_STR, AGE,ADDRESS);
		validateMessage(driver, LAST_NAME_REQUIRED);
	}

	// Verify sign up page with age is blank
	@Test(description = "Verify signup page with age is blank")
	public void verifyAgeIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setEmptyMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, EMPTY_STR, ADDRESS);

	}

	// Verify sign up page with address is blank
	@Test(description = "Verify signup page with address is blank")
	public void verifyAddressIsBlank() throws SQLException {
		databaseOperations.cleanUserDetails(EMAIL_ID);
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, AGE,EMPTY_STR);

	}

	// Verify signup page with email id is already taken
	@Test(description = "signup page with email id is already taken")
	public void verifyEmailIsAlreadyTaken() {
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, AGE,ADDRESS);
		validateMessage(driver, EMAIL_ID_EXITS_MESSAGE);

	}

	// verify already member login link
	@Test(description = "verify already member login link")
	public void verifyAlreadyMemeberlink() {
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_LINK);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAIL_ID, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME, AGE,ADDRESS);
		validateMessage(driver, EMAIL_ID_EXITS_MESSAGE);
		driver.findElement(By.linkText("Already a member? Login")).click();

	}

	private void validateMessage(WebDriver driver, String expectedMessage) {
		
		log.info("expectedMessage==> {} ", expectedMessage);
		System.out.println("ExpectedErrorMessage ==>"+ expectedMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedMessage));
		
		
	}

}
