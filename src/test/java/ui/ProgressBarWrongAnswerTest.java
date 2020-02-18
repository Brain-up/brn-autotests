package ui;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.DataEnum.БАЛ;
import static enums.DataEnum.БУМ;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getDriver;
import static ui.Driver.setCookies;
import static ui.MainPage.ExerciseLists.VERBAL;

public class ProgressBarWrongAnswerTest extends InitTest {
    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        setCookies(driver);

        tasks = new TasksPage(driver);
        mainPage = new MainPage(driver);
        exercisePage = new ExercisePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        Driver.waitPage(1000);
        driver.quit();
    }

    @Test
    public void checkItemIsNotMoved() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.selectSingleSyllableNoNoiseEx(0);
        tasks.play();
        tasks.selectCorrectAnswer(БУМ.value);
        tasks.checkProgressItemMoved(0, false);
        tasks.selectCorrectAnswer(БАЛ.value);
        tasks.checkProgressItemMoved(1, false);
    }
}
