package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Base {
    By loginWithFacebook = By.xpath("//*[text()=\" Facebook ile Giriş yap\"]");
    By facebookMail = By.id("email");
    By facebookPassword = By.id("pass");
    By facebookLoginBtn = By.id("loginbutton");

    HomePage homePage = new HomePage();
    WebDriver driver = Base.setUp(homePage.getBrowser());
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void loginAction(){
        wait.until(ExpectedConditions.presenceOfElementLocated(loginWithFacebook));
        driver.findElement(loginWithFacebook).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(facebookMail));
        driver.findElement(facebookMail).sendKeys("fettahogluferhat@gmail.com");
        driver.findElement(facebookPassword).sendKeys("Hepsiburadatask123");
        driver.findElement(facebookLoginBtn).click();
    }
}
