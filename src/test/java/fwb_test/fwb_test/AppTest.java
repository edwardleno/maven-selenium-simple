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

@TestMethodOrder(OrderAnnotation.class)
public class AppTest
{
	@Order(1)
	@Test
	public void Simple()
	{
		System.out.println ("EJL - inside Simple test");
		
		String downloadFilePath = System.getProperty("user.dir") + "/target";
		HashMap<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("download.default_directory", downloadFilePath);
		chromePrefs.put("download.prompt_for_download", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--no-sandbox");

		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/linux/chromedriver");
		ChromeDriver driver = new ChromeDriver();

	        driver.get("https://www.google.com");
        	WebElement p = driver.findElement(By.name("q"));
	        p.sendKeys("Selenium Java");
        	p.submit();
	        System.out.println ("EJL - title = " + driver.getTitle());
	}
}
