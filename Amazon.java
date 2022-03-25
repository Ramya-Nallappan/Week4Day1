package Week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    //search as oneplus 9 pro 
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro" ,Keys.ENTER);
   
    //Get the price of the first product
    String price =driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
    System.out.println("The price of the first product is " +price);
    Thread.sleep(1500);
    //Print the number of customer ratings for the first displayed product
    String noOfCustomer =driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
    System.out.println("The number of customer ratings for first product is " +noOfCustomer);
    
    //click on the stars 
    WebElement element = driver.findElement(By.xpath("(//a[@role='button']//i)[2]"));
    Actions builder = new Actions(driver);
    builder.click(element).perform();

 
    //Get the percentage of ratings for the 5 star.
    //String rating =driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]")).getText();
    String rating =driver.findElement(By.xpath("((//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1])/span")).getText();
    //String ratingPercent = driver.findElement(By.xpath("(//a[@title='5 stars represent 65% of rating'])[3]")).getText();
    //System.out.println("The customer ratings for first product is :" +ratingPercent);
    String fiveStar = driver.findElement(By.xpath("(//span[@class= 'a-size-base']/a)[2]")).getText();
    System.out.println("The 5star ratings for first product is :" + fiveStar);
    //Click the first text link of the first image
    driver.findElement(By.xpath("(//span[@class= 'a-size-medium a-color-base a-text-normal'])[1]")).click();
   //switch to new window
    Set<String> windowHandlesSet = driver.getWindowHandles();
    List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
    String newWindow = windowHandlesList.get(1);
    driver.switchTo().window(newWindow);
    
    //Click 'Add to Cart' button
    driver.findElement(By.id("add-to-cart-button")).click();
    //Get the cart subtotal and verify if it is correct.
  Thread.sleep(1500);
String subTotal = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]")).getText();
System.out.println("The Subtotal is : " +subTotal);
/*
String replaceAll = subTotal.replaceAll("['a-zA-Z?₹,']", "");
System.out.println("The Subtotal is : " +replaceAll);

if (price.equals(replaceAll))

	System.out.println("The price and cardtotal are same");
else
	System.out.println("The price and cardtotal are different");
	*/
}

}
