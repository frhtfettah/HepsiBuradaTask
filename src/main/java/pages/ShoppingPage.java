package pages;

import org.openqa.selenium.By;

public class ShoppingPage {

    By petShop = By.xpath("//*[text() = 'Pet Shop']");
    By selectedProduct = By.xpath("//*[@title = \"Better Life Evcil Hayvanlar Için Pet Sırt Çantası - Gri (Yurt Dışından)\"]");

    By addToCart = By.xpath("//*[text()=\"Sepete ekle\"]");
    By selectColor = By.xpath("//*[text()=\"Sepete ekle\"]");

    By shoppingCart = By.id("shoppingCart");
}
