package PageObjectProps.PageProps;

import PageObjectProps.Helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class HomePageProps {
    WebDriver driver;

    private static By buttonRubberDarkLocator = Locators.getLocator("HomePageProps.buttonRubberDark");
    private static By buttonDeliveryInformationLocator = Locators.getLocator("HomePageProps.buttonDeliveryInformation");
    private static By footerModeLocator = Locators.getLocator("HomePageProps.footerMode");
    private static By buttonTermConditionLocator = Locators.getLocator("HomePageProps.buttonTermCondition");
    private static By titlePageRubberDarkLocator = Locators.getLocator("HomePageProps.titlePageRubberDark");


    public static String duckClickRubberDark(WebDriver driver){

        driver.findElement(buttonRubberDarkLocator).click();
        return driver.findElement(titlePageRubberDarkLocator).getText();
    }

    public static String duckClickDeliveryInformation(WebDriver driver) {

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

    public  static String duckClickTermCondition(WebDriver driver) {    //WPath locators
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
