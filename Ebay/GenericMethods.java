package Ebay;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	public static WebDriver driver;
	public static WebElement element;
	public static String PROP_KEY = "webdriver.chrome.driver";
	public static String PROP_VALUE = "./Drivers/chromedriver.exe";

	/***
	 * @Author : Gopal Bandge
	 * @Description: to open browser with desired URL
	 * @param url
	 */
	public static void openBrowser(String url) {

		System.setProperty(PROP_KEY, PROP_VALUE);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	/***
	 * @Author : Gopal Bandge
	 * @Description: to create WebElement at runtime by providing xpath
	 * @param xpath
	 */
	public static WebElement createWebElementByXpath(String xpath) {
		element = driver.findElement(By.xpath(xpath));
		return element;

	}

	/***
	 * @Author : Gopal Bandge
	 * @Description: to wait for element for given time
	 * @param element
	 */
	public static void waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/***
	 * @Author : Gopal Bandge
	 * @Description: to double click on given webElement
	 * @param element
	 */
	public static void doubleClick(WebElement element) {
		element.click();
		element.click();
	}

	/***
	 * @Author : Gopal Bandge
	 * @Description: to scroll to given webElement
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/***
	 * @Author : Gopal Bandge
	 * @Description: to click on element
	 * @param element
	 */
	public static void click(WebElement element) {
		element.click();

	}
	
	/***
	 * @Author : Gopal Bandge
	 * @Description: to set Text 
	 * @param element,text
	 */
	public static void setText(WebElement element,String text) {
		
		element.sendKeys(text+Keys.ENTER);

	}
	
	/***
	 * @Author : Gopal Bandge
	 * @Description: to get Text of Element
	 * @param element
	 */
	public static String getText(WebElement element) {
		
		return element.getText();

	}
	
	/***
	 * @Author : Gopal Bandge
	 * @Description: to select value from dropdown
	 * @param element,value
	 */
	public static void selectFromList(WebElement element,String value) {
		
		Select select=new Select(element);
		
		select.selectByVisibleText(value);
		

	}
	
	/***
	 * @Author : Gopal Bandge
	 * @Description: to close Browser
	 * 
	 */
	public static void closeBrowser() {
		
		driver.quit();
		

	}
}
