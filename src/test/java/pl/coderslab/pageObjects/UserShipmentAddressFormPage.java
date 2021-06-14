package pl.coderslab.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserShipmentAddressFormPage {
    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[3]/div[1]/input")
    private WebElement lastNameInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement zipInput;

    @FindBy(name = "id_country")
    private WebElement countryDropDawn;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id='content']//button")
    private WebElement saveButton;

    public UserShipmentAddressFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAlias(String alias) {
        aliasInput.sendKeys(alias);
    }

    public void setFirstName(String firstName) {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(lastName);
    }

    public void setAddress(String address) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setZip(String zip) {
        zipInput.sendKeys(zip);
    }

    public void setPhone(String phone) {
        phoneInput.sendKeys(phone);
    }
    public void saveAddress(){
        saveButton.click();
    }
}
