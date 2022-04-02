package PageObjectFactory.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.util.ArrayList;
import java.util.List;

public class HomePageFactory {
    WebDriver driver;

    @FindBy(xpath = "//nav[@id='site-menu']/ul/li[@class='category-1']")
    private WebElement buttonRubberDarkLocator;

    @FindBy(xpath = "//div[@id='box-category']/h1[@class='title']")
    private WebElement titlePageRubberDarkLocator;

    @FindBys(@FindBy( css = " #site-menu > ul > li"))
    private List<WebElement> buttonDeliveryInformationLocator;


    @FindBys(@FindBy( css = "#breadcrumbs > ul > li"))
    private List<WebElement> footerModeLocator;

    @FindBy(xpath="//li[@class='page-4']")
    private WebElement buttonTermConditionLocator;


    public HomePageFactory(WebDriver homePageFactory){
        this.driver=homePageFactory;
    }

    public String duckClickRubberDark(){
        buttonRubberDarkLocator.click();
        return titlePageRubberDarkLocator.getText();
    }

    public String duckClickDeliveryInformation() {

        String footer = "";

        for( WebElement element : buttonDeliveryInformationLocator){
            if (element.getText().equals("Delivery Information")) {
                element.click();
                break;
            }
        }
        for( WebElement element : footerModeLocator){
            footer = footer + " " + (element.getText());
        }
        return footer;
    }

    public  String duckClickTermCondition() {    //WPath locators

        String footer = "";
        buttonTermConditionLocator.click();
        for (WebElement element :  footerModeLocator){
            footer = footer + " " + (element.getText());
        }
        return footer;
    }
}
