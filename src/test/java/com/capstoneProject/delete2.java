package com.capstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class delete2 {
	
	String supplierEmail = "sample@medicare.com";
	String supplierPassword = "123456";
	String userEmail = "sample2@medicare.com";
	String userPassword = "123456";
	public static WebDriver driver = new ChromeDriver();
	
	
	@BeforeTest
	public void startBrowser( ) {
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void loginAsSupplier() throws InterruptedException {
		
		driver.get(PageObjects.URL);
		Thread.sleep(2000);
		PageObjects.Login().click();
		PageObjects.Email().sendKeys(supplierEmail);
		PageObjects.Password().sendKeys(supplierPassword);
		PageObjects.Login2().click();
		
		Thread.sleep(2000);
		try {
			if (PageObjects.Profile().isDisplayed()) {
				System.out.println("The user is successfully able to login.");
				PageObjects.Profile().click();
				
				try {
					Thread.sleep(2000);
					if (PageObjects.Cart().isDisplayed()) {
						System.out.println("login done as a USER Account");
						
						Thread.sleep(2000);
						String selectedProductName = PageObjects.selectedProductNameText().getText();
						PageObjects.selectProduct().click();
						
						Thread.sleep(2000);
						PageObjects.addToCart().click();
						
						Thread.sleep(2000);
						String addedProductName = PageObjects.addedProductNameText().getText();
						
						if (addedProductName.equalsIgnoreCase(selectedProductName)) {
							System.out.println("The user is able to add item into cart successfully");
						}
						else {
							System.out.println("The user is not able to add item into cart");
						}
					}
				}
				catch (Exception e) {
					System.out.println("login done as a Supplier Account");
				}
			}
		}
		catch (Exception e) {
			System.out.println("The user is not successfully able to login.");
		}
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		PageObjects.Profile().click();
		PageObjects.Logout().click();
	}
	
	
	@Test
	public void loginAsUser() throws InterruptedException {
		
		driver.get(PageObjects.URL);
		Thread.sleep(2000);
		PageObjects.Login().click();
		PageObjects.Email().sendKeys(userEmail);
		PageObjects.Password().sendKeys(userPassword);
		PageObjects.Login2().click();
		
		Thread.sleep(2000);
		try {
			if (PageObjects.Profile().isDisplayed()) {
				System.out.println("The user is successfully able to login.");
				PageObjects.Profile().click();
				
				try {
					Thread.sleep(2000);
					if (PageObjects.Cart().isDisplayed()) {
						System.out.println("login done as a USER Account");
						
						Thread.sleep(2000);
						String selectedProductName = PageObjects.selectedProductNameText().getText();
						PageObjects.selectProduct().click();
						
						Thread.sleep(2000);
						PageObjects.addToCart().click();
						
						Thread.sleep(2000);
						String addedProductName = PageObjects.addedProductNameText().getText();
						
						if (addedProductName.equalsIgnoreCase(selectedProductName)) {
							System.out.println("The user is able to add item into cart successfully");
						}
						else {
							System.out.println("The user is not able to add item into cart");
						}
					}
				}
				catch (Exception e) {
					System.out.println("login done as a Supplier Account");
				}
			}
		}
		catch (Exception e) {
			System.out.println("The user is not successfully able to login.");
		}
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		PageObjects.Profile().click();
		PageObjects.Logout().click();
	}
	
	
	@AfterTest
	public void closeBrowser() {
//		driver.close();
	}
}



