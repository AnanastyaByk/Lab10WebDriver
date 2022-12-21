package by.pageobject.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CatalogPage {
    WebDriver webDriver;

    @FindBy(className = "v-popper-target")
    List<WebElement> sortButtons;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div[2]/div[2]/div[1]/div/div/div/div[14]/div[2]/div[1]/div/div/div/div[2]/button")
    WebElement submitButton;

    @FindBy(name = "minRange")
    WebElement inputMinPrice;

    public CatalogPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public CatalogPage clickPriceSortButton() {
        for (var i : sortButtons) {
            if (i.getText().equals("Цена")) {
                Actions actions = new Actions(webDriver);
                actions.moveToElement(i).click().build().perform();
                break;
            }
        }
        return this;
    }

    public CatalogPage sendKeys(String keys) {
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(inputMinPrice));
        inputMinPrice.sendKeys(keys);
        return this;
    }

    public CatalogPage submit() {
        submitButton.click();
        return this;
    }

    public int currentUrl() {
        String url = webDriver.getCurrentUrl().replaceAll("\\D", "").substring(2, 6);
        return Integer.parseInt(url);
    }

    public CatalogPage pause(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }

    public CatalogPage visibility(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOf(webElement));
        return this;
    }

    public WebElement getSortButtons() {
        return sortButtons.stream().findFirst().orElseThrow(() -> new RuntimeException("lol"));
    }

    public WebElement getInputMinPrice() {
        return inputMinPrice;
    }
}
