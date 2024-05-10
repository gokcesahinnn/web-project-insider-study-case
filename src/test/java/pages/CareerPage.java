package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ResourceFileReader;

public class CareerPage extends BasePage {

    public CareerPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    private static ResourceFileReader fileReader = new ResourceFileReader();

    @FindBy(id = "career-find-our-calling")
    private WebElement teamsSection;

    @FindBy(css = ".category-title-media")
    private WebElement txtTeamsHeader;

    @FindBy(linkText = "See all teams")
    private WebElement btnSeeAllTeams;

    @FindBy(id = "career-our-location")
    private WebElement locationSection;

    @FindBy(css = ".category-title-media.ml-0")
    private WebElement txtLocationHeader;

    @FindBy(css = ".mx-auto.pl-0")
    private WebElement txtLocationParagraph;
    @FindBy(css = ".elementor-section.elementor-element-a8e7b90")
    private WebElement lifeAtInsiderSection;

    @FindBy(css = ".elementor-element.elementor-element-21cea83.elementor-widget.elementor-widget-heading")
    private WebElement txtLifeAtInsiderHeader;

    @FindBy(css = ".elementor-element.elementor-element-fe38935.elementor-widget")
    private WebElement txtLifeAtInsiderParagraph;

    @FindBy(xpath = "//h3[text()='Quality Assurance']")
    private WebElement btnQualityAssuranceTeam;

    public void verifyTeamsSection() {
        assertElementIsDisplayed(teamsSection);
        assertElementText(txtTeamsHeader, fileReader.getValidationsData("career_page", "teams_header_text"));
        assertElementIsDisplayed(btnSeeAllTeams);
    }

    public void verifyLocationsSection() {
        assertElementIsDisplayed(locationSection);
        assertElementText(txtLocationHeader, fileReader.getValidationsData("career_page", "location_header_text"));
        assertElementText(txtLocationParagraph, fileReader.getValidationsData("career_page", "location_paragraph_text"));
    }

    public void verifyLifeAtInsiderSection() {
        assertElementIsDisplayed(lifeAtInsiderSection);
        assertElementText(txtLifeAtInsiderHeader, fileReader.getValidationsData("career_page", "life_at_insider_header_text"));
        assertElementText(txtLifeAtInsiderParagraph, fileReader.getValidationsData("career_page", "life_at_insider_paragraph_text"));
    }

    public void clickSeeAllTeams() {
        clickElementWithJs(btnSeeAllTeams);
    }

    public void clickQaTeams() {
        verifyElementVisible(btnQualityAssuranceTeam);
        clickElementWithJs(btnQualityAssuranceTeam);
    }
}
