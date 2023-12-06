import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTestNGDemo {

    WebDriver driver;
    private final By googleSearchBar_textarea = By.xpath("//textarea[@id='APjFqb']");
    private final By FirstSearchResult_textgiza = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3/span");
    private final By FirstSearchResult_textselenuim = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3/span");

    @Test
    public void testSearchGiza() {
        //driver.findElement(googleSearchBar_textarea).sendKeys(, Keys.ENTER);
        googleSearch("Giza Systems");
        //driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Giza Systems");
        String FirstSearchResultText = driver.findElement(FirstSearchResult_textgiza).getText();
        Assert.assertEquals(FirstSearchResultText, "Giza Systems");
        driver.findElement(FirstSearchResult_textgiza).click();
    }

    @Test
    public void testSearchSelenium() {
        //driver.findElement(googleSearchBar_textarea).sendKeys("Selenium WebDriver", Keys.ENTER);
        googleSearch("Selenium WebDriver");
        String FirstSearchResultText = driver.findElement(FirstSearchResult_textselenuim).getText();
        Assert.assertEquals(FirstSearchResultText, "WebDriver");
        //Assert.assertTrue(FirstSearchResultText.contains("Selenium"));
        driver.findElement(FirstSearchResult_textselenuim).click();

    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    public void googleSearch(String searchData) {
        driver.findElement(googleSearchBar_textarea).sendKeys(searchData, Keys.ENTER);
    }


}