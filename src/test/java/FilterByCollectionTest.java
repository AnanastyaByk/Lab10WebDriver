import by.pageobject.pages.CatalogPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilterByCollectionTest {
    public static final String PRODUCT_COLLECTION_A = "easter";

    private static final WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @Test
    public void testCollectionFilter(){
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openPage()
                .getNeededFiltration(2)
                .clickOnCollection()
                .submitFiltration();

        String currentCollection = catalogPage.getCurrentCollection();

        Assert.assertTrue(currentCollection.contains(PRODUCT_COLLECTION_A));
    }

    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
