package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.PageHelper;
import java.util.List;


public class OpenPositionsPage extends BasePage {

    public OpenPositionsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "select2-filter-by-location-container")
    private WebElement btnFilterLocation;

    @FindBy(id = "select2-filter-by-department-container")
    private WebElement btnFilterDepartment;

    @FindBy(id = "career-position-filter")
    private WebElement filterSection;

    @FindBy(xpath = "//li[contains(@id, 'All')]")
    private WebElement txtSelectedAllFilter;

    @FindBy(id = "jobs-list")
    private WebElement jobsList;

    @FindAll(@FindBy(css = ".position-list-item-wrapper > .btn-navy"))
    private static List<WebElement> btnViewRole;

    @FindAll(@FindBy(css = ".position-list-item.col-12.col-lg-4"))
    private static List<WebElement> txtAllJobDepartmentName;

    @FindAll(@FindBy(css = ".position-location"))
    private static List<WebElement> txtAllJobLocation;

    public void filterJobsByLocation(String location) {
        waitForElementToBeClickable(btnFilterLocation);
        verifyElementVisible(filterSection);
        wait(1);
        clickElement(btnFilterLocation);
        verifyElementVisible(txtSelectedAllFilter);
        WebElement element = findElement(By.xpath(String.format("//li[contains(@id, '%s')]", location)));
        clickElement(element);
        assertElementTextContains(btnFilterLocation, location);
    }

    public void filterJobsByDepartment(String department) {
        btnFilterDepartment.click();
        WebElement element = findElement(By.xpath(String.format("//li[contains(@id, '%s')]", department)));
        clickElement(element);
        assertElementTextContains(btnFilterDepartment, department);
    }

    public void verifyExistsJobList() {
        assertElementIsDisplayed(jobsList);
    }

    public void verifyJobDepartment() {
        verifyElementVisible(jobsList);
        scrollToElement(jobsList);
        wait(1);
        for (int i = 0; i < txtAllJobDepartmentName.size(); i++) {
            WebElement el = txtAllJobDepartmentName.get(i);
            String jobDepartmentName = el.getText();
            System.out.println("jobDepartmentName:" + jobDepartmentName);
            Assert.assertTrue(jobDepartmentName.contains("Quality Assurance"));
        }
    }

    public void verifyJobLocation() {
        verifyElementVisible(jobsList);
        for (WebElement el : txtAllJobLocation) {
            String jobDepartmentLocation = el.getText();
            Assert.assertTrue(jobDepartmentLocation.contains("Istanbul, Turkey"));
        }
    }

    public void clickRandomViewRoleButton() {
        WebElement rndElement = getRandomItemFromList(btnViewRole);
        clickElementWithJs(rndElement);
    }
}