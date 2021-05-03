package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CountryPage;
import pages.Home;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private EventFiringWebDriver driver;
    protected CountryPage countryPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        goMain();
    }

    @BeforeMethod
    public void goMain(){
        driver.manage().deleteAllCookies();
        driver.get("https://www.bestbuy.com");
        countryPage = new CountryPage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}