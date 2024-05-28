package com.capstoneProject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PageObjects {

	public static WebDriver driver = new ChromeDriver();
	public static String timestamp = new SimpleDateFormat("dd-MMM-YYYY__hh_mm_ssaa").format(new Date());
	public static ExtentSparkReporter spark = new ExtentSparkReporter("./TestReport/" + timestamp + ".html");
	public static ExtentReports extent = new ExtentReports();;
	public static ExtentTest logger;

	public static String URL = "http://localhost:8080/medicare/";
	public static String login_xpathLocator = "//a[@href='/medicare/login']";
	public static String email_xpathLocator = "//input[@id='username']";
	public static String password_xpathLocator = "//input[@id='password']";
	public static String login2_xpathLocator = "//input[@type='submit']";
	public static String profile_xpathLocator = "//a[@class='btn btn-default dropdown-toggle']";
	public static String cart_xpathLocator = "//a[@href='/medicare/cart/show']";
	public static String selectProduct_xpathLocator = "(//a[@class='btn btn-primary pull-right'])[2]";
	public static String selectedProductName_xpathLocator = "(//h5[@class='ng-binding'])[2]";
	public static String addToCart_xpathLocator = "//a[@class='btn btn-success']";
	public static String addedProductNames_xpathLocator = "//h4[@class='nomargin']";
	public static String logout_xpathLocator = "//a[@href='/medicare/logout']";

	public static WebElement Login() {
		return driver.findElement(By.xpath(login_xpathLocator));
	}

	public static WebElement Email() {
		return driver.findElement(By.xpath(email_xpathLocator));
	}

	public static WebElement Password() {
		return driver.findElement(By.xpath(password_xpathLocator));
	}

	public static WebElement Login2() {
		return driver.findElement(By.xpath(login2_xpathLocator));
	}

	public static WebElement Profile() {
		return driver.findElement(By.xpath(profile_xpathLocator));
	}

	public static WebElement Cart() {
		return driver.findElement(By.xpath(cart_xpathLocator));
	}

	public static WebElement selectProduct() {
		return driver.findElement(By.xpath(selectProduct_xpathLocator));
	}

	public static WebElement selectedProductNameText() {
		return driver.findElement(By.xpath(selectedProductName_xpathLocator));
	}

	public static WebElement addToCart() {
		return driver.findElement(By.xpath(addToCart_xpathLocator));
	}

	public static WebElement addedProductNameText() {

		List<WebElement> Lst1 = driver.findElements(By.xpath(addedProductNames_xpathLocator));
		int len1 = Lst1.size();
		return Lst1.get(len1 - 1);
	}

	public static WebElement Logout() {
		return driver.findElement(By.xpath(logout_xpathLocator));
	}
}
