package components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException{
        /*
         * Check global.properties and get brower
         * if (browser == "chrome"){
         *      driver = chrome;
         * }else if(browser == "firefox") {
         *      driver = firefox;
         * }else{
         *      driver = edge
         * }
         */

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/bytedance/CourseQAAutomation/Web Automation/webautomationbatch2/src/main/resources/GlobalData.properties");

        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        System.out.println("browserName" + browserName);

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
        return driver;
    }
}
