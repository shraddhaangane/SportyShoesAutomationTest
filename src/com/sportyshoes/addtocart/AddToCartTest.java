package com.sportyshoes.addtocart;
import static com.sportyshoes.helper.Constants.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sportyshoes.config.BaseConfigurationTests;
import com.sportyshoes.handler.CommonHandler;
import com.sportyshoes.handler.MemberLoginHandler;

public class AddToCartTest extends BaseConfigurationTests {
	CommonHandler commonHandler = new CommonHandler();
	MemberLoginHandler loginHandler = new MemberLoginHandler();
	
	//Verify user is able to view all product list
    @Test(description = "Verify user is able to view product list")
    public void verifyUserAbleToViewtProduct() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(HOME_LINK)).click();
    }
    //Verify user is able to select product and add into cart
    @Test(description = "Verify user is able to select product and add into cart")
    public void verifyUserToSelectandAddToCartProduct() {
		driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(HOME_LINK)).click();
        driver.findElement(By.xpath(ADD_TO_CART_PRODUCT_1)).click();
        driver.findElement(By.xpath(CHECKOUT_NOW_LINK)).click();
}
  //Validate One item is added to the cart and checkout is working
    @Test(description = "Validate One item is added to the cart and checkout is working")
    public void validateOneItemAddToCartAndCheckout() {
    	driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(HOME_LINK)).click();
        driver.findElement(By.xpath(ADD_TO_CART_PRODUCT_1)).click();
        driver.findElement(By.xpath(CHECKOUT_NOW_LINK)).click();
        driver.findElement(By.xpath(PAYMENTGATWAY_LINK)).click();
        driver.findElement(By.xpath(GO_TO_PURCHASE_LINK)).click();
        driver.findElement(By.linkText(ORDER_HISTORY_LINK_TEXT)).click();

    }
    
    //Validate Two Items added to the cart and checkout is working
    @Test(description = "Validate Two item is added to the cart and checkout is working")
    public void validateTwoItemAddToCartAndCheckout() {
    	driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(HOME_LINK)).click();
        driver.findElement(By.xpath(ADD_TO_CART_PRODUCT_1)).click();
        driver.findElement(By.xpath(HOME_LINK)).click();
        driver.findElement(By.xpath(ADD_TO_CART_PRODUCT_2)).click();
        driver.findElement(By.xpath(CHECKOUT_NOW_LINK)).click();
        driver.findElement(By.xpath(PAYMENTGATWAY_LINK)).click();
        driver.findElement(By.xpath(GO_TO_PURCHASE_LINK)).click();
        driver.findElement(By.linkText(ORDER_HISTORY_LINK_TEXT)).click();

    }   
    
    //Verify user is able to select product and also allow to remove the record form cart
    @Test(description = "Verify user is able to select product and also allow to remove the record form cart")
    public void verifyUserToSelectandRemoveProduct() {
    	driver.findElement(By.xpath(LINK_TEXT_LOGIN_SIGNUP_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAIL_ID, PASSWORD);
		driver.findElement(By.xpath(HOME_LINK)).click();
        driver.findElement(By.xpath(ADD_TO_CART_PRODUCT_1)).click();
        driver.findElement(By.xpath(REMOVE_ORDER_LINK)).click();
        	
    }
    
 
}