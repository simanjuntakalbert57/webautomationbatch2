package com.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.webautomation.abstractcomponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
    WebDriver driver;   

    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(className = "hero-primary")
    WebElement confirmationPage;

    By elementHeroText = By.className("hero-primary");

    public String getConfirmationPage(){
        visibilityOfElementLocated(elementHeroText);
        return confirmationPage.getText();
    }
}
