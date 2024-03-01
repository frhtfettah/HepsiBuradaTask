package stepdefinitions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import pages.ShoppingPage;

import static base.Base.driver;

public class PetShopTest {

    String nameOfSelectedProduct;
    String priceOfSelectedProduct;

    @Given("User is on the HepsiBurada main page via {string}")
    public void moveToTheLoginPage(String arg0) {
        Base.setUp(arg0);
        HomePage homePage = new HomePage();
        homePage.setBrowser(arg0);
        homePage.openLoginPage("https://www.hepsiburada.com/kampanyalar/yurt-disindan-urunler?wt_int=hytop.yurtdisi.kampanya");
    }

    @Given("User is logged in to the system")
    public void userLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAction();
    }

    @When("User clicks Pet Shop from the category menu on the left side")
    public void clickPetShop() {
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.clickPetShop();
    }

    @When("User selects a product from Pet Shop page and adds it to the cart")
    public void addProductToCart() {
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.selectAndAddProduct();
        nameOfSelectedProduct = shoppingPage.getNameOfProduct();
        priceOfSelectedProduct = shoppingPage.getPriceOfProduct();
    }

    @When("User navigates to the Shopping Cart page and checks the page")
    public void moveToCart() {
        ShoppingPage shoppingPage = new ShoppingPage();
        shoppingPage.goToCart();
    }

    @Then("Shopping Cart page should be displayed without any problems")
    public void checkCartPage() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String pageTitle = shoppingCartPage.getCartPageTitle();
        Assert.assertEquals("Sepetim", pageTitle);
    }

    @Then("Necessary buttons and fields that user checked are displayed correctly")
    public void checkCartPageElements() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String basketItemCount = shoppingCartPage.checkBasketItemCount();
        String quantity = shoppingCartPage.checkQuantity();
        String nameOfProduct = shoppingCartPage.checkNameOfProduct();
        String priceOfProduct = shoppingCartPage.checkPriceOfProduct();
        Assert.assertEquals(nameOfSelectedProduct, nameOfProduct);
        Assert.assertEquals(priceOfSelectedProduct, priceOfProduct);
        Assert.assertEquals("1", basketItemCount);
        Assert.assertEquals("1", quantity);
    }

    @After
    public static void tearDown(Scenario scenario) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.emptyCart();
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Base.tearDown();
    }
}
