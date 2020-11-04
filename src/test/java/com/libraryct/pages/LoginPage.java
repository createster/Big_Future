package com.libraryct.pages;

import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import com.libraryct.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (css = "#inputEmail")
    public WebElement userNameBox;

    @FindBy (css = "#inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "(//button[@type='submit'])")
    public WebElement submitButton;



        public void login(String userNameStr, String passwordStr) {
            BrowserUtils.waitFor(10);

            userNameBox.sendKeys(userNameStr);
            passwordBox.sendKeys(passwordStr);
            submitButton.click();
            // verification that we logged
        }
    }



