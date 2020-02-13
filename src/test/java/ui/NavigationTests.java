package ui;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getDriver;
import static ui.Driver.setCookies;
import static ui.MainPage.ExerciseLists.*;

public class NavigationTests extends InitTest {

    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        setCookies(driver);

        mainPage = new MainPage(driver);
        exercisePage = new ExercisePage(driver);
    }

    @AfterClass
    public void afterClass() {
        Driver.waitPage(1000);
        driver.quit();
    }

    @Test
    public void checkExGroupNavigation() {
        mainPage.checkNavigationListItems(getValues());
        mainPage.checkNavigationToEach(VERBAL.value);
        mainPage.checkNavigationToEach(NON_VERBAL.value);
    }
}
