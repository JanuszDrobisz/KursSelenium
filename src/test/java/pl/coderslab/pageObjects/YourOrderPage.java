package pl.coderslab.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourOrderPage {
    private WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressesElement;

    @FindBy(xpath = "//input[@id = 'delivery_option_1']")
    private WebElement shoppingMethodElement;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmShoppingMethodElement;

    @FindBy(id = "payment-option-1")
    private WebElement paymentOptionRadioButton;

    @FindBy(xpath = "//input[contains(@name, 'conditions_to_approve')]")
    private WebElement approveTermsOfServiceCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Order with an obligation to pay')]")
    private WebElement orderButton;

    @FindBy(className = "account")
    private WebElement userAccount;

    public YourOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setConfirmAddresses(){
        confirmAddressesElement.click();
    }

    public void setShoppingMethod(){
        if (!shoppingMethodElement.isSelected()) {
            shoppingMethodElement.click();
        }
    }

    public void setConfirmShoppingMethod(){
        confirmShoppingMethodElement.click();
    }

    public void setPaymentOption(){
        paymentOptionRadioButton.click();
    }

    public void checkApproveTermsOfService(){
        approveTermsOfServiceCheckbox.click();
    }

    public void setOrderWithAnObligationToPay(){

        orderButton.click();
    }

    public void setUserAccount(){
        userAccount.click();
    }
}