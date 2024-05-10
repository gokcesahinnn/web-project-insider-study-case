package stepDefinitions;

import io.cucumber.java.en.And;
import pages.QualityAssurancePage;

public class QualityAssuranceSteps {

    QualityAssurancePage qaPage = new QualityAssurancePage(Hooks.getDriver());

    @And("click see all qa jobs button on qa page")
    public void clickSeeAllQaJobsButton() {
        qaPage.clickSeeAllQaJobsButton();
    }
}
