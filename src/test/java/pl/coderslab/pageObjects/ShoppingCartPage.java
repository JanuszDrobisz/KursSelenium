package pl.coderslab.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutButton;

    @FindBy(className = "regular-price")
    private WebElement regularPriceElement;

    @FindBy(xpath = "//*[@class='current-price']/*[@class='price']")
    private WebElement currentPriceElement;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }

    public void checkDiscount(){
        double regularPrice = Double.parseDouble(regularPriceElement.getText().substring(1, 6));
        double currentPrice = Double.parseDouble(currentPriceElement.getText().substring(1, 6));
        double calculatedPrice = regularPrice * 0.8;

        Assert.assertEquals(calculatedPrice, currentPrice, .2);

    }

}