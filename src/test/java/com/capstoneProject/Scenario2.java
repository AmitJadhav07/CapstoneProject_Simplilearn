package com.capstoneProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class Scenario2 {

	String UserEmail = "sample@medicare.com";
	String UserPassword = "123456";

	@BeforeTest
	public void startBrowser() {
		PageObjects.driver.manage().window().maximize();
		PageObjects.spark.config().setTheme(Theme.DARK);
		PageObjects.extent.attachReporter(PageObjects.spark);
		PageObjects.logger = PageObjects.extent.createTest("loginAsUser");
	}

	@Test
	public void loginAsUser() throws InterruptedException, IOException {

		PageObjects.driver.get(PageObjects.URL);
		PageObjects.logger.info("Website launched successfully :- " + PageObjects.driver.getCurrentUrl());
		TakeScreenshot.getScreenshot(PageObjects.driver);
		Thread.sleep(2000);
		PageObjects.Login().click();
		PageObjects.Email().sendKeys(UserEmail);
		PageObjects.Password().sendKeys(UserPassword);
		PageObjects.Login2().click();

		Thread.sleep(2000);
		try {
			if (PageObjects.Profile().isDisplayed()) {
				System.out.println("The user is successfully able to login.");
				PageObjects.logger.pass("The user is successfully able to login.");
				TakeScreenshot.getScreenshot(PageObjects.driver);
				PageObjects.Profile().click();

				try {
					Thread.sleep(2000);
					if (PageObjects.Cart().isDisplayed()) {
						System.out.println("login done as a USER Account");
						PageObjects.logger.info("login done as a USER Account");
						TakeScreenshot.getScreenshot(PageObjects.driver);

						Thread.sleep(2000);
						String selectedProductName = PageObjects.selectedProductNameText().getText();
						PageObjects.selectProduct().click();

						Thread.sleep(2000);
						PageObjects.addToCart().click();

						Thread.sleep(2000);
						String addedProductName = PageObjects.addedProductNameText().getText();

						if (addedProductName.equalsIgnoreCase(selectedProductName)) {
							System.out.println("The user is able to add item into cart successfully");
							PageObjects.logger.pass("The user is able to add item into cart successfully");
							TakeScreenshot.getScreenshot(PageObjects.driver);
						} else {
							System.out.println("The user is not able to add item into cart");
							PageObjects.logger.fail("The user is not able to add item into cart");
							TakeScreenshot.getScreenshot(PageObjects.driver);
						}
					}
				} catch (Exception e) {
					System.out.println("login done as a Supplier Account");
					PageObjects.logger.info("login done as a Supplier Account");
					TakeScreenshot.getScreenshot(PageObjects.driver);
				}
			}
		} catch (Exception e) {
			System.out.println("The user is not successfully able to login.");
			PageObjects.logger.fail("The user is not successfully able to login.");
			TakeScreenshot.getScreenshot(PageObjects.driver);
		}

		PageObjects.driver.navigate().refresh();
		Thread.sleep(2000);
		PageObjects.Profile().click();
		PageObjects.Logout().click();
		PageObjects.logger.info("Logout Successfully");
	}

	@AfterTest
	public void closeBrowser() {
		PageObjects.driver.close();
		PageObjects.logger.info("Browser closed");
		PageObjects.extent.flush();
	}

}
