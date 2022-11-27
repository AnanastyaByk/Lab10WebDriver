package by.pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver webDriver;

    @FindBy(className = "_input_xf7ng_19")
    WebElement inputLine;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public HomePage enterKeys(String keys){
        inputLine.sendKeys(keys, Keys.ENTER);
        return this;
    }

}
