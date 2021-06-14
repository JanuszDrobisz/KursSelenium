package pl.coderslab.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
    private WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement sizeDropdown;

    @FindBy(name = "qty")
    private WebElement quantityElement;

    @FindBy(xpath = "//div[@class='add']/button")
    private WebElement addButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckoutModal;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSize(String size) {
        Select selectSize = new Select(sizeDropdown);
        selectSize.selectByVisibleText(size);
    }

    public void setQuantity(String quantity) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quantityElement.clear();
        quantityElement.sendKeys(quantity);

    }

    public void clickAddButton() {
        addButton.click();
    }

    public void setProceedToCheckout() {
        proceedToCheckoutModal.click();
    }
}