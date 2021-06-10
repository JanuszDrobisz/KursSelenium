package pl.coderslab.funkcje;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

public class FunctionTest {


    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void testFormularz() {
        WebElement elementLabelFirstName = driver.findElement(By.xpath("//label[@for='first-name']"));
        WebElement elementFirstName = driver.findElement(By.id("first-name"));
        if (elementFirstName.isEnabled()) {
            elementFirstName.clear();
            elementFirstName.sendKeys("Przypadek");
        } else {
            Assert.fail();
        }
        System.out.println(elementLabelFirstName.getText() + ":" + elementFirstName);

        WebElement elementLastName = driver.findElement(By.id("last-name"));
        if (elementLastName.isEnabled()) {
            elementLastName.clear();
            elementLastName.sendKeys("Testowy");
        } else {
            Assert.fail();
        }

        WebElement elementGender = driver.findElement(By.xpath("//input[@name='gender']"));
        if (elementGender.isEnabled()) {
            elementGender.click();
        } else {
            Assert.fail();
        }

        WebElement elementDateOfBirth = driver.findElement(By.id("dob"));
        if (elementDateOfBirth.isEnabled()) {
            elementDateOfBirth.clear();
            elementDateOfBirth.sendKeys("05/03/2021");
        } else {
            Assert.fail();
        }


        WebElement elementAddress = driver.findElement(By.id("address"));
        if (elementAddress.isEnabled()) {
            elementAddress.clear();
            elementAddress.sendKeys("Staroszewska 15");
        } else {
            Assert.fail();
        }

        WebElement elementEmail = driver.findElement(By.id("email"));
        if (elementEmail.isEnabled()) {
            elementEmail.clear();
            elementEmail.sendKeys("testowytestp@gmail.com");
        } else {
            Assert.fail();
        }

        WebElement elementPassword = driver.findElement(By.id("password"));
        if (elementPassword.isEnabled()) {
            elementPassword.clear();
            elementPassword.sendKeys("EuZ3Bi00sh!H2O2");
        } else {
            Assert.fail();
        }

        WebElement elementCompany = driver.findElement(By.id("company"));
        if (elementCompany.isEnabled()) {
            elementCompany.clear();
            elementCompany.sendKeys("Belzebub Sp. z o.o.");
        } else {
            Assert.fail();
        }


        WebElement elementComment = driver.findElement(By.id("comment"));
        if (elementComment.isEnabled()) {
            elementComment.clear();
            elementComment.sendKeys("jakiś sobie teścik i ciekaw jestem czy wywali się na polskich znakach");
        } else {
            Assert.fail();
        }

        WebElement elementSubmit = driver.findElement(By.id("submit"));
        if(elementSubmit.isEnabled()){
            elementSubmit.click();
        } else {
            Assert.fail();
        }

    }

    @After
    public void tearDown() {
        // driver.quit();
    }
}