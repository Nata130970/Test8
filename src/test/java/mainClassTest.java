import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class mainClassTest {
    @Test
    public void openSite(){
        ArrayList<WebElement> listTag;
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        listTag = new ArrayList<>(driver.findElements(By.tagName("a")));
        listTag.get(8).click();
        }
    }

