package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends Base {

    By quantity = By.name("quantity");
    By productName = By.xpath("//div[contains(@class,\"product_name\")]");
    By productVariant = By.xpath("//div[contains(@class,\"product_variant\")]");
    By basketItemCount = By.id("basket-item-count");
    By deleteBasket = By.xpath("//div[contains(@class,\"basket_delete\")]");
    By confirmDelete = By.xpath("//button[text()=\"Tümünü sil\"]");

    WebDriver driver = Base.setUp();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public String getCartPageTitle(){
        return driver.getTitle();
    }

    public String checkProductName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productName));
        return driver.findElement(productName).getText();
    }

    public String checkQuantity(){
        return driver.findElement(quantity).getAttribute("value");
    }

    public String checkProductVariant(){
        return driver.findElement(productVariant).getText();
    }

    public String checkBasketItemCount(){
        return driver.findElement(basketItemCount).getText();
    }

    public void emptyCart(){
        driver.findElement(deleteBasket).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete));
        driver.findElement(confirmDelete).click();
    }
}

