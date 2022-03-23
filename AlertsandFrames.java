package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		// To switch to the frame
		driver.switchTo().frame("iframeResult");
		// click on Try it
		WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
		tryit.click();
		// switch to Alert and click OK
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// Text verification after selecting OK in the alert box
		WebElement text = driver.findElement(By.id("demo"));
		System.out.println("The text for OK is :" + text.getText());
		// click on Try it
		tryit.click();
		// switch to Alert and click CANCEL
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		// Text verification after selecting OK in the alert box
		WebElement text2 = driver.findElement(By.id("demo"));
		System.out.println("The text for Cancel is :" + text2.getText());

	}

}
