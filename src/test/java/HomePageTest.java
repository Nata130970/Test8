
import Page.BaseTest;
import Page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.testng.Assert.assertTrue;


    public class HomePageTest extends BaseTest {
        @Test
        public void duckClickRubberDarkTest() {
            String title;
            HomePage homePage = new HomePage(driver);

            title = homePage.duckClickRubberDark();
            assertTrue(title.contains("Rubber Ducks"), "Rubber Ducks not found");
        }

        @Test
        public void duckClickDeliveryInformationTest() {
            String footer = "";

            HomePage homePage = new HomePage(driver);
            footer = homePage.duckClickDeliveryInformation();
            assertTrue(footer.contains("Delivery Information"),"Delivery Information not found");
        }

        @Test
        public void duckClickTermConditionTest() {
            ArrayList<WebElement> listElements;
            String footer = "";
            HomePage homePage = new HomePage(driver);
            footer = homePage.duckClickTermCondition();
            assertTrue(footer.contains("Terms & Conditions"),"Terms & Conditions not found");
        }


    }


