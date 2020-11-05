package com.libraryct.pages;

import com.libraryct.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy (css = ".navbar-toggler-icon")
    public WebElement navbar;

    @FindBy(css = ".nav-link.dropdown-toggle")
    public WebElement dataToggle;

    @FindBy(css=".dropdown-item")
    public  WebElement logOut;

    public void logOut(){
   dataToggle.click();
   logOut.click();
    }


}
