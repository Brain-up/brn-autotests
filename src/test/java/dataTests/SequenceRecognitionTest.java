package dataTests;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.ExercisePage;
import ui.MainPage;
import ui.TasksPage;

import static enums.DataEnum.*;
import static helpers.BrowserProxy.*;
import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getProxyDriver;
import static ui.Driver.setCookies;
import static ui.ExercisePage.NavigationMenu.РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ;
import static ui.MainPage.ExerciseLists.VERBAL;

public class SequenceRecognitionTest extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getProxyDriver();
        driver.manage().timeouts().implicitlyWait(4, SECONDS);
        setCookies(driver);

        tasks = new TasksPage(driver);
        mainPage = new MainPage(driver);
        exercisePage = new ExercisePage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void checkFirstEx() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.navigateTo(РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ.value);
        createHar();
        exercisePage.selectWordSeqEx(0);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getPicSeries2(БАБУШКА), getPicSeries2(ДЕВОЧКА), getPicSeries2(ДЕДУШКА), getPicSeries2(БРОСАЕТ), getPicSeries2(ЧИТАЕТ),getPicSeries2(РИСУЕТ)));


    }
}
