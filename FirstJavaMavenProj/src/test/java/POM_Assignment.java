import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_Assignment {

    ///////////////////////////////Business Steps//////////////////////////////////////////

        WebDriver driver;
        private final By googleSearchBar_textarea = By.xpath("//textarea[@id='APjFqb']");
        private final By FirstSearchResult_textgiza = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3/span");
        private final By FirstSearchResult_textselenuim = By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3/span");

         String googleHomePageUrl = "https://www.google.com/";

        @Test
        public void testSearchGiza() {
            GoogleSearch("Giza Systems");
            String FirstSearchResultText = driver.findElement(FirstSearchResult_textgiza).getText();
            Assert.assertTrue(getFirstSearchResultText().contains("Giza"));
        }

        @Test
        public void testSearchSelenium() {
            GoogleSearch("Selenium WebDriver");
            String FirstSearchResultText = driver.findElement(FirstSearchResult_textselenuim).getText();
            assertOnFirstSearchResult("WebDriver");
        }

        @BeforeMethod
        public void beforeMethod() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            NavigateToGoogleHomePage();
        }


        @AfterMethod
        public void afterMethod() {
            driver.quit();
        }


    public void GoogleSearch(String searchData) {
        driver.findElement(googleSearchBar_textarea).sendKeys(searchData, Keys.ENTER);
    }

    public String getFirstSearchResultText() {
        return driver.findElement(FirstSearchResult_textgiza).getText();
    }

    public void assertOnFirstSearchResult(String expectedResult) {
        String firstSearchResultText_F = driver.findElement(FirstSearchResult_textselenuim).getText();
        Assert.assertEquals(firstSearchResultText_F, expectedResult);
    }
    public void NavigateToGoogleHomePage() {
        driver.navigate().to(googleHomePageUrl);
    }

}
