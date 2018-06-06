package VroomAutomation.VroomProject;

import org.junit.Assert;

import org.junit.Ignore;

import org.junit.Test;

import VroomAutomation.VroomProject.Basic;

import VroomAutomation.VroomProject.Locators;

import VroomAutomation.VroomProject.TestParams;

import VroomAutomation.VroomProject.PageObjects.BuyPage;

import VroomAutomation.VroomProject.PageObjects.vroomHomePage;

public class HomePageTests extends Basic {

	@TestParams(testDescription = "search", testTimeout = 600)

	@Test

	public void SearchTest() {

		vroomHomePage.openHomePage();

		vroomHomePage.textToSearch("volvo");

		vroomHomePage.clickSearchButton();

		Assert.assertEquals("Volvo",

				webDriver.getElementBy(Locators.XPATH, "//a[@class = 'active-filters-section']").getText());
		webDriver.close();

	}

	@Ignore

	@Test

	public void highestPrice() throws InterruptedException {

		vroomHomePage.openHomePage();

		vroomHomePage.clickOnBuyButton();

		BuyPage.sortByHighestPrice();
		webDriver.close();

	}

	@Ignore

	@Test

	public void clickOnFortune() {

		vroomHomePage.openHomePage();

		vroomHomePage.clickOnFortuneButton();

		String fortuneText = vroomHomePage.getFortuneText();

		Assert.assertEquals(

				"\"Vroom wants to make buying or selling a used car as quick and painless as ordering an Uber.\"",

				fortuneText);

		System.out.println(fortuneText);
		webDriver.close();
	}

	@Test

	public void StamTest() {

		System.out.println("great!!!");
	}
}
