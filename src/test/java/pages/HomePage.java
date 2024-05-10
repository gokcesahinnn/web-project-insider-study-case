package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickMainMenu(String menuText) {
        WebElement menu = findElement(By.xpath(String.format("//a[@id='navbarDropdownMenuLink'][contains(text(), '%s')]", menuText)));
        clickElement(menu);
    }

    public void clickSubMenu(String submenu) {
        clickElementByLinkText(submenu);
    }
}
