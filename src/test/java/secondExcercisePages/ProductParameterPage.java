package secondExcercisePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ProductParameterPage {
    private WebDriver driver;

    public ProductParameterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "group_1")
    private WebElement sizeOfProduct;

    @FindBy(id = "quantity_wanted")
    private WebElement productQuantity;

    @FindBy(css =".btn.btn-primary.add-to-cart")
    private WebElement addToBasket;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedCheckout;


    public void setProductSize(String size) {
        sizeOfProduct.click();
        sizeOfProduct.sendKeys(size);

    }

    public void setProductQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);


    }
    public void setAddToBasket() {
        addToBasket.click();
    }

    public void setProceedToCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceedToCheckout.click();
    }
    public void setProceedCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceedToCheckout.click();
    }
}