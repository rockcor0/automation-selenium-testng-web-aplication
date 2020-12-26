/**
 * 
 */
package com.rockcor;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author ricardodelgadocarreno
 *
 */
public class TestNGSample {
	
	private final static String URL = "http://automationpractice.com/index.php";
	private final static By SEARCH_BOX = By.id("search_query_top");
	private final static By SEARCH_RESULTS = By.xpath("//span[@class='heading-counter']");
	private final static By SEARCH_SUBMIT = By.name("submit_search");
	private final static String RESULTS = "1 result has been found.";
	private static final CharSequence SEARCH_TEXT = "blouse";
	
	private WebDriver driver;
	
	/**
	 * Se ejecuta antes de ejecutar el primer método de prueba dentro de la clase actual
	 */
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test
	public void searchBlouses() {
		WebElement searchBox = driver.findElement(SEARCH_BOX);
		searchBox.clear();
		searchBox.sendKeys(SEARCH_TEXT);
		searchBox.submit();
		//driver.findElement(SEARCH_SUBMIT).click();
		
		//for implicit wait
		//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		//For explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.presenceOfElementLocated(SEARCH_RESULTS));
		
		System.out.println(driver.findElement(SEARCH_RESULTS));
		
		assertTrue(driver.findElement(SEARCH_RESULTS).isDisplayed(), "The result number is not present");
	}
	
	/**
	 * Se ejecuta después de ejecutar todos los métodos de prueba dentro de la clase actual
	 */
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
	
	
	/**
	 * Se ejecuta antes de que se ejecuten todos los test de la suite
	 */
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
		
	}
	
	/**
	 * Se ejecuta después de que se ejecuten todos los test de la suite
	 */
	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");
		
	}
	
	/**
	 * Se ejecuta antes de ejecutr cualquier método de prueba que pertenezca a las clases dentro de
	 * la etiqueta test
	 */
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	/**
	 * Se ejecuta después de ejecutar cualquier método de prueba que pertenezca a las clases dentro 
	 * de la etiqueta test
	 */
	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
	}
	
	/**
	 * Se ejecuta antes de cada método test
	 */
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	/**
	 * Se ejecuta después de cada método test
	 */
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	
}
