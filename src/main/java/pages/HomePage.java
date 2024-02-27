package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;

import java.time.Duration;

public class HomePage extends Base {
    By acceptCookies = By.id("onetrust-accept-btn-handler");
    By mainLoginButton = By.id("myAccount");
    By loginButton = By.id("login");

    WebDriver driver = Driver.setUp();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions action = new Actions(driver);

    public void openLoginPage(String url){
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        driver.findElement(acceptCookies).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(mainLoginButton)));
        wait.until(ExpectedConditions.presenceOfElementLocated(mainLoginButton));
        action.moveToElement(driver.findElement(mainLoginButton)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

}
