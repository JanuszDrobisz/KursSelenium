package pl.coderslab.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.coderslab.funkcje.LoginSetUp;
import pl.coderslab.funkcje.ScreenShotMaking;
import pl.coderslab.pageObjects.*;

public class BuyingProductSteps {
    WebDriver driver;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    YourOrderPage yourOrderPage;

    @Given("^User is logged in to CodersLab shop and is on the home page of the store$")
    public void userIsLoggedInToCodersLabShopAndIsOnTheHomePageOfTheStore() {
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("GaryPBowyer@rhyta.com", "ethub0Oy6f");
        Assert.assertEquals("Jan Testowy", loginPage.getLoggedUsername());

    }


    @When("^User search for \"([^\"]*)\" and enter the product detail$")
    public void userSearchForAndEnterTheProductDetail(String productName){
        homePage = new HomePage(driver);
        homePage.setSearchBar(productName);
        homePage.getProduct();
    }

    @And("^pick the chosen size \"([^\"]*)\" and amount equal \"([^\"]*)\"$")
    public void pickTheChosenSizeAndAmount(String size, String amount) {
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.setSize(size);
        productDetailsPage.setQuantity(amount);
    }

    @And("^add the product to the basket$")
    public void addTheProductToTheBasket() {
        productDetailsPage.clickAddButton();
        productDetailsPage.setProceedToCheckout();

    }

    @And("^confirm address, delivery method and payment method$")
    public void confirmAddressDeliveryMethodAndPaymentMethod() {

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.checkDiscount();
        shoppingCartPage.clickProceedToCheckout();

        yourOrderPage = new YourOrderPage(driver);
        yourOrderPage.setConfirmAddresses();
        yourOrderPage.setShoppingMethod();
        yourOrderPage.setConfirmShoppingMethod();
        yourOrderPage.setPaymentOption();
        yourOrderPage.checkApproveTermsOfService();
        yourOrderPage.setOrderWithAnObligationToPay();
    }

    @Then("^take a screenshot of your order$")
    public void takeAScreenshotOfYourOrder() {
        ScreenShotMaking.makeScreenShot();
    }
}
