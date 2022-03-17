package OldDuck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class  SettingClass{
WebDriver driver;

@BeforeTest
public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        }

@AfterTest
public void close(){
        driver.quit();
        }

}
