package Week4Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertBasics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Alert.html");
		//Click the button to display a alert box.
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("The text in the alert1 is :" + text);
		alert.accept();
		//Click the button to display a confirm box.
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert2.getText();
		System.out.println("The text in the alert2 is :" + text2);
		alert2.accept();
		
		//Click the button to display a prompt box.
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		System.out.println("The text in the alert3 is :" + text3);
		alert3.sendKeys("TestLeaf");
		alert3.accept();
		
		//Click the button to learn line-breaks in an alert.
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert alert4 = driver.switchTo().alert();
		String text4 = alert4.getText();
		System.out.println("The text in the alert4 is :" + text4);
		alert4.accept();
		
		//Click the below button and click OK.
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		String text5 = driver.findElement(By.xpath("//div[text()='Happy Coding!']")).getText();
		System.out.println("The text in the alert5 is " + text5);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		
		
		
	}

}
