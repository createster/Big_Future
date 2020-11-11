package com.libraryct.pages;

import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    @FindBy(xpath = "(//td)[5]")
    public WebElement actualCategoryOnTheList;


    @FindBy(xpath = "//span[@class='title']")
    public List<WebElement> modules;


    @FindBy(css = ".nav-link.dropdown-toggle")
    public WebElement dataToggle;

    @FindBy(css=".dropdown-item")
    public  WebElement logOut;

    public BasePage() { PageFactory.initElements(Driver.get(), this);}

    public void navigateTo(String tab) {
        String tabs="//span[contains(text(),'"+tab+"')]";
        try{
            BrowserUtils.waitForClickablility(By.xpath(tabs),5);
            WebElement tabElement=Driver.get().findElement(By.xpath(tabs));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).click().build().perform();
        } catch (Exception e){
            BrowserUtils.clickWithWait(By.xpath(tabs),5);
        }

    }


    public void logOut(){
   dataToggle.click();
   logOut.click();
    }


}
