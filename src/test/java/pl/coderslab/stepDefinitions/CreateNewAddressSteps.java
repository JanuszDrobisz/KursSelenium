package pl.coderslab.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewAddressSteps {
    @Given("^User is logged in to CodersLab shop and have created first address$")
    public void userIsLoggedInToCodersLabShopAndHaveCreatedFirstAddress() {
    }

    @When("^User click on the addresses button$")
    public void userClickOnTheAddressesButton() {
    }

    @And("^User click on the \"([^\"]*)\" link$")
    public void userClickOnTheLink(String linkName) {
    }

    @And("^User enter the (.*), (.*), (.*), (.*), (.*), (.*), (.*) data$")
    public void userEnterTheAliasFirstNameLastNameAddressCityZipPhoneData(String alias, String firstName, String lastName, String address, String city, String zip, String phone) {
    }

    @And("^User saves the informations$")
    public void userSavesTheInformations() {
    }

    @Then("^User will have new address tile create$")
    public void userWillHaveNewAddressTileCreate() {
    }
}
