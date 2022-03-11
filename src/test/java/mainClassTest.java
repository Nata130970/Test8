import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class mainClassTest extends settingClass{
    @Test
    public void openSite()  throws Exception{
        Alert alert;
        String alertText;
        ArrayList<WebElement> listTag;
        driver.get("https://the-internet.herokuapp.com");
        listTag = new ArrayList<>(driver.findElements(By.tagName("a")));
        listTag.get(8).click();

        }
    }

