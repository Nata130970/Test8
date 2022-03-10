import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import javax.swing.*;
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;


public class duckClassTest {
    @Test
    public void duckTest() {
        // Csslocator

        ArrayList<WebElement> listElements;
        WebElement element;
        String title;

        ArrayList<String> listTitle = new ArrayList<>();
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        Actions builder = new Actions(driver);
        listElements = new ArrayList<>(driver.findElements(By.cssSelector("#site-menu > ul > li")));
        for( WebElement elements : listElements){
            listTitle.add(elements.getText());
        }
        element = driver.findElement(By.cssSelector("#site-menu ul > li.category-1"));
        builder.moveToElement(element).perform();
        element = driver.findElement(By.cssSelector("#site-menu ul > li.category-1 > ul > li.category-2 "));
        builder.click(element).perform();
        title = driver.findElement(By.cssSelector("#breadcrumbs > .list-horizontal > li:last-child")).getText().trim();
        assertEquals(title,"» Subcategory");
    }

}

