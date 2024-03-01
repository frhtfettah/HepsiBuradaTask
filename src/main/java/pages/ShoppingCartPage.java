package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends Base {

    By quantity = By.name("quantity");
    By basketItemCount = By.id("basket-item-count");
    By deleteBasket = By.xpath("//div[contains(@class,\"basket_delete\")]");
    By confirmDelete = By.xpath("//button[text()=\"Tümünü sil\"]");
    By nameOfProduct = By.xpath("(//div[contains(@class, 'product_name')])[1]");
    By priceOfProduct = By.xpath("//div[contains(@class, 'product_price_container')]");

    HomePage homePage = new HomePage();
    WebDriver driver = Base.setUp(homePage.getBrowser());
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public String getCartPageTitle(){
        return driver.getTitle();
    }

    public String checkQuantity(){
        wait.until(ExpectedConditions.presenceOfElementLocated(quantity));
        return driver.findElement(quantity).getAttribute("value");
    }

    public String checkBasketItemCount(){
        wait.until(ExpectedConditions.presenceOfElementLocated(basketItemCount));
        return driver.findElement(basketItemCount).getText();
    }

    public String checkNameOfProduct(){
        wait.until(ExpectedConditions.presenceOfElementLocated(nameOfProduct));
        return driver.findElement(nameOfProduct).getText();}

    public String checkPriceOfProduct(){
        wait.until(ExpectedConditions.presenceOfElementLocated(priceOfProduct));
        return driver.findElement(priceOfProduct).getText();}

    public void emptyCart(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteBasket));
        driver.findElement(deleteBasket).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete));
        driver.findElement(confirmDelete).click();
    }
}

