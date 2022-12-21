import by.pageobject.pages.CatalogPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilterByPriceTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://www.lamoda.by/c/15/shoes-women/");
    }

    @Test
    public void testFilterByPrice() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String minPrice = "2000";
        int lol = 2000;

        javascriptExecutor.executeScript("window.scrollBy(0,500)");
        catalogPage.pause(catalogPage.getSortButtons())
                .clickPriceSortButton()
                .sendKeys(minPrice)
                .submit();
        Thread.sleep(2000);
        int res = catalogPage.currentUrl();
        Assert.assertEquals(res, lol);
    }

    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
