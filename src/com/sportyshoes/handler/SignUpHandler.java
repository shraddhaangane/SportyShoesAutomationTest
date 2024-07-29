package com.sportyshoes.handler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpHandler {
public void setMemberDetails(WebDriver driver, String emailid, String password, String confirmPassword, String fname, String lname, Integer age, String address) {
		
		driver.findElement(By.name("email_id")).sendKeys(emailid);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.name("pwd2")).sendKeys(confirmPassword);
		driver.findElement(By.name("fname")).sendKeys(fname);
		driver.findElement(By.name("lname")).sendKeys(lname);
		driver.findElement(By.name("age")).sendKeys(String.valueOf(age));
		driver.findElement(By.name("address")).sendKeys(address);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/button")).click();
	    }
public void clickLoginSignUpLink(WebDriver driver, String linkText) {
	driver.findElement(By.xpath(linkText)).click();
}
public void clickSignUpLink(WebDriver driver, String linklabel) {
	driver.findElement(By.xpath(linklabel)).click();
}
public void setEmptyMemberDetails(WebDriver driver, String emailid, String password, String confirmPassword, String fname, String lname, String age, String address) {
	
	driver.findElement(By.name("email_id")).sendKeys(emailid);
	driver.findElement(By.name("pwd")).sendKeys(password);
	driver.findElement(By.name("pwd2")).sendKeys(confirmPassword);
	driver.findElement(By.name("fname")).sendKeys(fname);
	driver.findElement(By.name("lname")).sendKeys(lname);
	driver.findElement(By.name("age")).sendKeys(age);
	driver.findElement(By.name("address")).sendKeys(address);
	
	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[8]/td/button")).click();
    }

}
