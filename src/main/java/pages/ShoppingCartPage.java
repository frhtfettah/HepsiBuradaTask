package pages;

import org.openqa.selenium.By;

public class ShoppingCartPage {

    By completeShopping = By.id("continue_step_btn");
    By quantity = By.name("quantity");
    By productName = By.xpath("//div[contains(@class,\"product_name\")]");
    By productVariant = By.xpath("//div[contains(@class,\"product_variant\")]");
    By basketItemCount = By.id("basket-item-count");
}
