package com.libraryct.step_definitions;

import com.libraryct.pages.LoginPage;
import com.libraryct.pages.UsersPage;
import com.libraryct.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersStepDefs {
    @Given("the user login as a {string}")
    public void the_user_login_as_a(String userType) {
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
    }

    @When("the user navigates to {string}")
    public void the_user_navigates_to(String module) {
        if(module.equals("Users")){
            new UsersPage().usersModule.click();
        }
    }

    @Then("the user should be able to add a new user")
    public void the_user_should_be_able_to_add_a_new_user() {
        new UsersPage().addUser("Mike","Smith","MikeSmith@mikesmith.com","usa");
    }

    @Then("the user should be able to edit and close")
    public void the_user_should_be_able_to_edit_and_close() {
        new UsersPage().editAndClose();
    }
}
