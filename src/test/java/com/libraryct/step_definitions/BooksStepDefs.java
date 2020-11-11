package com.libraryct.step_definitions;

import com.libraryct.pages.BooksPage;
import com.libraryct.pages.DashboardPage;
import com.libraryct.pages.LoginPage;
import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BooksStepDefs {
    @Then("the user enters librarian credentials")
    public void the_user_enters_librarian_credentials() {

        String userName= ConfigurationReader.get("librarian_username");
        String password=ConfigurationReader.get("librarian_password");
        new LoginPage().login(userName,password);
    }

    @When("a librarian navigates to book records")
    public void a_librarian_navigates_to_book_records() {
        new DashboardPage().navigateTo("Users"); ;
      new BooksPage().showRecordsDropdown.click();

    }

    @Then("the librarian sees the followig options")
    public void the_librarian_sees_the_followig_options(List<String> expectedOptions) {
        Select select = new Select(new BooksPage().showRecordsDropdown);

        List<WebElement> recordOptions = select.getOptions();

        List<String> actualRecords = new ArrayList<>();

        for (WebElement recordOption : recordOptions) {
            actualRecords.add(recordOption.getText());
        }


        Assert.assertEquals(expectedOptions, actualRecords);
    }
}
