package Week4Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		// Switch to frame1
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Nested Frame");
		// Switch to frame3 ( Frame3 is within Frame1)
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		// Switch to the main page
		driver.switchTo().defaultContent();
		// Switch to Frame2
		driver.switchTo().frame("frame2");
		// dropdown selection
		WebElement element = driver.findElement(By.id("animals"));
		Select dropdown = new Select(element);
		dropdown.selectByValue("babycat");
		// Switch to the main page
		driver.switchTo().defaultContent();

	}

}
