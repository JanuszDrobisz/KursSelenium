package pl.coderslab.testZKursu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.coderslab.funkcje.LoginSetUp;
import pl.coderslab.pageObjects.LoginPage;

public class LoginTest {
    public static WebDriver driver;

    @Before
    public void testSetUp() {
     //   LoginSetUp loginSetUp = new LoginSetUp(driver);
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

// Stary kod, ktory powtarzalismy i probowalem zzamienic to na funkcje
//

//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
//    }


    @Test
    public void loginPageData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("GaryPBowyer@rhyta.com", "ethub0Oy6f");
        Assert.assertEquals("Jan Testowy", loginPage.getLoggedUsername());
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
