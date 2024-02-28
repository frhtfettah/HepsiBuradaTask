package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingPage extends Base {

    By petShop = By.xpath("//*[text() = 'Pet Shop']");
    By selectedProduct = By.xpath("//*[@title = \"Better Life Evcil Hayvanlar Için Pet Sırt Çantası - Gri (Yurt Dışından)\"]");
    By addToCart = By.xpath("//*[text()=\"Sepete ekle\"]");
    By selectColor = By.xpath("//div[contains(@class,\"ProductCardButton\")]");
    By shoppingCart = By.id("shoppingCart");
    By addedToCartPopUp = By.xpath("//div[@class=\"hb-toast-close-icon-holder\"]");

    WebDriver driver = Base.setUp();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    Actions action = new Actions(driver);

    public void clickPetShop(){
        wait.until(ExpectedConditions.elementToBeClickable(petShop));
        driver.findElement(petShop).click();
        driver.navigate().refresh();
    }

    public void selectAndAddProduct(){
        action.moveToElement(driver.findElement(selectedProduct)).perform();
        driver.findElement(addToCart).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectColor));
        driver.findElement(selectColor).click();
        wait.until(ExpectedConditions.elementToBeClickable(addedToCartPopUp));
        driver.findElement(addedToCartPopUp).click();
    }

    public void goToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        driver.findElement(shoppingCart).click();
    }
}
