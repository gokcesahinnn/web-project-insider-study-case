package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OpenPositionsPage;

public class OpenPositionsSteps {

    OpenPositionsPage openPositionsPage = new OpenPositionsPage(Hooks.getDriver());
    @And("select {string} as location and {string} as department on open positions page")
    public void selectAsLocationAndAsDepartment(String location, String department) {
        openPositionsPage.filterJobsByLocation(location);
        openPositionsPage.filterJobsByDepartment(department);
    }

    @Then("verify exists of jobs list on open positions page")
    public void verifyPresenceOfJobsList() {
        openPositionsPage.verifyExistsJobList();
        openPositionsPage.verifyJobDepartment();
        openPositionsPage.verifyJobLocation();
    }

    @When("click random view role button on open positions page")
    public void clickRandomViewRoleButton() {
        openPositionsPage.clickRandomViewRoleButton();
    }
}
