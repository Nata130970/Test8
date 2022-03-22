package PageObjectProps.PageProps;
import PageObjectProps.Helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;

public class RubberDucksPageProps {

    WebDriver driver;

    private static By buttonRubberDarkLocator = Locators.getLocator("RubberDucksPageProps.buttonRubberDark");
    private static By buttonSubCategoryLocator = Locators.getLocator("RubberDucksPageProps.buttonSubCategory");
    private static By wrapperSubCategoryProductsLocator = Locators.getLocator("RubberDucksPageProps.wrapperSubCategoryProducts");
    private static By stickerSubCategoryLocator = Locators.getLocator("RubberDucksPageProps.stickerSubCategory");
    private static By buttonRubberDarkNameLocator = Locators.getLocator("RubberDucksPageProps.buttonRubberDarkName");
    private static By productsRubberDarkLocator = Locators.getLocator("RubberDucksPageProps.productsRubberDark");
    private static By buttonPriceLocator = Locators.getLocator("RubberDucksPageProps.buttonPrice");
    private static By productsPriceLocator = Locators.getLocator("RubberDucksPageProps.productsPrice");
    private static By stickerNewLocator = Locators.getLocator("RubberDucksPageProps.stickerNew");


    public static int duckSubcategory(WebDriver driver) {     // Actions
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

    public static ArrayList duckSortName(WebDriver driver){
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
    public static ArrayList duckSortPrice(WebDriver driver) {

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
    public static int[] duckNewLabel(WebDriver driver) {
        ArrayList<WebElement> listElements;
        int countLabel = 0;
        int[]  Result = new int[2];
        driver.findElement(buttonRubberDarkLocator).click();
        listElements = new ArrayList<>(driver.findElements(stickerNewLocator));
        for (WebElement element : listElements) {
            if (element.getText().equals("NEW"))
                countLabel++;
        }
        Result[0] = listElements.size();
        Result[1] = countLabel;
        return Result;
    }

}
