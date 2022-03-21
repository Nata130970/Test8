package PageObjectFactory.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class RubberDucksPageFactory {

    WebDriver driver;

    @FindBy(css = "#site-menu ul > li.category-1")
    private WebElement buttonRubberDarkLocator;

    @FindBy(css = "#site-menu ul > li.category-1 > ul > li.category-2 ")
    private WebElement buttonSubCategoryLocator;

    @FindBys(@FindBy(xpath = "//li[@class='product row shadow hover-light']"))
    private List<WebElement> wrapperSubCategoryProductsLocator;

    @FindBy(xpath = "//nav[@class='filter']/a[@class='button'][text()='Name']")
    private WebElement buttonRubberDarkNameLocator;

    @FindBys(@FindBy( xpath = "//ul[@class='listing-wrapper products']/li[@class='product column shadow hover-light']//div[@class='name']"))
    private List<WebElement> productsRubberDarkLocator;

    @FindBy(xpath = "//nav[@class='filter']//*[contains(@class,'button')][text()='Price']")
    private WebElement buttonPriceLocator;

    @FindBys(@FindBy( xpath = "//ul[@class='listing-wrapper products']/li[@class='product column shadow hover-light']//span[@class='price']"))
    private List<WebElement> productsPriceLocator;

    @FindBys(@FindBy( xpath = "//div[@class='sticker new']"))
    private List<WebElement> stickerNewLocator;


    public RubberDucksPageFactory(WebDriver driver){
        this.driver = driver;
    }

    public int duckSubcategory() {
        String sticker;
        int result =0;
        String name;

        Actions builder = new Actions(driver);
        builder.moveToElement(buttonRubberDarkLocator).perform();
        builder.click(buttonSubCategoryLocator).perform();
        for (WebElement el : wrapperSubCategoryProductsLocator) {
            name = el.findElement(By.className("name")).getText();
            sticker = el.findElement(By.xpath(".//div[contains(@class,'sticker')]")).getText();
            if  ((name.equals("Yellow Duck")) && ( sticker.equals("SALE"))) result++;
            if  ((name.equals("Green DucK")) && ( sticker.equals("NEW"))) result++;
            if  ((name.equals("Розовая уточка")) && ( sticker.equals("NEW")))  result++;
        }
        return  result;
    }


    public  ArrayList duckSortName(WebDriver driver){
        ArrayList<String> name = new ArrayList<>();

        buttonRubberDarkLocator.click();
        buttonRubberDarkNameLocator.click();
        for (WebElement element :  productsRubberDarkLocator){
            name.add(element.getText());
        }
        return  name;
    }

    public  ArrayList duckSortPrice(WebDriver driver) {
        ArrayList<Float> price = new ArrayList<>();;

        buttonRubberDarkLocator.click();
        buttonPriceLocator.click();
        for (WebElement element :  productsPriceLocator){
            String e = element.getText();
            Float a = Float.valueOf(e.substring(0,e.indexOf("€")-1));
            price.add(a);
        }
        return price;
    }
    public  int[] duckNewLabel(WebDriver driver) {
        int countLabel = 0;
        int[]  Result = new int[2];

        buttonRubberDarkLocator.click();
        for (WebElement element : stickerNewLocator) {
            if (element.getText().equals("NEW"))
                countLabel++;
        }
        Result[0] = stickerNewLocator.size();
        Result[1] = countLabel;
        return Result;
    }

}
