import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.CareersPage;
import pageobject.HomePage;

public class SearchingQAPositionTest extends  BaseTest {

    @Test
    void findingQAPosition() {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);

        String searchingTitle = "Junior Quality Assurance";

        homePage.goToCareersPage();
        careersPage.seeOpenPositions();
        careersPage.select("Vilnius", "city");
        careersPage.select("tech", "department");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        boolean isThereJuniorQAPosition = careersPage.hasAJobTitle(searchingTitle);
        Assertions.assertTrue(isThereJuniorQAPosition, "So sad, there are no junior QA positions at the moment");
    }
}
