package PageObjectProps.Helpers;
import PageObjectProps.Enums.LocatorTypes;
import org.openqa.selenium.By;
import java.io.InputStream;
import java.util.Properties;

public class Locators {

    private static Properties locators;

    static {
        locators = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static By getLocator(String locator) throws IllegalArgumentException {
        String value = locators.getProperty(locator);
        String[] locatorItems = value.split("=", 2);
        LocatorTypes.LocatorType locatorType = LocatorTypes.LocatorType.valueOf(locatorItems[0]);

        switch (locatorType) {
            case id:   {
                return By.id(locatorItems[1]);
            }
            case name: {
                return By.name(locatorItems[1]);
            }
            case css: {
                return By.cssSelector(locatorItems[1]);
            }
            case xpath: {
                return By.xpath(locatorItems[1]);
            }
            case tag: {
                return By.tagName(locatorItems[1]);
            }
            case text: {
                return By.linkText(locatorItems[1]);
            }
            case partText: {
                return By.partialLinkText(locatorItems[1]);
            }
            case className: {
                return By.className(locatorItems[1]);
            }
            default: {
                 throw new IllegalArgumentException("No such locator type: " + locatorItems[0]);

            }
        }
    }
}