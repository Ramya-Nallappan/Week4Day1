package Week4Day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FunwithFrames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leafground.com/pages/frame.html");
		// Frame
		WebElement frame1 = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		driver.switchTo().defaultContent();
		// nested frame
		WebElement parentFrame = driver.findElement(By.xpath("(//div[@id='wrapframe'])[2]/iframe"));
		driver.switchTo().frame(parentFrame);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		driver.switchTo().defaultContent();
		// Find total number of iframes.
		List<WebElement> outerFrame = driver.findElements(By.tagName("iframe"));
		System.out.println("The number of outer frames :" + outerFrame.size());

		int count = 0;
		count = count + outerFrame.size();
		for (int i = 0; i < outerFrame.size(); i++)

		{
			driver.switchTo().frame(i);
			List<WebElement> innerFrame = driver.findElements(By.tagName("iframe"));
			count = count + innerFrame.size();
			driver.switchTo().defaultContent();
		}
		System.out.println("The total number of Frames: " + count);
	}

}
