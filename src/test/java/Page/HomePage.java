package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;



public class HomePage {

    WebDriver driver;

    private By buttonRubberDarkLocator = By.xpath("//nav[@id='site-menu']/ul/li[@class='category-1']");
    private By buttonDeliveryInformationLocator = By.cssSelector("#site-menu > ul > li");
    private By footerModeLocator = By.cssSelector("#breadcrumbs > ul > li");
    private By buttonTermConditionLocator = By.xpath("//li[@class='page-4']");
    private By titlePageRubberDarkLocator = By.xpath("//div[@id='box-category']/h1[@class='title']");

    public HomePage(WebDriver driber){
        this.driver = driber;

    }
    public String duckClickRubberDark(){

        driver.findElement(buttonRubberDarkLocator).click();
        return driver.findElement(titlePageRubberDarkLocator).getText();
    }

    public String duckClickDeliveryInformation() {

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
    public String duckClickTermCondition() {    //WPath locators
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
