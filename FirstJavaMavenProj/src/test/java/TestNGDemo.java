import org.testng.annotations.*;

public class TestNGDemo {
    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("Before method to run before each test case");
    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("After method to run after each test case");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before method to run before the first test case in the class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after method to run after the last test case in the class");
    }

}
