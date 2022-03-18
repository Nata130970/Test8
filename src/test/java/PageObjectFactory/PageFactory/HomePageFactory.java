package PageObjectFactory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePageFactory {

    @FindBy( xpath=("//nav[@id='site-menu']/ul/li[@class='category-1']"))
    private WebElement buttonRubberDarkLocator;

    @FindBy ( xpath=("//div[@id='box-category']/h1[@class='title']"))
    private WebElement titlePageRubberDarkLocator;

 //   @FindBy(css=("#site-menu > ul > li"))
 //   private WebElement buttonDeliveryInformationLocator;

//    private static By buttonRubberDarkLocator = By.xpath("//nav[@id='site-menu']/ul/li[@class='category-1']");

    private static By buttonDeliveryInformationLocator = By.cssSelector("#site-menu > ul > li");



    private static By footerModeLocator = By.cssSelector("#breadcrumbs > ul > li");
    private static By buttonTermConditionLocator = By.xpath("//li[@class='page-4']");
//    private static By titlePageRubberDarkLocator = By.xpath("//div[@id='box-category']/h1[@class='title']");


    public String duckClickRubberDark(){

        buttonRubberDarkLocator.click();
        return titlePageRubberDarkLocator.getText();
    }

    public String duckClickDeliveryInformation(WebDriver driver) {

        ArrayList<WebElement> listElements;
        String footer = "";
        ArrayList<String> listTitle = new ArrayList<>();

        listElements = new ArrayList<>(driver.findElements(buttonDeliveryInformationLocator));
        for( WebElement element : listElements){
            if (element.getText().equals("Delivery Information")) {
                element.click();
                break;
            }
        }
        listElements = new ArrayList<>(driver.findElements(footerModeLocator));
        for( WebElement element : listElements){
            footer = footer + " " + (element.getText());
        }
        return footer;
    }

    public  String duckClickTermCondition(WebDriver driver) {    //WPath locators
        ArrayList<WebElement> listElements;
        String footer = "";
        driver.findElement(buttonTermConditionLocator).click();
        listElements = new ArrayList<>(driver.findElements(footerModeLocator));
        for (WebElement element :  listElements){
            footer = footer + " " + (element.getText());
        }
        return footer;
    }
}
