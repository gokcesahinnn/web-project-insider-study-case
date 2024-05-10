package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CareerPage;

public class CareerSteps {

    CareerPage careerPage = new CareerPage(Hooks.getDriver());

    @And("verify that teams, locations and life at insider section on careers page")
    public void verifyTeamsLocationsLifeAtInsiderSection() {
        careerPage.verifyTeamsSection();
        careerPage.verifyLocationsSection();
        careerPage.verifyLifeAtInsiderSection();
    }

    @When("click see all teams button on career page")
    public void clickSeeAllTeamsButton() {
        careerPage.clickSeeAllTeams();
    }

    @And("click quality assurance team on career page")
    public void clickQualityAssuranceTeam() {
        careerPage.clickQaTeams();
    }
}
