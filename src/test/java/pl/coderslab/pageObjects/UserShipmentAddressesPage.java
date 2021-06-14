package pl.coderslab.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class UserShipmentAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@class='addresses-footer']//a")
    private WebElement createNewAddress;

    @FindBy(xpath = "//section[@id='content']//article/div[@class='address-body']")
    private List<WebElement> listAddressTiles;


    public UserShipmentAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCreateNewAddress() {
        createNewAddress.click();
    }

    public void checkSavedAddress(String listOfInputtedData) {
        int listAddressTilesSize = listAddressTiles.size();
        String allAddressData = listAddressTiles.get(listAddressTilesSize - 1).getText();
        Assert.assertEquals(listOfInputtedData, allAddressData);

    }

    public void checkSavedAddressByOneItem(String alias, String firstName, String lastName, String address, String city, String zip, String phone, String country) {
        int listAddressTilesSize = listAddressTiles.size();
        String allAddressData = listAddressTiles.get(listAddressTilesSize - 1).getText();
        Assert.assertTrue(allAddressData.contains(alias));
        Assert.assertTrue(allAddressData.contains(firstName));
        Assert.assertTrue(allAddressData.contains(lastName));
        Assert.assertTrue(allAddressData.contains(address));
        Assert.assertTrue(allAddressData.contains(city));
        Assert.assertTrue(allAddressData.contains(zip));
        Assert.assertTrue(allAddressData.contains(phone));
        Assert.assertTrue(allAddressData.contains(country));
    }
}

