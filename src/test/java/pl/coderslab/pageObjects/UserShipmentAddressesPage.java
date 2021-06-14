package pl.coderslab.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
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
}

