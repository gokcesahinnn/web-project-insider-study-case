package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage(Hooks.getDriver());

    public HomeSteps() {
    }

    @When("select {string} main menu on homepage")
    public void selectMainMenu(String menu) {
        homePage.clickMainMenu(menu);
    }

    @And("select {string} submenu on homepage")
    public void selectSubmenu(String submenu) {
        homePage.clickSubMenu(submenu);
    }
}
