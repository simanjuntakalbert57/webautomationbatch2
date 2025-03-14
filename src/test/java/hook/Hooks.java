package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.webautomation.pageobjects.LandingPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;
    
    // setup driver
    @Before
    public void setupAutomation() throws IOException{
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/bytedance/CourseQAAutomation/Web Automation/webautomationbatch2/src/main/resources/GlobalData.properties");

        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            // Driver chrome
            System.setProperty("webdriver.chrome.driver", "/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
            driver = new ChromeDriver();
        }else{
            // Driver firefox
            System.setProperty("webdriver.gecko.driver", "/Users/bytedance/CourseQAAutomation/Web Automation/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("ini adaldah driver1" + driver);
    }

    // close driver
    @After
    public void tearDownAutomation(){
        if (driver != null) {
            driver.close();
        }
    }

    public static WebDriver initializeDriver(){
        System.out.println("ini adaldah driver" + driver);
        return driver;
    }
}
