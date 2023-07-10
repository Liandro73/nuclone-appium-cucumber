package br.com.liandro.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NucloneStepsTest extends BaseSteps {

    public NucloneStepsTest() {
    }

    @Given("I am on the dashboard")
    public void iAmOnTheDashboard() {
        dashboardPageObject.checkThatCardBalanceIsDisplayed();
    }

    @When("I click on Show Balance button")
    public void iClickOnShowBalanceButton() {
        dashboardPageObject.clickOnBtnShowBalanceOnOff();
    }

    @Then("I should see in the balance the value {string}")
    public void iShouldSeeInTheBalanceTheValue(String value) {
        dashboardPageObject.checkTheValueOnBalance(value);
    }

}
