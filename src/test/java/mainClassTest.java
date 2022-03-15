import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class mainClassTest extends settingClass{
    @Test
    public void openSite()  {
        ArrayList<WebElement> listTag;
        driver.get("https://the-internet.herokuapp.com");
        listTag = new ArrayList<>(driver.findElements(By.tagName("a")));
        listTag.get(8).click();
        }

    @Test
    public void examleIFrame()  {
        WebElement element;
        String expMsg = "Hello, World !!!!";

        driver.get("https://the-internet.herokuapp.com");
        driver.findElements(By.tagName("a")).get(22).click();
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame("mce_0_ifr");
        element = driver.findElement(By.cssSelector("#tinymce"));
        element.clear();
        element.sendKeys(expMsg);
        String resMsg = element.getText();
        driver.switchTo().defaultContent();
        assertEquals(element.getText(),expMsg,String.format("resMsg: %s,expMsg: %s",resMsg,expMsg));

    }
    @Test
    public void examleWindows() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();
        String currentWin;
        String name = "Natalia";

        driver.get("https://belhard.academy/ru");
        driver.findElement(By.xpath("//div[contains(@class,'t-btn')][text() =' Записаться на курс ']")).click();
        currentWin = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(currentWin);
        driver.findElement(By.xpath("//a[@class='js-click-stat']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='fldname']")).sendKeys(name);

//        new WebDriverWait(driver, Duration.ofSeconds(10))
//           .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='fldname']"))).sendKeys("Natalia");

        String readName = driver.findElement(By.name("fldname")).getAttribute("value");
        driver.close();
        driver.switchTo().window(mainWindow);
        assertEquals(readName,name,String.format("res=%s expRes=%s",readName,name));

    }
}

