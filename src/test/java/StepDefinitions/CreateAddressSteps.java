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
import java.util.concurrent.TimeUnit;


public class CreateAddressSteps {
    private WebDriver driver;

    private LoginPage loginPage;
    private AddressPage addressPage;
    private YourAddressPage yourAddressPage;
    private String alias;
    private String city;
    private String postCode;
    private String country;
    private String phone;
    private String address;



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
        this.alias = alias;

        addressPage.setAddress(address);
        this.address = address;

        addressPage.setPostCodeInput(postCode);
        this.postCode = postCode;

        addressPage.setCityInput(city);
        this.city = city;

        addressPage.roleDropCountry(country);
        this.country = country;

        addressPage.setPhoneInput(phone);
        this.phone = phone;

        addressPage.clickSaveButton();


        addressPage.checkTiles();
        String acctualText = addressPage.getCheckTiles();
        Assert.assertTrue(acctualText.contains("Arrya Stark"));
        Assert.assertTrue(acctualText.contains(this.alias));


        addressPage.setUpdateButton();
    }

    @Then("^User check field$")
    public void userCheckField() {
        AddressPage addressPage = new AddressPage(driver);

        Assert.assertEquals(this.alias, addressPage.getAlias());
        System.out.println("Alias field pass");
        Assert.assertEquals(this.address, addressPage.getAddress());
        System.out.println("Address field pass");
        Assert.assertEquals(this.postCode, addressPage.getPostCode());
        System.out.println("Post Code field pass");
        Assert.assertEquals(this.city, addressPage.getCity());
        System.out.println("City field pass");
        Assert.assertEquals(this.country, addressPage.getCountry());
        System.out.println("Country field pass");
        Assert.assertEquals(this.phone, addressPage.getPhone());



    }
}









