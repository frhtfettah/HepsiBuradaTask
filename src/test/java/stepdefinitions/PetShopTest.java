package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.After;
import org.junit.Before;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import pages.ShoppingPage;
import util.Driver;

public class PetShopTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ShoppingPage shoppingPage = new ShoppingPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Before
    public void setUp() {
        Driver.setUp();
    }

    @After
    public void tearDown(){
        Driver.tearDown();
    }

    @Given("User is logged in to the HepsiBurada web application")
    public void loginToTheHepsiBurada(){
        homePage.navigate("http://hepsiburada.com");
                

    }

}
