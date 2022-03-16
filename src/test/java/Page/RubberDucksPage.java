package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertTrue;

public class RubberDucksPage {

    WebDriver driver;
    private By buttonRubberDarkLocator = By.cssSelector("#site-menu ul > li.category-1");
    private By buttonSubCategoryLocator = By.cssSelector("#site-menu ul > li.category-1 > ul > li.category-2 ");
    private By wrapperSubCategoryProductsLocator = By.xpath("//li[@class='product row shadow hover-light']");
    private By stickerSubCategoryLocator = By.xpath(".//div[contains(@class,'sticker')]");
    private By buttonRubberDarkNameLocator = By.xpath("//nav[@class='filter']/a[@class='button'][text()='Name']");
    private By productsRubberDarkLocator = By.xpath("//ul[@class='listing-wrapper products']/" +
            "li[@class='product column shadow hover-light']//div[@class='name']");
    private By buttonPriceLocator = By.xpath("//nav[@class='filter']//*[contains(@class,'button')][text()='Price']");
    private By productsPriceLocator = By.xpath("//ul[@class='listing-wrapper products']/" +
            "li[@class='product column shadow hover-light']//span[@class='price']");
    private By stickerNewLocator =By.xpath("//div[@class='sticker new']");

    public RubberDucksPage(WebDriver driber){
        this.driver = driber;
    }

    public int duckSubcategory() {     // Actions
        ArrayList<WebElement> listElements;
        WebElement element;
        String sticker;
        int result =0;
        String name;

        Actions builder = new Actions(driver);
        element = driver.findElement(buttonRubberDarkLocator);
        builder.moveToElement(element).perform();
        element = driver.findElement(buttonSubCategoryLocator);
        builder.click(element).perform();
        listElements = new ArrayList<>(driver.findElements(wrapperSubCategoryProductsLocator));
        for (WebElement el : listElements) {
            name = el.findElement(By.className("name")).getText();
            sticker = el.findElement(stickerSubCategoryLocator).getText();
            if  ((name.equals("Yellow Duck")) && ( sticker.equals("SALE"))) result++;
            if  ((name.equals("Green DucK")) && ( sticker.equals("NEW"))) result++;
            if  ((name.equals("Розовая уточка")) && ( sticker.equals("NEW")))  result++;
        }
        return  result;
    }

    public ArrayList duckSortName(){
        ArrayList<WebElement> listElements;
        ArrayList<String> name = new ArrayList<>();

        driver.findElement(buttonRubberDarkLocator).click();
        driver.findElement(buttonRubberDarkNameLocator).click();
        listElements = new ArrayList<>(driver.findElements(productsRubberDarkLocator));
        for (WebElement element :  listElements){
            name.add(element.getText());
        }
        return  name;
    }
    public ArrayList duckSortPrice() {

        ArrayList<WebElement> listElements;
        ArrayList<Float> price = new ArrayList<>();;

        driver.findElement(buttonRubberDarkLocator).click();
        driver.findElement(buttonPriceLocator).click();
        listElements = new ArrayList<>(driver.findElements(productsPriceLocator));
        for (WebElement element :  listElements){
            String e = element.getText();
            Float a = Float.valueOf(e.substring(0,e.indexOf("€")-1));
            price.add(a);
        }
        return price;
    }
    public void duckNewLabel() {
        ArrayList<WebElement> listElements;
        int countLabel = 0;

        driver.findElement(buttonRubberDarkLocator).click();
        listElements = new ArrayList<>(driver.findElements(stickerNewLocator));
        for (WebElement element : listElements) {
            if (element.getText().equals("NEW"))
                countLabel++;
        }
        assertTrue((listElements.size()==countLabel), String.format("Exp: %s Res: %s",listElements.size(),countLabel));
    }

}