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

    @Then("the user sees {string}")
    public void the_user_sees(List<String> module) {
        List<String> actualModules = BrowserUtils.getElementsText(new DashboardPage().modules);
        for (int i = 0; i < module.size(); i++) {
            Assert.assertEquals(module.get(i), actualModules.get(i));
        }
    }
}
