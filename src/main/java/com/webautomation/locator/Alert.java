package com.webautomation.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/bytedance/CourseQAAutomation/Web Automation/chromedriver");
        WebDriver driver = new ChromeDriver();

        // driver.manage().window().setSize(new Dimension(390, 844));

        //setup link website
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("Albert");

        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());


        Thread.sleep(2000);
    }
}
