package PageObjectFactory;
import PageObjectFactory.PageFactory.HomePageFactory;
import PageObjectFactory.PageFactory.TestBaseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class HomePageFactoryTest extends TestBaseFactory {

    @Test
    public void duckClickRubberDarkTest() {
        String title;
        WebDriver driver = new ChromeDriver();
        HomePageFactory homePage = PageFactory.initElements(driver,HomePageFactory.class);
        title = homePage.duckClickRubberDark();
        assertTrue(title.contains("Rubber Ducks"), "Rubber Ducks not found");
    }
/*
    @Test
    public void duckClickDeliveryInformationTest() {
        String footer = "";

        footer = HomePageStatic.duckClickDeliveryInformation(driver);
        assertTrue(footer.contains("Delivery Information"),"Delivery Information not found");
    }

    @Test
    public void duckClickTermConditionTest() {
        ArrayList<WebElement> listElements;
        String footer = "";
        footer = HomePageStatic.duckClickTermCondition(driver);
        assertTrue(footer.contains("Terms & Conditions"),"Terms & Conditions not found");
    }*/
}