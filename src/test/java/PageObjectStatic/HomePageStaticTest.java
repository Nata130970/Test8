package PageObjectStatic;
import PageObjectStatic.PageStatic.HomePageStatic;
import PageObjectStatic.PageStatic.TestBaseStatic;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.testng.Assert.assertTrue;

public class HomePageStaticTest extends TestBaseStatic {

    @Test
    public void duckClickRubberDarkTest() {
        String title;
        title = HomePageStatic.duckClickRubberDark(driver);
        assertTrue(title.contains("Rubber Ducks"), "Rubber Ducks not found");
    }

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
    }
}
