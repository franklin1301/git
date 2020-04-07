package com.testNGtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datadrivenpractice.xls_reader;

public class NewTest {
	String sheetName = "login";
	WebDriver driver;
	xls_reader reader = new xls_reader("C:\\exceldata\\ap.xlsx");

	@Test(dataProvider = "dp")
	public void f(String firstname, String lastname, String password, String adress, String adress2, String city,
			String pincode, String mobnum) {

		driver.findElement(By.xpath("//*[contains(@title,'Log in')]")).click();

		driver.findElement(By.id("email_create")).sendKeys("frankman@gmail.com");

		driver.findElement(By.xpath("//*[contains(text(),'Create')]//following::i")).click();

		WebElement fn = driver.findElement(By.id("customer_firstname"));
		fn.clear();
		fn.sendKeys(firstname);

		WebElement ln = driver.findElement(By.id("customer_lastname"));
		ln.clear();
		ln.sendKeys(lastname);

		WebElement pass = driver.findElement(By.id("passwd"));
		pass.clear();
		pass.sendKeys(password);

		WebElement adresss = driver.findElement(By.id("address1"));
		adresss.clear();
		adresss.sendKeys(adress);

		WebElement ad2 = driver.findElement(By.id("address2"));
		ad2.clear();
		ad2.sendKeys(adress2);

		WebElement cit = driver.findElement(By.id("city"));
		cit.clear();
		cit.sendKeys(city);

		WebElement pincod = driver.findElement(By.id("postcode"));
		pincod.clear();
		pincod.sendKeys(pincode);

		WebElement mob = driver.findElement(By.id("phone_mobile"));
		mob.clear();
		mob.sendKeys(mobnum);

	}


	@BeforeMethod
	public void beforeMethod() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\eclipse\\Flipkart\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@DataProvider
	public Iterator<Object[]> dp() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		

		int rowCount = reader.getRowCount("login");

		for (int i = 2; i <= rowCount; i++) {

			String firstname = reader.getCellData(sheetName, "firstname", i);
			String lastname = reader.getCellData(sheetName, "lastname", i);
			String password = reader.getCellData(sheetName, "password", i);
			String adress = reader.getCellData(sheetName, "adress", i);
			String adress2 = reader.getCellData(sheetName, "adress2", i);
			String city = reader.getCellData(sheetName, "city", i);
			String pincode = reader.getCellData(sheetName, "pincode", i);
			String mobnum = reader.getCellData(sheetName, "mobilenumber", i);

			Object ob[] = { firstname, lastname, password, adress, adress2, city, pincode, mobnum };
			data.add(ob);
		}
		return data.iterator();

	}

}
