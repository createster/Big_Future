package com.libraryct.pages;

import com.libraryct.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasePage {

    @FindBy(css = "#book_categories")
    public WebElement categoriesDropdown;

    @FindBy(xpath = "//*[@type='search']")
    public WebElement searchButton;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> tableColumns;

    @FindBy(css = "[id='navbarDropdown']")
    public WebElement profileName;

    @FindBy(xpath = "//ul[@class='navbar-nav mr-auto']//li")
    public List<WebElement> modules;

    @FindBy(xpath = "//span[contains(text(),'Dashboard')]")
    public WebElement dashboardModule;

    @FindBy(xpath = "//span[contains(text(),'Users')]")
    public WebElement usersModule;

    @FindBy(xpath = "//span[contains(text(),'Books')]")
    public WebElement booksModule;

    @FindBy(css = ".nav-link.dropdown-toggle")
    public WebElement dataToggle;

    @FindBy(css=".dropdown-item")
    public  WebElement logOut;



    public void logOut(){
   dataToggle.click();
   logOut.click();
    }


}
