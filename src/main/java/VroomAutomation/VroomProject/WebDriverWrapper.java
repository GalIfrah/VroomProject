package VroomAutomation.VroomProject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWrapper 
{
RemoteWebDriver remoteWebDriver;

	
	// initialize the connection to remote machine Grid

	public void init(String remoteUrl) throws MalformedURLException {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

		remoteWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	// initialize the connection on local machine as Grid
	public void init2() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		remoteWebDriver = new RemoteWebDriver(capabilities);

	}
//stam test 2 
	
	// open browser
	public void open(String url) {
		remoteWebDriver.get(url);
	}

	// close current browser
	public void close() {
		remoteWebDriver.close();
	}

	
	// close all open sessions
	public void closeallBrowsers() {
		remoteWebDriver.quit();
	}

	
	// find element according to given locator type (Enum) + actual locator
	public WebElement getElementBy(Locators locator, String value) {
	
		WebElement element = null;
		
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 10);

		switch (locator) {
		case XPATH:
			try {
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));

			} catch (NullPointerException e) {
				System.out.println("return null");
			}
			break;
		
		case CSS:
			try {
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));

			} catch (NullPointerException e) {
				System.out.println("return null");
			}
			break;
		
		case NAME:
			try {
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.name(value)));

			} catch (NullPointerException e) {
				System.out.println("return null");
			}
			break;
		
		case CLASSNAME:
			try {
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));

			} catch (NullPointerException e) {
				System.out.println("return null");
			}
			break;

		case ID:
			try {
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));

			} catch (NullPointerException e) {
				System.out.println("return null");
			}
			break;
		
		default:
			System.out.println("no such locator...please choose from 'Locators' Enum");
			break;

		}

		return element;

	}

	
	// find list of elements
	public List<WebElement> getElementsByXpath(String xpath) {
		
		WebDriverWait wait = new WebDriverWait(remoteWebDriver, 10, 1000);

		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	
	public void hover(String value) {
		
		Actions action = new Actions(remoteWebDriver);
		
		WebElement we = remoteWebDriver.findElement(By.xpath(value));
		
		action.moveToElement(we).build().perform();
	}

	
	public void hoverAndClick(String hoverValue, String clickValue) {
		
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 10);

		Actions action = new Actions(remoteWebDriver);

		WebElement elementToHover = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(hoverValue)));
		
		WebElement elementToClick = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickValue)));

		action.moveToElement(elementToHover).click(elementToClick).build().perform();

	}

	
	public void maximizeWindow() {
		remoteWebDriver.manage().window().maximize();
	}

	
	public void TakeScreenshot(String fileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) remoteWebDriver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("./ScreenShots/" + fileName + ".png"));
	}

	
	public void scrollToElement(String value) {
	
		WebDriverWait driverWait = new WebDriverWait(remoteWebDriver, 10, 1000);
		
		WebElement element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
		
		JavascriptExecutor js = ((JavascriptExecutor) remoteWebDriver);

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	public void scrollDown() {

		JavascriptExecutor js = ((JavascriptExecutor) remoteWebDriver);
		
		js.executeScript("scrollBy(0,50000)");
	}

	public void waitForLoading() throws InterruptedException{
		Thread.sleep(2000);
	}
	   
}
