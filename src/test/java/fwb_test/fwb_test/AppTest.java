package fwb_test.fwb_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class AppTest
{
	@Order(1)
	@Test
	public void Simple()
	{
		System.out.println ("EJL - inside Simple test");
		
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/mac/chromedriver");
		ChromeDriver driver = new ChromeDriver();

	        driver.get("https://www.google.com");
        	WebElement p = driver.findElement(By.name("q"));
	        p.sendKeys("Selenium Java");
        	p.submit();
	        System.out.println ("EJL - title = " + driver.getTitle());
	}
}
