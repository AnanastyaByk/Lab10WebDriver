import by.pageobject.pages.HomePage;
import by.pageobject.pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindProductByFullNameTest {

    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void initWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.lamoda.by/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testFindProductByName(){
        String inputLine = "adidas by Stella McCartney";
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.enterKeys(inputLine);
        String name = productPage.pause(productPage.getProductName()).findTextName();
        Assert.assertEquals(inputLine, name);
    }

    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
