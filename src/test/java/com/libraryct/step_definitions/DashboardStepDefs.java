package com.libraryct.step_definitions;

import com.libraryct.pages.BasePage;
import com.libraryct.pages.DashboardPage;
import com.libraryct.pages.LoginPage;
import com.libraryct.utilities.BrowserUtils;
import com.libraryct.utilities.ConfigurationReader;
import com.libraryct.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardStepDefs  {

    @When("user login as a {string}")
    public void user_login_as_a(String userType) {
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

    @Then("student see the following <modules>")
    public void student_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules = BrowserUtils.getElementsText(new DashboardPage().modules);
        Assert.assertEquals(expectedModules, actualModules);
        System.out.println("ExpectedModules = " + expectedModules);
        System.out.println("ActualModules = " + actualModules);



    }

    @Then("librarian see the following <modules>")
    public void librarian_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules = BrowserUtils.getElementsText(new DashboardPage().modules);
        Assert.assertEquals(expectedModules, actualModules);
        System.out.println("ExpectedModules = " + expectedModules);
        System.out.println("ActualModules = " + actualModules);
    }

    }

