package Week4Day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev113850.service-now.com/");

		// Switch to Frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Ramya*123");
		driver.findElement(By.id("sysverb_login")).click();

		// Search “incident “ Filter Navigator
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		// driver.findElement(By.xpath("//button[@class='btn btn-icon
		// icon-cross']")).click();
		// Click “All”

		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();

		// Click New button
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@class='selected_action action_context btn btn-primary']")).click();

		// Select a value for Caller and Enter value for short_description

		// WebElement frame = driver.findElement(By.id("gsft_main"));
		// driver.switchTo().frame(frame);
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		// driver.findElement(By.id("sysverb_new")).click();

		// Window Handler
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandlesSet);
		String newWindow = list.get(1);
		driver.switchTo().window(newWindow);

		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(list.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("incident.short_description")).sendKeys("short description");
		// Read the incident number and save it a variable
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNumber);
		// Click on Submit button
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

		// Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(incidentNumber, Keys.ENTER);
		 //take snapshot of the created incident.
		File screenshot= driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/servicenow.jpg");
		FileUtils.copyFile(screenshot, image);
		
		// Verify the incident is created successful  
	String incident = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println(incident);
		if (incidentNumber.equals(incident))
			System.out.println("Incident created successfully");
		else
			System.out.println("Incident not created successfully");

	}

}
