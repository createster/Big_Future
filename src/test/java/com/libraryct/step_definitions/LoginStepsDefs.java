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
        BrowserUtils.waitFor(3);
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
        String url;
        if(page.equalsIgnoreCase("dashboard")){
            url="http://library2.cybertekschool.com/#dashboard";
        }else{
            url="http://library2.cybertekschool.com/#books";
        }
        String ActualUrl= Driver.get().getCurrentUrl();
        Assert.assertEquals(url,ActualUrl);
    }


}
