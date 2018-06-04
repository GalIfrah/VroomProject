package VroomAutomation.VroomProject;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import VroomAutomation.VroomProject.GenericPageObject;
import VroomAutomation.VroomProject.Locators;

public class PageObjects {
	public static class vroomHomePage extends GenericPageObject {

		private static final String CONTACT = "//div[@class = 'subsection-item']/a[@href = '/contact']";
		private static final String CALL_OR_TEXT = "//div[@class = 'subsection-item']/a[@href = 'tel:1-(855)-524-1300']";
		private static final String FAQ = "//div[@class = 'subsection-item']/a[@href = 'https://vroom.zendesk.com/hc/en-us'])";
		private static final String CONTACT_DROPDOWN = "//div[@class = 'dropdown fullwidth']/span[@class = 'dropdown-heading']/a";
		private static final String ABOUT_DROPDOWN = "//div[@class = 'dropdown']/span[@class = 'dropdown-heading']/a";
		private static final String SEARCH_BUTTON = "//button[@class = 'search-button']";
		private static final String SUT = "https://www.vroom.com/";
		private static final String SEARCH_INPUT = "hero-search-input";
		private static final String BUY_BUTTON = "//*[@id='container']/header/div/nav/ul/li[1]/a";
		private static final String SELL_BUTTON = "//li/a[@href = '/sell']";
		private static final String FINANCE_BUTTON = "//li/a[@href = '/finance']";
		private static final String FORTUNE_ACTIVE_TEXT = "//div[@class = 'fortune active']";
		private static final String FORTUNE_ACTIVE_SPAN = "//*[@id='container-page']/div/span/section[2]/div/div/div[2]/ul/li[4]/span";

		private static final String ABOUT_US = "//ul/li/a[@href = '/about']";
		private static final String VROOM_COVERAGE = "//ul/li/a[@href = '/vroomcoverage']";

		public static void openHomePage() {
			webDriver.open(SUT);
			webDriver.maximizeWindow();
		}

		public static void textToSearch(String text) {
			webDriver.getElementBy(Locators.ID, SEARCH_INPUT).sendKeys(text);

		}

		public static void clickSearchButton() {
			webDriver.getElementBy(Locators.XPATH, SEARCH_BUTTON).click();

		}

		// the next 10 methods refers to the header

		public static void clickOnBuyButton() {
			webDriver.getElementBy(Locators.XPATH, BUY_BUTTON).click();
		}

		public static void clickOnSellButton() {
			webDriver.getElementBy(Locators.XPATH, SELL_BUTTON).click();
		}

		public static void clickOnFinanceButton() {
			webDriver.getElementBy(Locators.XPATH, FINANCE_BUTTON).click();
		}

		public static void hoverAboutDropDown() {
			webDriver.hover(ABOUT_DROPDOWN);
		}

		public static void clickOnAboutUs() {
			webDriver.hoverAndClick(ABOUT_DROPDOWN, ABOUT_US);
		}

		public static void clickOnVroomCoverage() {
			webDriver.hoverAndClick(ABOUT_DROPDOWN, VROOM_COVERAGE);
		}

		public static void hoverContactDropDown() {
			webDriver.hover(CONTACT_DROPDOWN);
		}

		public static void clickOnfAQ() {
			webDriver.hoverAndClick(ABOUT_DROPDOWN, FAQ);
		}

		public static void clickOnCallOrText() {
			webDriver.hoverAndClick(ABOUT_DROPDOWN, CALL_OR_TEXT);
		}

		public static void clickOnContact() {
			webDriver.hoverAndClick(ABOUT_DROPDOWN, CONTACT);
		}

		public static void clickOnFortuneButton() {
			webDriver.getElementBy(Locators.XPATH, FORTUNE_ACTIVE_SPAN).click();
		}

		public static String getFortuneText() {
			String fortuneText = webDriver.getElementBy(Locators.XPATH, FORTUNE_ACTIVE_TEXT).getText();
			return fortuneText;
		}

	}

	public static class BuyPage extends GenericPageObject {

		private static final String ALFA_ROMEO_SORT_BY_HIGHEST = "//ul[@class = 'list-block']//li/a[@href ='/catalog/all-years/alfa romeo/?sort=price_desc']";
		private static final String FIRST_CAR_PRICE = "//*[@id='cars-section']/ul/li[1]/a/article/div[2]/div[2]";
		private static final String CAR_PRICE = "//div[@class = 'price']";
		private static final String ALL_CARS_OBJECTS = "//ul[@class = 'car-list list-unstyled']/li";
		private static final String SUT = "https://www.vroom.com/catalog";
		private static final String RESULTS_NUMBER = "//div[@class='middle']/h3";
		private static final String SORT_OPTION_NEWEST_MODEL = "//ul[@class = 'list-block']//li/a[@href ='/catalog/all-years/all-makes/?sort=year']";
		private static final String SORT_OPTION_LOWEST_PRICE = "//ul[@class = 'list-block']//li/a[@href ='/catalog/all-years/all-makes/?sort=price']";
		private static final String SORT_OPTION_HIGHEST_PRICE = "//ul[@class = 'list-block']//li/a[@href ='/catalog/all-years/all-makes/?sort=price_desc']";
		private static final String SORT_OPTION_LOWEST_MILES = "//ul[@class = 'list-block']//li/a[@href ='/catalog/all-years/all-makes/?sort=miles']";
		private static final String SORT_DROPDOWN = "//div[@class = 'catalog-sort-dropdown']";

		public static void openCatalogPage() {

			webDriver.open(SUT);

			webDriver.maximizeWindow();
		}

		public static void hoverSortButton() {
			webDriver.hover(SORT_DROPDOWN);

		}

		// the 4 next methods is for sorting options
		public static void sortByNewestModel() {
			webDriver.hoverAndClick(SORT_DROPDOWN, SORT_OPTION_NEWEST_MODEL);
		}

		public static void sortByLowestPrice() {
			webDriver.hoverAndClick(SORT_DROPDOWN, SORT_OPTION_LOWEST_PRICE);
		}

		public static void sortByHighestPrice() throws InterruptedException {

			webDriver.hoverAndClick(SORT_DROPDOWN, SORT_OPTION_HIGHEST_PRICE);

			Thread.sleep(3000);
		}

		public static void sortByLowestMiles() {

			webDriver.hoverAndClick(SORT_DROPDOWN, SORT_OPTION_LOWEST_MILES);
		}

		public static List<WebElement> getAllCars() {

			List<WebElement> carList = webDriver.getElementsByXpath(ALL_CARS_OBJECTS);

			return carList;

		}

		public static List<WebElement> getAllCarsPrices() {

			List<WebElement> carPricesList = webDriver.getElementsByXpath(CAR_PRICE);

			return carPricesList;

		}

		public static String getNumOfResultsAsString() {

			String resultAsText = webDriver.getElementBy(Locators.XPATH, RESULTS_NUMBER).getText();

			return resultAsText;
		}

		// this method return the numeric value out of the "result number"
		// String
		public static int getNumOfResultsAsInt() {

			String resultAsText = webDriver.getElementBy(Locators.XPATH, RESULTS_NUMBER).getText();

			System.out.println(resultAsText);

			String digits = resultAsText.replaceAll("[^0-9.]", "");

			int numOfResults = Integer.parseInt(digits);

			return numOfResults;

		}

		// sort by any option and get list of all elements

		public static int scrollDownToButtomAndCountTheActualResults(int numOfResults) throws InterruptedException {

			List<WebElement> carList = webDriver.getElementsByXpath(ALL_CARS_OBJECTS);

			int carsOnPage = carList.size();

			while (carsOnPage < numOfResults) {

				webDriver.scrollDown();

				Thread.sleep(3000);

				carList = webDriver.getElementsByXpath(ALL_CARS_OBJECTS);

				carsOnPage = carList.size();
			}

			// check for the developer

			System.out.println("the list size with the advertize is: " + carList.size());

			return carsOnPage - 1;

		}

		// get first item price as Integer

		public static int getFirstItemPrice() {

			String priceAsText = webDriver.getElementBy(Locators.XPATH, FIRST_CAR_PRICE).getText();

			String digits = priceAsText.replaceAll("[^0-9.]", "");

			int priceAsNumber = Integer.parseInt(digits);

			return priceAsNumber;
		}

		
		// check what is the most expensive car from the given results and get
		// it

		public static int getTheHighestPriceFromTheResults() {

			List<WebElement> carPrices = webDriver.getElementsByXpath(CAR_PRICE);

			System.out.println(carPrices.size());

			String[] CarPricesAsString = new String[carPrices.size()];

			int[] carPricesAsNum = new int[carPrices.size()];

			for (int i = 0; i < carPrices.size(); i++) {

				CarPricesAsString[i] = carPrices.get(i).getText();

				String digits = CarPricesAsString[i].replaceAll("[^0-9.]", "");

				carPricesAsNum[i] = Integer.parseInt(digits);

			}
			// for checking....
			
			// System.out.println(Arrays.toString(CarPricesAsString));
			// System.out.println(Arrays.toString(carPricesAsNum));

			// for getting the higestPrice

			int highestPrice = Arrays.stream(carPricesAsNum).max().getAsInt();

			return highestPrice;

		}

		public static void SortForHigestPriceAlfa() throws InterruptedException {
			
			webDriver.hoverAndClick(SORT_DROPDOWN, ALFA_ROMEO_SORT_BY_HIGHEST);
			
			webDriver.waitForLoading();
		}

		public static void clickOnAlfaRomeoOption() throws InterruptedException {

			webDriver.getElementBy(Locators.XPATH, "//a[contains(text(), 'Alfa Romeo')]").click();

			webDriver.waitForLoading();

		}

		
		public static void clickOnAllAlfaRomeosOption() throws InterruptedException {

			webDriver.getElementBy(Locators.XPATH, "//a[@href = '/catalog/all-years/alfa romeo/']").click();

			webDriver.waitForLoading();

		}
	}

}
