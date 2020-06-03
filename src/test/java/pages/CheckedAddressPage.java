package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckedAddressPage {

    public CheckedAddressPage(WebDriver driver, WebElement successInfoField) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".alert.alert-success")
    private WebElement successInfoField;

    public String getSuccessMessage(){
    return successInfoField.getText();
}
}


