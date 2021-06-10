package pl.coderslab.zadaniaDodatkowe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FiltrowanieTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?id_category=2&controller=category");
    }

    @Test
    public void testFiltrowania() {

        inputText(By.id("first-name"), "Marcin");
        inputText(By.id("last-name"), "Gaweł");
        clickElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]"));
        inputText(By.name("dob"), "11/30/1989");
        inputText(By.id("address"), "Prosta 51");
        inputText(By.id("email"), "Marcin@gawel.pl");
        inputText(By.id("password"), "Pass123");
        inputText(By.id("company"), "CodersLab");

        // Wybieranie jednej opcji z pola Select nie działa i jeszcze nie wiem dlaczego??
        Select role = new Select(driver.findElement(By.xpath("//*[@id='role']")));
        role.selectByVisibleText("QA");

        inputText(By.id("comment"), "To jest mój pierwszy test automatyczny");
        clickElement(By.id("submit"));
        clickElement(By.xpath("//*[@id=\"facet_24698\"]/li[1]/label/a"));
        List<WebElement> elementFilters = driver.findElements(By.cssSelector("section.facet:nth-child(8) input"));
        elementFilters.get(0).click();
        WebElement elementPrice = driver.findElement(By.xpath("//*[@id= 'products']/div[2]"));
        //String price = elementPrice.getText();
        //String substringPrice ="";
        // substringPrice = price.substring(8,11);
        System.out.println(elementPrice.getText());
    }

    private void inputText(By by, String text) {
        WebElement element = driver.findElement(by);
        if (element.isEnabled()) {
            element.click();
            element.clear();
            element.sendKeys(text);

            WebElement label = element.findElement(By.xpath("./../../label"));
            System.out.println(label.getText() + ":" + text);
        }
    }

    private void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    @After
    public void tearDown() {
        // driver.quit();
    }
}