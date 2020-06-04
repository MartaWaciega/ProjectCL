package secondExcercisePages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPage {

    private WebDriver driver;

    public BuyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//article")
    private WebElement checkAddress;

    @FindBy(name = "confirm-addresses")
    private WebElement clickButton;

    @FindBy(id = "delivery_option_1")
    private WebElement checkPrestaShop;

    @FindBy(xpath = "//*[@id='js-delivery']/button")
    private WebElement clickShippingMetod;

    @FindBy(id = "payment-option-1")
    private WebElement clickPayByCheck;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeButton;

    @FindBy(xpath = "//*[@id='payment-confirmation']/div[1]/button")
    private WebElement obligationPay;


    public void setCheckAddress() {
        System.out.println(checkAddress.getText());
        String actualtext = checkAddress.getText();
        Assert.assertTrue(actualtext.contains("Zamkowa 3 e"));
        System.out.println("Address confirmation corected");

    }

    public void setButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickButton.click();
    }

    public void setClickShippingMetod() {
        clickShippingMetod.click();
    }

    public void setClickPayByCheck() {
        clickPayByCheck.click();
    }

    public void setAgreeButton() {
        agreeButton.click();
    }

    public void setObligationPay() {
        obligationPay.click();
    }

}

