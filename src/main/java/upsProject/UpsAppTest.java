package upsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpsAppTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ups.com/lasso/login");
		driver.manage().window().maximize();
		
		//Sign Up Button Click
		WebElement signUpButton=driver.findElement(By.xpath("//*[@id=\"DOARegisterLink\"]"));
		signUpButton.click();
		
		//Sign Up Page Confirmation
		WebElement signUpPage=driver.findElement(By.xpath("//span[contains(text(),'Sign up.')]"));
		String pageText= signUpPage.getText();
		System.out.println(pageText);
		
		
		//Menubar Option "Shipping" click
		WebElement shippingMenu=driver.findElement(By.xpath("//*[@id=\"ups-menuLinks1\"]"));
		shippingMenu.click();
		
		//Shipping List option "Create A Shipment"
		WebElement shipmentOption=driver.findElement(By.cssSelector("#ups-menuPanel1 > div > div:nth-child(1) > ul > li:nth-child(1) > a"));
		shipmentOption.click();
		
		//Confirmation of Shpment Page
		WebElement shipmentPage=driver.findElement(By.xpath("//span[contains(text(),'Create a Shipment')]"));
		String createAShipment=shipmentPage.getText();
		System.out.println(createAShipment);
		
		
		//Select Country from Dropdown
		Select countryTerritory=new Select(driver.findElement(By.xpath("//select[@id='origin-cac_country']")));
		countryTerritory.selectByIndex(26);
		
		
		//Fill Out Name field
		WebElement fnameLname=driver.findElement(By.xpath("//*[@id='origin-cac_companyOrName']"));
		fnameLname.sendKeys("Mohammed Monirul Islam Himel");
		
		
		//Select Address from list
		WebElement address=driver.findElement(By.xpath("//*[@id=\"origin-cac_singleLineAddress\"]"));
		address.sendKeys("1157 Glenmore Ave,Brooklyn");
		
		//Enter Zip Code
		WebElement zipCode=driver.findElement(By.xpath("//input[@id='origin-cac_postalCode']"));
		zipCode.sendKeys("11208");
		
		//Fill Out City
		WebElement city=driver.findElement(By.xpath("//input[@id='origin-cac_city']"));
		city.sendKeys ("Brooklyn");
		
		//Select State
		Select state=new Select  (driver.findElement(By.xpath("//*[@id=\"origin-cac_state\"]")));
		state.selectByValue("NewYork");
		System.out.println(" Himel has been updated the file");
		
		
		
		Thread.sleep(2000);
		driver.close();
		
	}


}
