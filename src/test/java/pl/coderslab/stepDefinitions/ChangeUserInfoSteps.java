package pl.coderslab.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.coderslab.funkcje.LoginSetUp;
import pl.coderslab.pageObjects.LoginPage;
import pl.coderslab.pageObjects.UserInfoPage;

public class ChangeUserInfoSteps {
    UserInfoPage userInfoPage;
    WebDriver driver;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLoggedInToCodersLabShop() {
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("GaryPBowyer@rhyta.com", "ethub0Oy6f");
        Assert.assertEquals("Jan Testowy", loginPage.getLoggedUsername());
    }

    @When("^User goes to UserinformationPage$")
    public void userGoesToUserinformationPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=identity");
        userInfoPage = new UserInfoPage(driver);
    }

    @And("^User changes his birthday to \"([^\"]*)\"$")
    public void userChangesHisBirthdayTo(String birthDate) {
        userInfoPage.setBirthdate(birthDate);
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdatedInformation());
    }
}
