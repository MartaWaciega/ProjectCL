package secondExcercisePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ShoppingPage {

    private WebDriver driver;

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "s")
    private WebElement clickSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clickLoup;

    @FindBy(xpath = "//*[@id='js-product-list']/div[1]/article/div/a/img")
    private WebElement setSweter;



    public void setClickSearch(String productSearch) {
        clickSearch.click();
        clickSearch.sendKeys(productSearch);
    }

    public void setClickLoop() {
        clickLoup.click();
    }

    public void setSetSweater() {
        setSweter.click();
    }

}




