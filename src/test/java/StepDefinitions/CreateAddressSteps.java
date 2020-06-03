package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.AddressPage;
import pages.YourAddressPage;
import pages.CheckedAddressPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class CreateAddressSteps {
    private WebDriver driver;

    private LoginPage loginPage;
    private AddressPage addressPage;
    private YourAddressPage yourAddressPage;
    private CheckedAddressPage checkedAddressPage;


    @Given("^User is logged in to the shop$")
    public void userIsLoggedInToTheShop() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
        loginPage = new LoginPage(driver);
        loginPage.loginAs("arrya.stark@gmail.com", "123@321");

    }

    @When("^User goes to NewAddressPage$")
    public void userGoesToNewAddressPage() {

        YourAddressPage yourAddressPage = new YourAddressPage(driver);
        yourAddressPage.clickCreateAddressButton();

    }

    @And("^User enter (.*), (.*), (.*), (.*), (.*), (.*) on your account page$")
    public void userEnterAliasAddressCityPostCodeCountryPhoneOnYourAccountPage(String alias, String address, String city, String postCode, String country, String phone) {
        AddressPage addressPage = new AddressPage(driver);

        addressPage.setAliasInput(alias);
        addressPage.setAddress(address);
        addressPage.setPostCodeInput(postCode);
        addressPage.setCityInput(city);
        addressPage.roleDropCountry(country);
        addressPage.setPhoneInput(phone);


        Assert.assertEquals("Arya",addressPage.getAddress());
        Assert.assertEquals("Zamkowa 3",addressPage.getAddress());
        Assert.assertEquals("99-999", addressPage.getPostCode());
        Assert.assertEquals("Winterfell",addressPage.getCity());
        Assert.assertEquals("United Kingdom",addressPage.getCountry());
        Assert.assertEquals("+66661661661",addressPage.getPhone());



        addressPage.clickSaveButton();
    }

    @Then("^User can see \"([^\"]*)\" information$")
    public void userCanSeeInformation(String expectedMessage) {
        String successMessage = checkedAddressPage.getSuccessMessage();
        Assert.assertEquals(expectedMessage,successMessage);

    }
}





