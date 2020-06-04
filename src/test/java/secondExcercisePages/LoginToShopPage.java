package secondExcercisePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToShopPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement signInButton;

    @FindBy(name = "email")
    private WebElement loginInputElement;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement buttonClick;


    @FindBy(xpath = "//*[@id='_desktop_logo']")
    private WebElement myStoreButton;

    public LoginToShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String user, String password) {

        signInButton.click();
        loginInputElement.click();
        loginInputElement.clear();
        loginInputElement.sendKeys(user);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        buttonClick.click();

    }
    public void setMyStoreButton(){
        myStoreButton.click();
    }
    public String getLoggedUserName() {
        WebElement loggedUserName = driver.findElement(By.xpath("//a[@class='account']"));
        return loggedUserName.getText();
    }
}