import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AutomationExerciseTask {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationexercise.com");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    }

    @Test
    public void OpenHomePage() {
        String VerifyPageVisible = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/h2")).getText();
        Assert.assertEquals(VerifyPageVisible, "CATEGORY");
        driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }
    @Test
    public void SighUpUser() {
        String VerifyNewUserVisible = driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/h2")).getText();
        Assert.assertEquals(VerifyNewUserVisible, "New User Signup!");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Heba");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("haheebahegazyqy@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
    }
    @Test
    public void NewUserInfo() {
        String VerifyEnterAccountInformation = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b")).getText();
        Assert.assertEquals(VerifyEnterAccountInformation, "ENTER ACCOUNT INFORMATION");
        driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@ssw0rd");
        driver.findElement(By.xpath("//*[@id=\"uniform-days\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"days\"]/option[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"uniform-years\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[24]")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Heba");
        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Abdelaziz");
        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("N/A");
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Ay haga");
        driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("Ay hagaaaa");
        driver.findElement(By.xpath("//*[@id=\"country\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"country\"]/option[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("state");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("nasr city");
        driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("12548");
        driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("010121251");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
    }
    @Test
    public void UserCreateSuccessfully() {
        String VerifyAccountCreateVisible = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2")).getText();
        Assert.assertEquals(VerifyAccountCreateVisible, "ACCOUNT CREATED!");

    }

    @AfterClass
    public void afterClass(){
          driver.quit();
    }
}
