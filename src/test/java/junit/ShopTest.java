package junit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import secondExcercisePages.BuyPage;
import secondExcercisePages.LoginToShopPage;
import secondExcercisePages.ProductParameterPage;
import secondExcercisePages.ShoppingPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ShopTest {
    private static WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?");
    }

    @Test
    public void loginTest() {
        LoginToShopPage loginPage = new LoginToShopPage(this.driver);
        ShoppingPage shoppingPage = new ShoppingPage(this.driver);
        ProductParameterPage productParameterPage = new ProductParameterPage(this.driver);
        BuyPage buyPage = new BuyPage(this.driver);

        loginPage.loginAs("arrya.stark@gmail.com", "123@321");
        Assert.assertEquals("Arrya Stark", loginPage.getLoggedUserName());
        System.out.println("Poprawne logowanie dla użytkownika Arrya Stark");


        loginPage.setMyStoreButton();

        shoppingPage.setClickSearch("Sweater");
        shoppingPage.setClickLoop();
        shoppingPage.setSetSweater();


        productParameterPage.setProductQuantity("5");
        productParameterPage.setProductSize("M");
        productParameterPage.setAddToBasket();
        productParameterPage.setProceedToCheckout();
        productParameterPage.setProceedCheckout();


        buyPage.setCheckAddress();
        buyPage.setButton();
        buyPage.setClickShippingMetod();
        buyPage.setClickPayByCheck();
        buyPage.setAgreeButton();
        buyPage.setObligationPay();


        File screenshotConfirmated = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotConfirmated, new File("/home/marta/Obrazy/seenshot.png"));
        } catch (Exception e) {
            System.out.println("Plik nie został zapisany na dysku.");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
