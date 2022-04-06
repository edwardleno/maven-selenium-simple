package fwb_test.fwb_test;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

@TestMethodOrder(OrderAnnotation.class)
public class AppTest
{
	RemoteWebDriver driver;
	
	@Order(1)
	@Test
	public void Simple()
	{
		System.out.println ("EJL - inside Simple test");
/*		
		String downloadFilePath = System.getProperty("user.dir") + "/target";
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("download.default_directory", downloadFilePath);
		chromePrefs.put("download.prompt_for_download", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--no-sandbox");
		options.setHeadless(true);

		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/linux/chromedriver");
		ChromeDriver driver = new ChromeDriver();

	        driver.get("https://www.google.com");
        	WebElement p = driver.findElement(By.name("q"));
	        p.sendKeys("Selenium Java");
        	p.submit();
	        System.out.println ("EJL - title = " + driver.getTitle());
*/
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/linux/chromedriver");

		try {
//			driver = new RemoteWebDriver(new URL("http://192.168.1.183:4444/wd/hub"), options);  // .183 for macmini
			driver = new RemoteWebDriver(new URL("http://192.168.1.185:4444/wd/hub"), options);  // .185 for bah
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
		pause (10000);
		driver.navigate().to("https://www.youtube.com/houssemdellai");
		pause (10000);
		System.out.println("EJL");

	}
	
	public void pause(long millis)
	{
		try
		{
			Thread.sleep(millis);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
