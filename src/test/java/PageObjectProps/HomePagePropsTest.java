package PageObjectProps;
import PageObjectProps.PageProps.HomePageProps;
import PageObjectProps.PageProps.TestBaseProps;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import static org.testng.Assert.assertTrue;

public class HomePagePropsTest extends TestBaseProps {

    @Test
    public void duckClickRubberDarkTest() {
        String title;
        title = HomePageProps.duckClickRubberDark(driver);
        assertTrue(title.contains("Rubber Ducks"), "Rubber Ducks not found");
    }

    @Test
    public void duckClickDeliveryInformationTest() {
        String footer = "";

        footer = HomePageProps.duckClickDeliveryInformation(driver);
        assertTrue(footer.contains("Delivery Information"),"Delivery Information not found");
    }

    @Test
    public void duckClickTermConditionTest() {
        ArrayList<WebElement> listElements;
        String footer = "";
        footer = HomePageProps.duckClickTermCondition(driver);
        assertTrue(footer.contains("Terms & Conditions"),"Terms & Conditions not found");
    }
}
