package tcmdb_Scripts;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser_lunch {

	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
      	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
      	driver = new ChromeDriver();
      	driver.get("http://www.tcm.com/tcmdb/");
      	driver.manage().window().maximize();

      	verify_Title();
      	verify_Overview();
      	verify_Actors_Name();
      	verify_Release_Date();
      	driver.quit();
      	
	}
    
	public static void verify_Title()
	{
		try{
		final String movie_Title="To Have and Have Not (1944)";
		String title=driver.findElement(By.xpath("//*[@id='movieSearchList']/div/a[1]")).getText();
		highLightElement(driver.findElement(By.xpath("//*[@id='movieSearchList']/div/a[1]")));
		if(title.equals(movie_Title))
		{
		driver.findElement(By.xpath("//*[@id='movieSearchList']/div/a[1]")).click();
		System.out.println("Title is matching: "+ movie_Title );
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\Movie_title.png"));
		}
		else
		{
			System.out.println("title is not matching: " + movie_Title);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\Movie_title.png"));
		}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public static void verify_Overview() throws IOException
	{
		try{
		final String movie_Overview="A skipper-for-hire's romance with a beautiful drifter is "
		         		+ "complicated by his growing involvement with the French resistance.";
				
		String overView=driver.findElement(By.xpath(".//*[@id='overViewbox']/div[3]/p[1]")).getText();
		highLightElement(driver.findElement(By.xpath(".//*[@id='overViewbox']/div[3]/p[1]")));
		if(overView.equals(movie_Overview))
		{
		System.out.println("Overview is matching with excepted value: "+movie_Overview );
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\overview.png"));
		}
		else
		{
			System.out.println("Overview is not matching with excepted value"+movie_Overview );
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\overview.png"));
		}
		}catch(Exception e)
		{
		System.out.println(e);
		}
	}
	public static void verify_Actors_Name() 
	{
		try{
			String Actors_Name= "Walter Brennan";
			String Cast_1=driver.findElement(By.xpath(".//*[@id='overViewbox']/div[6]/div[2]/div[2]/strong/a")).getText();
			String Cast_2=driver.findElement(By.xpath("//*[@id='overViewbox']/div[6]/div[3]/div[3]/strong/a")).getText();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			highLightElement(driver.findElement(By.xpath(".//*[@id='overViewbox']/div[6]/div[2]/div[2]/strong/a")));
			highLightElement(driver.findElement(By.xpath("//*[@id='overViewbox']/div[6]/div[3]/div[3]/strong/a")));
     		if(Actors_Name.equals(Cast_1))
			{
			System.out.println("matching with excepted value: "+Cast_1 +" and " +Cast_2);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\Actors.png"));
			}
			else
			{
				System.out.println("Not matching with excepted value: "+Cast_1 +" and " +Cast_2);
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\Actors.png"));
			}
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public static void verify_Release_Date() 
	{
		try{
			String Release_Date= "1944";
			String R_Date=driver.findElement(By.xpath(".//*[@id='additional']/table/tbody/tr[2]/td[2]")).getText();
			highLightElement(driver.findElement(By.xpath(".//*[@id='additional']/table/tbody/tr[2]/td[2]")));
			if(R_Date.equals(Release_Date))
			{
			System.out.println("matching with excepted value: "+R_Date);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\RDate.png"));
			}
			else
			{
				System.out.println("Not matching with excepted value: "+R_Date);
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\RDate.png"));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public static void highLightElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try 
		{
		  Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
		  System.out.println(e.getMessage());
		} 
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		 
	}
	
}
