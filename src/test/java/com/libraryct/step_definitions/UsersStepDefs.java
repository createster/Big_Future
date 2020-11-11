package com.libraryct.step_definitions;

import com.libraryct.pages.DashboardPage;
import com.libraryct.pages.LoginPage;
import com.libraryct.pages.UsersPage;
import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import com.libraryct.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersStepDefs extends DashboardPage {
    @Given("the user login as a {string}")
    public void the_user_login_as_a(String userType) {

        Driver.get().get(ConfigurationReader.get("url"));
        String userName;
        String password;

        if(userType.equals("student")){
            userName= ConfigurationReader.get("student_username");
            password=ConfigurationReader.get("student_password");

        }else {
            userName=ConfigurationReader.get("librarian_username");
            password=ConfigurationReader.get("librarian_password");
        }

        new LoginPage().login(userName,password);
        BrowserUtils.waitFor(3);
    }

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String module) {
        BrowserUtils.waitFor(3);
        if(module.equals("Users")){
           new DashboardPage().navigateTo("Users"); ;

        }
    }


    @Then("the user should be able to add a new user")
    public void the_user_should_be_able_to_add_a_new_user() {
        BrowserUtils.waitFor(3);
        new UsersPage().addUser("Mike","Smith","MikeSmith3@mikesmith.com","usa");
    }

    @Then("the user should be able to edit and close")
    public void the_user_should_be_able_to_edit_and_close() {
        BrowserUtils.waitFor(3);
        new UsersPage().editAndClose();
    }
}
