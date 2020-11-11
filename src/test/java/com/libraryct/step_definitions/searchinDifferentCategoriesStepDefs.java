package com.libraryct.step_definitions;

import com.libraryct.pages.BasePage;
import com.libraryct.pages.BooksPage;
import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class searchinDifferentCategoriesStepDefs {


    @Then("the user should see the books from related category")
    public void the_user_should_see_the_books_from_related_category() {
        Select select = new Select(new BooksPage().bookCategoriesDropdown);

        List<WebElement> recordOptions = select.getOptions();


        for (int i = 1; i < recordOptions.size(); i++) {
            recordOptions.get(i).click();
            BrowserUtils.waitFor(1);
            Assert.assertEquals(recordOptions.get(i).getText(), new BasePage().actualCategoryOnTheList.getText());
        }
    }
}
