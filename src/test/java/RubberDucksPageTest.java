import Page.BaseTest;
import Page.RubberDucksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.testng.Assert.assertTrue;


public class RubberDucksPageTest extends BaseTest {


    @Test
    public void duckSubcategoryTest() {
        int result=0;
        RubberDucksPage rubberDucks = new RubberDucksPage(driver);
        result = rubberDucks.duckSubcategory();

        assertTrue((result==3),String.format("Result= %s expRes = 3", result));
    }

    @Test
    public void duckSortNameTest(){

        ArrayList<String> nameSort;
        ArrayList<String> name;

        RubberDucksPage rubberDucks = new RubberDucksPage(driver);
        name = rubberDucks.duckSortName();
        nameSort = (ArrayList)name.clone();
      //  Collections.swap(nameSort, 0, 4);
        Collections.sort(nameSort);
        assertTrue(name.equals(nameSort),String.format("Exp: %s Res: %s",nameSort,name));
    }

    @Test
    public void duckSortPriceTest() {

        ArrayList<Float> priceSort;
        ArrayList<Float> price;
        RubberDucksPage rubberDucks = new RubberDucksPage(driver);
        price = rubberDucks.duckSortPrice();
        priceSort = (ArrayList)price.clone();
        Collections.sort(priceSort);
        assertTrue(price.equals(priceSort),String.format("Exp: %s Res: %s",priceSort,price));
    }

    @Test
    public void duckNewLabelTest() {
        int[]  Result = new int[2];
        RubberDucksPage rubberDucks = new RubberDucksPage(driver);
        Result = rubberDucks.duckNewLabel();
        assertTrue(Result[0] == Result[1],String.format("Exp: %s Res: %s ",Result[0],Result[1]));
    }

}
