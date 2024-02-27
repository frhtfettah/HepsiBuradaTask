package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;

import java.time.Duration;

public class Base extends Driver {

    private WebDriver driver = Driver.setUp();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void navigate(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void clickWebElement(WebElement xpath){
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
        xpath.click();
    }

    public void sendKey(WebElement xpath, String key){
        wait.until(ExpectedConditions.elementToBeSelected(xpath));
        xpath.sendKeys(key);
    }

    public String getElementText(WebElement xpath){
        return xpath.getText();
    }

}
