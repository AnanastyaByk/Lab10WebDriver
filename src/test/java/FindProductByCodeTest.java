import by.pageobject.pages.CatalogPage;
import by.pageobject.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

public class FindProductByCodeTest {
    public static final String PRODUCT_CODE = "53365";

    private static final WebDriver driver = new ChromeDriver();
    
    @BeforeTest
    public void initWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testFindProductByCode(){
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        homePage.openPage()
                .openSearchingPanel()
                .searchForProduct();

        String nameOfFirstProduct = catalogPage.getNameOfFirstProduct();
        Pattern pattern = Pattern.compile("[0-9]{5}");
        Matcher matcher = pattern.matcher(nameOfFirstProduct);
        String resultOfSorting = matcher.find() ? matcher.group() : "";
        assertThat(resultOfSorting, startsWith(PRODUCT_CODE));
    }

    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
