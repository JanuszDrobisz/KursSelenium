package pl.coderslab.pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(name = "s")
    private WebElement searchBarInput;

    @FindBy(xpath = "//div[@class='products row']/article//a")
    private WebElement productTile;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearchBar(String searchItem) {
        searchBarInput.sendKeys(searchItem);
        searchBarInput.sendKeys(Keys.ENTER);
    }

    public void getProduct() {
        productTile.click();
    }
}

