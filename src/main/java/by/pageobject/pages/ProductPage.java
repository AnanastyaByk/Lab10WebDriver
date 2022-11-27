package by.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver webDriver;

    @FindBy(className = "x-product-card-description__product-name")
    WebElement productName;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String findTextName(){
        return productName.getText();
    }

    public WebElement getProductName() {
        return productName;
    }

    public ProductPage pause(WebElement webElement){
        new WebDriverWait(webDriver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }

}
