package com.datadrivenpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Datadrivenreading {
	public static void main(String[] args) throws Exception {
				
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\eclipse\\Flipkart\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.xpath("//*[contains(@title,'Log in')]")).click();

		driver.findElement(By.id("email_create")).sendKeys("frankman@gmail.com");

		driver.findElement(By.xpath("//*[contains(text(),'Create')]//following::i")).click();

		xls_reader reader = new xls_reader("C:\\exceldata\\ap.xlsx");

		int rowCount = reader.getRowCount("login");
		int columnCount = reader.getColumnCount("login");
		String[] s=new String[columnCount]; 


		String sheetName = "login";
     
		reader.addColumn(sheetName, "status");
		
		if (!reader.isSheetExist("data")) {
			reader.addSheet("data");
		}
		

		for (int i = 2; i <= rowCount; i++) {

			String firstname = reader.getCellData(sheetName, "firstname", i);
			String lastname = reader.getCellData(sheetName, "lastname", i);
			String password = reader.getCellData(sheetName, "password", i);
			String adress = reader.getCellData(sheetName, "adress", i);
			String adress2 = reader.getCellData(sheetName, "adress2", i);
			String city = reader.getCellData(sheetName, "city", i);
			String pincode = reader.getCellData(sheetName, "pincode", i);
			String mobnum = reader.getCellData(sheetName, "mobilenumber", i);

			/*
			 * String mr ="(//*[@type='radio'])[1]"; String mrs="(//*[@type='radio'])[2]";
			 * 
			 * driver.findElement(By.xpath(mr)).click();
			 */

			WebElement fn = driver.findElement(By.id("customer_firstname"));
			fn.clear();
			fn.sendKeys(firstname);
			s[1] = fn.getAttribute("value");

			WebElement ln = driver.findElement(By.id("customer_lastname"));
			ln.clear();
			ln.sendKeys(lastname);
			s[2] = ln.getAttribute("value");

			WebElement pass = driver.findElement(By.id("passwd"));
			pass.clear();
			pass.sendKeys(password);
			s[3] = pass.getAttribute("value");

			WebElement adresss = driver.findElement(By.id("address1"));
			adresss.clear();
			adresss.sendKeys(adress);
			s[4]=adresss.getAttribute("value");

			WebElement ad2 = driver.findElement(By.id("address2"));
			ad2.clear();
			ad2.sendKeys(adress2);
			s[5]=ad2.getAttribute("value");

			WebElement cit = driver.findElement(By.id("city"));
			cit.clear();
			cit.sendKeys(city);
			s[6]=cit.getAttribute("value");

			WebElement pincod = driver.findElement(By.id("postcode"));
			pincod.clear();
			pincod.sendKeys(pincode);
			s[7]=pincod.getAttribute("value");

			WebElement mob = driver.findElement(By.id("phone_mobile"));
			mob.clear();
			mob.sendKeys(mobnum);
			s[8]=mob.getAttribute("value");
			
			reader.setCellData(sheetName, "status", i, "pass");
		
		}
		
			Thread.sleep(15000);
		
		driver.quit();

	}
}