package pl.coderslab.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.coderslab.funkcje.LoginSetUp;
import pl.coderslab.pageObjects.LoginPage;
import pl.coderslab.pageObjects.UserAccountPage;
import pl.coderslab.pageObjects.UserShipmentAddressFormPage;
import pl.coderslab.pageObjects.UserShipmentAddressesPage;

public class CreateNewAddressSteps {
    WebDriver driver;
    String listOfInputtedData;
    UserShipmentAddressFormPage userShipmentNewAddressFormPage;
    UserShipmentAddressesPage userShipmentAddressesPage;


    @Given("^User is logged in to CodersLab shop and have created first address$")
    public void userIsLoggedInToCodersLabShopAndHaveCreatedFirstAddress() {
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("GaryPBowyer@rhyta.com", "ethub0Oy6f");
        Assert.assertEquals("Jan Testowy", loginPage.getLoggedUsername());
        loginPage.goToUserAccountPage();
    }

    @When("^User click on the addresses button$")
    public void userClickOnTheAddressesButton() {
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        userAccountPage.goToShipmentAddressesPage();
    }

    @And("^User click on the create new address link$")
    public void userClickOnTheLink() {
        userShipmentAddressesPage = new UserShipmentAddressesPage(driver);
        userShipmentAddressesPage.setCreateNewAddress();
    }

    @And("^User enter the (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), data$")
    public void userEnterTheAliasFirstNameLastNameAddressCityZipPhoneData(String alias, String firstName, String lastName, String address, String city, String zip, String phone, String country) {
        userShipmentNewAddressFormPage = new UserShipmentAddressFormPage(driver);
        userShipmentNewAddressFormPage.setAlias(alias);
        userShipmentNewAddressFormPage.setFirstName(firstName);
        userShipmentNewAddressFormPage.setLastName(lastName);
        userShipmentNewAddressFormPage.setAddress(address);
        userShipmentNewAddressFormPage.setCity(city);
        userShipmentNewAddressFormPage.setZip(zip);
        userShipmentNewAddressFormPage.setPhone(phone);
        userShipmentNewAddressFormPage.setCountry(country);
        listOfInputtedData = new StringBuilder().append(alias)
                                                .append("\n")
                                                .append(firstName)
                                                .append(" ")
                                                .append(lastName)
                                                .append("\n")
                                                .append(address)
                                                .append("\n")
                                                .append(city)
                                                .append("\n")
                                                .append(zip)
                                                .append("\n")
                                                .append(phone)
                                                .append("\n")
                                                .append(country)
                                                .toString();
    }

    @And("^User saves the informations$")
    public void userSavesTheInformations() {
        userShipmentNewAddressFormPage.clickSaveButton();
    }

    @Then("^User will have new address tile create with correct (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), data$")
    public void userWillHaveNewAddressTileCreate(String alias, String firstName, String lastName, String address, String city, String zip, String phone, String country) {
        //userShipmentAddressesPage.checkSavedAddress(listOfInputtedData);
        userShipmentAddressesPage.checkSavedAddressByOneItem(alias, firstName, lastName, address, city, zip, phone, country);
    }
}
