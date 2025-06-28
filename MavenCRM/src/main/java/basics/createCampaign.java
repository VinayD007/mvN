package basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class createCampaign {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://192.168.244.128:8080/crm/HomePage.do");
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
	//	Thread.sleep(3000);
		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//a[text()='New Campaign']")).click();
		driver.findElement(By.xpath("//input[@name='property(Campaign Name)']")).sendKeys("Tony");
		WebElement typeDropdown = driver.findElement(By.xpath("//select[@name='property(Type)']"));
		Select s = new Select(typeDropdown);
		s.selectByValue("Conference");
		WebElement statusDropdown = driver.findElement(By.xpath("//select[@name='property(Status)']"));
		Select s1 = new Select(statusDropdown);
		s1.selectByValue("Active");
		String st = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@name='property(Start Date)']/..//img")).click();
		Set<String> winH = driver.getWindowHandles();
		for (String str : winH) {
			driver.switchTo().window(str);

		}
		driver.findElement(By.xpath("//a[text()='11']")).click();
		driver.switchTo().window(st);
		driver.findElement(By.xpath("//textarea[@name='property(Description)']")).sendKeys("done");
	}
}
