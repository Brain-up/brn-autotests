package ui;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getDriver;
import static ui.Driver.setCookies;
import static ui.MainPage.ExerciseLists.VERBAL;

public class TimerTests extends InitTest {
    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(3, SECONDS);
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
    public void checkElementsDisabledOnTimer() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.selectSingleSyllableNoNoiseEx(0);
        tasks.play();
        tasks.clickTimerButton();
        tasks.checkAnswersDisabled(6, true);
        tasks.checkPlayAudioButtonDisabled(true);
        tasks.clickTimerButton();
        tasks.checkAnswersDisabled(6, false);
        tasks.checkPlayAudioButtonDisabled(false);
    }
}
