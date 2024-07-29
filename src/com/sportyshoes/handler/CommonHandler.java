package com.sportyshoes.handler;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.sportyshoes.helper.Constants.HOME_PAGE_URL;

public class CommonHandler {
	
	public WebDriver homePage() {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();

        return driver;
    }

}
