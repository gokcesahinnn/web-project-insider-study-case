package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageHelper;

public class LeverPage extends BasePage {

    @FindBy(xpath = "(//a[@class='postings-btn template-btn-submit shamrock'])[1]")
    private WebElement btnApplyJob;

    public LeverPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void verifyOpenJobApplyPage() {
        switchLastTab();
        assertElementIsDisplayed(btnApplyJob);
        assertUrlContains("https://jobs.lever.co/useinsider");
        closeTab();
        switchToMainTab();
    }
}
