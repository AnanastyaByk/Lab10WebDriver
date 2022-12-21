package by.pageobject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CatalogPage extends AbstractPage{
    public static final String CATALOG_PAGE_URL = "https://dihome.by/catalog/vannaya/aromaty/aromaticheskie-svechi/";

    @FindBy(className = "catalog-smart-filter-item")
    List<WebElement> filterBlock;

    @FindBy(xpath = "//*[@id=\"i-19-bitrix-catalog-smart-filter-vertical-2-KZ7kpsh6etqY\"]/div/div[2]/div/form/div[1]/div[3]/div[3]/div/div/div[4]/label")
    WebElement chosenCollection;

    @FindBy(id = "bx_3966226736_i-22-bitrix-catalog-section-catalog-tile-2-OQ3k9PHlVICg_10130")
    WebElement elementFilteredByCollection;

    @FindBy(className = "catalog-smart-filter-popup-link")
    WebElement submitFiltration;

    @FindBy(className = "catalog-section-item-base")
    WebElement firstProductInCatalog;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogPage openPage() {
        driver.get(CATALOG_PAGE_URL);
        return this;
    }

    public CatalogPage clickOnCollection() {
        wait.until(ExpectedConditions.elementToBeClickable(chosenCollection));
        chosenCollection.click();
        return this;
    }

    public CatalogPage getNeededFiltration(int i) {
        filterBlock.get(i).click();
        return this;
    }

    public void submitFiltration() {
        wait.until(ExpectedConditions.elementToBeClickable(submitFiltration)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elementFilteredByCollection));
    }

    public String getCurrentCollection() {
        return driver.getCurrentUrl();
    }

    public String getNameOfFirstProduct() {
        return showFirstProductTitle().getText();
    }

    private WebElement showFirstProductTitle() {
        return firstProductInCatalog.findElement(By.className("catalog-section-item-name"));
    }
}
