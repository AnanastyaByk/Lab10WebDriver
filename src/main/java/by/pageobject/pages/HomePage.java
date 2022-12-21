package by.pageobject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage{
    public static final String HOME_PAGE = "https://dihome.by/kollektsionnye-linii/";
    public static final String PRODUCT_CODE = "53365";

    @FindBy(id = "i-6-bitrix-search-title-popup-1-XdqEv16rajmu")
    WebElement searchButton;

    @FindBy(id = "-desktop-popup-1")
    WebElement searchLine;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.navigate().to(HOME_PAGE);
        return this;
    }

    public HomePage openSearchingPanel(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return this;
    }

    public void searchForProduct(){
        searchLine.sendKeys(PRODUCT_CODE, Keys.ENTER);
    }
}
