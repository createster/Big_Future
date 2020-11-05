package com.libraryct.step_definitions;

import com.libraryct.pages.BasePage;
import com.libraryct.pages.LoginPage;
import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.libraryct.utilities.Driver;
import org.junit.Assert;

public class LoginStepsDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");

        Driver.get().get(url);
    }

    @When("the user enter {string} credentials")
    public void the_user_enter_credentials(String userType)  throws InterruptedException {
        String userName;
        String password;

        if(userType.equals("student")){
            userName=ConfigurationReader.get("student_username");
            password=ConfigurationReader.get("student_password");

        }else {
            userName=ConfigurationReader.get("librarian_username");
            password=ConfigurationReader.get("librarian_password");
        }

        new LoginPage().login(userName,password);
    }
    @Then("the user on {string}")
    public void the_user_on(String page)  throws InterruptedException {
        String expectedTitle;
        String actualTitle;

          if(page.equals("bookspage")){
              expectedTitle="Book Management";
              actualTitle=new LoginPage().studentTitle.getText();
          }else{
              expectedTitle="Dashboard";
              actualTitle=new LoginPage().librarianTitle.getText();
          }

          Assert.assertEquals(expectedTitle,actualTitle);

    }
    @Given("student succesfully logged in")
    public void student_succesfully_logged_in() {
        String userName=ConfigurationReader.get("student_username");
        String password=ConfigurationReader.get("student_password");
        new LoginPage().login(userName,password);
    }

    @When("the users click logout")
    public void the_users_click_logout() {
        new LoginPage().logOut();
    }

    @Then("the user logs out from the account")
    public void the_user_logs_out_from_the_account() {
        String ActualTitle=Driver.get().getTitle();
        Assert.assertEquals("Login - Library",ActualTitle);

    }

    @Given("librarian succesfully logged in")
    public void librarian_succesfully_logged_in() {
        String userName=ConfigurationReader.get("librarian_username");
        String password=ConfigurationReader.get("librarian_password");
        new LoginPage().login(userName,password);
    }
}
