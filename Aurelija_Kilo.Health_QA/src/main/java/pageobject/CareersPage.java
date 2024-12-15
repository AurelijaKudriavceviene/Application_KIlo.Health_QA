
package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);}


    @FindBy(css = "div[class='cyan-button']")
    private WebElement seeOpenPositionsBtnElement;

    @FindBy(css = ".select2-selection--single")
    private WebElement allLocationsBtnElement;

    @FindBy(xpath = "//div[@class='positions']//a[not(@style='display: none;')]")
    private List<WebElement> jobElements;

    @FindBy(className = "position__title")
    private WebElement titleElement;

    public void seeOpenPositions() {
        seeOpenPositionsBtnElement.click();
        waitForVisibility(allLocationsBtnElement);
    }

    public void select(String title, String selector) {
        WebElement selectElement = driver.findElement(By.cssSelector("#" + selector));
        Select select = new Select(selectElement);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(title)) {
                option.click();
                break;
            }
        }
    }

    public boolean hasAJobTitle(String searchingTitle) {
        for (WebElement jobElement : jobElements) {
            String jobTitle = titleElement.getText();
            if (jobTitle.contains(searchingTitle)) {
                return true;
            }
        }
        return false;
    }
}