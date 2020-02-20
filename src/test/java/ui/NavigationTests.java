package ui;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getDriver;
import static ui.Driver.setCookies;
import static ui.ExercisePage.NavigationMenu.РАСПОЗНАВАНИЕ_СЛОВ;
import static ui.ExercisePage.NavigationMenu.РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ;
import static ui.MainPage.ExerciseLists.*;

public class NavigationTests extends InitTest {

    MainPage mainPage;
    ExercisePage exercisePage;
    TasksPage tasksPage;
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeClass() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
        setCookies(driver);

        mainPage = new MainPage(driver);
        exercisePage = new ExercisePage(driver);
        tasksPage = new TasksPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void checkExGroupNavigation() {
        mainPage.checkNavigationListItems(getValues());
        mainPage.checkNavigationToEach(VERBAL.value);
        mainPage.checkNavigationToEach(NON_VERBAL.value);
    }

    @Test
    public void checkExerciseNavigation() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.checkPageFirstHeader("Однослоговые слова без шума");
        exercisePage.navigateTo(РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ.value);
        exercisePage.checkPageFirstHeader("Шесть слов");
        exercisePage.navigateTo(РАСПОЗНАВАНИЕ_СЛОВ.value);
        exercisePage.checkPageFirstHeader("Однослоговые слова без шума");

    }
}
