package com.libraryct.pages;

import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import com.libraryct.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "inputEmail")
    public WebElement userNameBox;

    @FindBy (id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "(//button[@type='submit'])")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Dashboard']")
    public  WebElement librarianTitle;

    @FindBy(xpath = "//*[text()='Book Management']")
    public WebElement studentTitle;



        public void login(String userNameStr, String passwordStr) {

            userNameBox.sendKeys(userNameStr);
            passwordBox.sendKeys(passwordStr);
            submitButton.click();
            // verification that we logged
        }
    }



