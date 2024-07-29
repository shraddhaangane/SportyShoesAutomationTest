package com.sportyshoes.handler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfileHandler {
public void updateProfileDetails(WebDriver driver, String password, String confirmPassword, String fname, String lname) {
		
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.name("pwd2")).sendKeys(confirmPassword);
		driver.findElement(By.name("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys(fname);
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys(lname);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td/button")).click();
	    }

}
