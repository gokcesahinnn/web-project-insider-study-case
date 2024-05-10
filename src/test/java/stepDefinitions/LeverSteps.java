package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.LeverPage;

public class LeverSteps {

    LeverPage leverPage = new LeverPage(Hooks.getDriver());

    @Then("verify that the job application page is open")
    public void verifyThatTheJobApplicationPageIsOpen() {
        leverPage.verifyOpenJobApplyPage();
    }
}
