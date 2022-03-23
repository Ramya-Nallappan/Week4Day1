package Week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling_MergeContact {
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@src= '/images/fieldlookup.gif'])[1]")).click();
		//Window Handler
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<String>(windowHandlesSet);
		String newWindow = windowHandleList.get(1);
		driver.switchTo().window(newWindow);
		System.out.println(driver.getCurrentUrl());
		 //Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		// to go back to the base window
		driver.switchTo().window(windowHandleList.get(0));
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@src= '/images/fieldlookup.gif'])[2]")).click();
		//Window Handler
		Set<String> windowHandlesSet2 = driver.getWindowHandles();
		List<String> windowHandlesList2 = new ArrayList<String> ();
		windowHandlesList2.addAll(windowHandlesSet2);
		String newWindow2 = windowHandlesList2.get(1);
		driver.switchTo().window(newWindow2);
		System.out.println(driver.getCurrentUrl());
		 //Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		// to go back to the base window
		driver.switchTo().window(windowHandleList.get(0));
		 //Click on Merge button using Xpath Locator
		 driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		 //focus on Alert
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("The text in the alert is : " + text);
		 //Accept the Alert
		 alert.accept();
		 //Verify the title of the page
		 String title = driver.getTitle();
		 System.out.println("The title of the page is : " + title);
	}
	
}




