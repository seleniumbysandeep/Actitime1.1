package com.actitime.testscript;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTimePolymor {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static WebDriver driver;
	public static void main(String[] args) {
		System.out.println("Enter the Browser Name");
		Scanner sc=new Scanner(System.in);
		String browser = sc.nextLine();
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().window().minimize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			
			
			
			
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			driver=new InternetExplorerDriver();
		}		
		driver.get("https://www.instagram.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}
}








