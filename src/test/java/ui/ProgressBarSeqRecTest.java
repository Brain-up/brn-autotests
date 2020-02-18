package ui;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static helpers.BrowserProxy.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static ui.Driver.getProxyDriver;
import static ui.Driver.setCookies;
import static ui.ExercisePage.NavigationMenu.РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ;
import static ui.MainPage.ExerciseLists.VERBAL;

public class ProgressBarSeqRecTest extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = getProxyDriver();
        driver.manage().timeouts().implicitlyWait(2000, MILLISECONDS);
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
    public void checkProgressBarEx_1() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.navigateTo(РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ.value);
        createHar();
        exercisePage.selectWordSeqEx(0);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.selectCorrectAnswers();
        tasks.checkProgressItemMoved(1, false);
    }
}
