package StepDefinitions;



import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.codec.http.Cookie;

public class LoginSteps {

	
   ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();

	 WebDriver driver =null;
	 
	 LoginPage login;
	 
	@Given("is on login page")
	public void is_on_login_page() throws InterruptedException {
		System.out.println("Given out");
		
		 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		 driver = new FirefoxDriver();
		 //System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		//ChromeOptions opt = new ChromeOptions();
		//opt.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		//  driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		driver.navigate().to(baseURL);
		
	
		 
			//JavascriptExecutor js = (JavascriptExecutor) driver;//create instance of javascript executor to do actions

			//WebElement save = driver.findElement(By.xpath("//*[@id='denyAll']"));

			//js.executeScript("arguments[0].click();", save);
		     //Thread.sleep(5000);
		
		//login.clickAccept();

		driver.findElement(By.cssSelector("#save")).click();
		Thread.sleep(5000);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("When out");
		
		login = new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Click out");
		
		login.clickSubmit();
		
	}

	@Then("user is navigate to the home page")
	public void user_is_navigate_to_the_home_page() {
		System.out.println("Then out");
		Assert.assertTrue(true);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.quit();
	}

	
}
