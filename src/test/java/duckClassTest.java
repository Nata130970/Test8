import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.testng.Assert.assertTrue;

public class duckClassTest extends settingClass {

    @Test
    public void duckClickHeaderRubberDarkTest() {    //WPath locators
        String title;
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//nav[@id='site-menu']/ul/li[@class='category-1']")).click();
        title=driver.findElement(By.xpath("//div[@id='box-category']/h1[@class='title']")).getText();
        assertTrue(title.contains("Rubber Ducks"),"Rubber Ducks not found");
    }

    @Test
    public void duckClickHeaderDeliveryInformationTest() {  // CSS locators
        ArrayList<WebElement> listElements;
        String footer = "";

        ArrayList<String> listTitle = new ArrayList<>();
        driver.get("https://litecart.stqa.ru/en/");
        listElements = new ArrayList<>(driver.findElements(By.cssSelector("#site-menu > ul > li")));
        for( WebElement element : listElements){
            if (element.getText().equals("Delivery Information")) {
                element.click();
                break;
            }
        }
        listElements = new ArrayList<>(driver.findElements(By.cssSelector("#breadcrumbs > ul > li")));
        for( WebElement element : listElements){
            footer = footer + " " + (element.getText());
        }
        assertTrue(footer.contains("Delivery Information"),"Delivery Information not found");
    }

    @Test
    public void duckClickHeaderTermConditionTest() {    //WPath locators
        ArrayList<WebElement> listElements;
        String footer = "";

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//li[@class='page-4']")).click();
        listElements = new ArrayList<>(driver.findElements(By.xpath("//nav[@id='breadcrumbs']/ul/li")));
        for (WebElement element :  listElements){
            footer = footer + " " + (element.getText());
        }
        assertTrue(footer.contains("Terms & Conditions"),"Terms & Conditions not found");
    }

    @Test
    public void duckSubcategoryTest() {     // Actions

        WebElement element;
        String title;

        driver.get("https://litecart.stqa.ru/en/");
        Actions builder = new Actions(driver);
        element = driver.findElement(By.cssSelector("#site-menu ul > li.category-1"));
        builder.moveToElement(element).perform();
        element = driver.findElement(By.cssSelector("#site-menu ul > li.category-1 > ul > li.category-2 "));
        builder.click(element).perform();
        title = driver.findElement(By.cssSelector("#breadcrumbs > .list-horizontal > li:last-child")).getText().trim();
        assertTrue(title.contains("Subcategory"),"Subcategory not found");
    }

    @Test
    public void duckSortNameTest(){
        ArrayList<WebElement> listElements;
        ArrayList<String> nameSort;
        ArrayList<String> name = new ArrayList<>();;

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//li[@class='category-1']")).click();
        driver.findElement(By.xpath("//nav[@class='filter']/a[@class='button'][text()='Name']")).click();
        listElements = new ArrayList<>(driver.findElements(By.xpath("//ul[@class='listing-wrapper products']/" +
                "li[@class='product column shadow hover-light']//div[@class='name']")));
        for (WebElement element :  listElements){
            name.add(element.getText());
        }
        nameSort = (ArrayList)name.clone();
        //Collections.swap(nameSort, 0, 4);
        Collections.sort(nameSort);
        assertTrue(name.equals(nameSort),String.format("Exp: %s Res: %s",nameSort,name));
    }
    @Test
    public void duckSortPriceTest() {
        ArrayList<WebElement> listElements;
        ArrayList<String> priceSort;
        ArrayList<String> price = new ArrayList<>();;

        driver.get("https://litecart.stqa.ru/en/");

        driver.findElement(By.xpath("//li[@class='category-1']")).click();
        driver.findElement(By.xpath("//nav[@class='filter']//*[contains(@class,'button')][text()='Price']")).click();

        listElements = new ArrayList<>(driver.findElements(By.xpath("//ul[@class='listing-wrapper products']/" +
                "li[@class='product column shadow hover-light']//span[@class='price']")));
        for (WebElement element :  listElements){
            price.add(element.getText());
        }
        priceSort = (ArrayList)price.clone();
        Collections.sort(priceSort);
        assertTrue(price.equals(priceSort),String.format("Exp: %s Res: %s",priceSort,price));
    }
    @Test
    public void duckNewLabelTest() {
        ArrayList<WebElement> listElements;
        int countLabel = 0;

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//li[@class='category-1']")).click();
        listElements = new ArrayList<>(driver.findElements(By.xpath("//div[@class='sticker new']")));
        for (WebElement element : listElements) {
            if (element.getText().equals("NEW"))
            countLabel++;
        }
        assertTrue((listElements.size()==countLabel), String.format("Exp: %s Res: %s",listElements.size(),countLabel));



    }


}

