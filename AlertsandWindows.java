package Week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		// Click on FLIGHTS link
		driver.findElement(By.xpath("//span[@class='allcircle circleone']")).click();

		// Go to the Flights tab
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		String newWindow = windowHandlesList.get(1);
		driver.switchTo().window(newWindow);
		// Notification
		driver.findElement(By.xpath("//button[text()='Allow']")).click();

		// Print the customer care email id
		String email = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getAttribute("href");
		System.out.println("The email address is :" + email);
		// Close the First tab(Train ticket booking) alone

		driver.switchTo().window(windowHandlesList.get(0));
		driver.close();
	}

}
