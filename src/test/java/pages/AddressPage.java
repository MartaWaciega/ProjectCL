package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postCodeInput;

    @FindBy(name = "id_country")
    private WebElement roleDropCountry;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary.float-xs-right")
    private WebElement saveButton;

    public void setAliasInput(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

    }

    public void setAddress(String address) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

    }

    public void setCityInput(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setPostCodeInput(String postCode) {
        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);

    }

    public void roleDropCountry(String country) {
        Select drop = new Select(roleDropCountry);
        drop.selectByVisibleText(country);

    }

    public void setPhoneInput(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickSaveButton() {
        saveButton.click();

    }
        public String getAliasC() {
        return aliasInput.getText();
    }
        public String getAddress() {
        return addressInput.getText();
    }
        public String getCity() {
        return cityInput.getText();
    }
        public String getPostCode() {
        return postCodeInput.getText();
    }
        public String getCountry() {
        return roleDropCountry.getText();
    }
        public String getPhone() {
        return phoneInput.getText();
    }

}


