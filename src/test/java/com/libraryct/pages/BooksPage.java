package com.libraryct.pages;

import com.libraryct.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksPage extends BasePage {
    @FindBy(css = "#book_categories")
    public WebElement bookCategoriesDropdown;

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropdown;


    @FindBy(xpath = "//th")
    public List<WebElement> tableColumnNames;



    public BooksPage(){
        PageFactory.initElements(Driver.get(), this);
    }
}
