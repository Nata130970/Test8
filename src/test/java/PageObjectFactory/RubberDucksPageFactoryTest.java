package PageObjectFactory;

import PageObjectFactory.PageFactory.HomePageFactory;
import PageObjectFactory.PageFactory.RubberDucksPageFactory;
import PageObjectFactory.PageFactory.TestBaseFactory;
import PageObjectStatic.PageStatic.RubberDucksPageStatic;
import PageObjectStatic.PageStatic.TestBaseStatic;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertTrue;

public class RubberDucksPageFactoryTest extends TestBaseFactory {

    @Test
    public void duckSubcategoryTest() {
        int result=0;
        RubberDucksPageFactory rubberDuck = PageFactory.initElements(driver,RubberDucksPageFactory.class);
        result = rubberDuck.duckSubcategory();
        assertTrue((result==3),String.format("Result= %s expRes = 3", result));
    }

    @Test
    public void duckSortNameTest(){

        ArrayList<String> nameSort;
        ArrayList<String> name;

        name = RubberDucksPageStatic.duckSortName(driver);
        nameSort = (ArrayList)name.clone();
      //  Collections.swap(nameSort, 0, 4);
        Collections.sort(nameSort);
        assertTrue(name.equals(nameSort),String.format("Exp: %s Res: %s",nameSort,name));
    }

    @Test
    public void duckSortPriceTest() {

        ArrayList<Float> priceSort;
        ArrayList<Float> price;
        price = RubberDucksPageStatic.duckSortPrice(driver);
        priceSort = (ArrayList)price.clone();
        Collections.sort(priceSort);
        assertTrue(price.equals(priceSort),String.format("Exp: %s Res: %s",priceSort,price));
    }

    @Test
    public void duckNewLabelTest() {
        int[]  Result = new int[2];
        Result = RubberDucksPageStatic.duckNewLabel(driver);
        assertTrue(Result[0] == Result[1],String.format("Exp: %s Res: %s ",Result[0],Result[1]));
    }

}
