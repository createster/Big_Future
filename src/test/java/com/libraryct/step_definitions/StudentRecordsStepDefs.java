package com.libraryct.step_definitions;

import com.libraryct.pages.BooksPage;
import com.libraryct.pages.LoginPage;
import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class StudentRecordsStepDefs {
    @When("the user enters student credentials")
    public void the_user_enters_student_credentials() {
        String userName= ConfigurationReader.get("student_username");
        String password=ConfigurationReader.get("student_password");
        new LoginPage().login(userName,password);
    }

    @Then("table should have following column names")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
        BrowserUtils.waitFor(2);
        List<String>actualMenuOptions=BrowserUtils.getElementsText(new BooksPage().tableColumnNames);
        Assert.assertEquals(expectedColumnNames,actualMenuOptions);
    }
}
