package ui;

import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.DataEnum.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.*;
import static ui.MainPage.ExerciseLists.VERBAL;

public class ProgressBarSet3Tests extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        setCookies(driver);

        tasks = new TasksPage(driver);
        mainPage = new MainPage(driver);
        exercisePage = new ExercisePage(driver);
    }

    @AfterClass
    public void afterClass() {
        Driver.waitPage(1000);
        driver.quit();
    }

    @Test
    public void checkProgressBarEx_1() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.selectSingleSyllableLoadNoiseEx(0);
        tasks.play();

        tasks.selectCorrectAnswer(БАЛ.value);
        tasks.checkProgressItemMoved(1, false);

        tasks.selectCorrectAnswer(БУМ.value);
        tasks.checkProgressItemMoved(2, false);

        tasks.selectCorrectAnswer(БЫЛь.value);
        tasks.checkProgressItemMoved(3, false);

        tasks.selectCorrectAnswer(ВИТЬ.value);
        tasks.checkProgressItemMoved(4, false);

        tasks.selectCorrectAnswer(ГАД.value);
        tasks.checkProgressItemMoved(5, false);

        tasks.selectCorrectAnswer(ДУБ.value);
        tasks.checkProgressItemMoved(6, true);
    }

    @Test(dependsOnMethods = {"checkProgressBarEx_1"})
    public void checkProgressBarEx_2() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.selectSingleSyllableLoadNoiseEx(1);
        tasks.play();

        tasks.selectCorrectAnswer(ЛИНЬ.value);
        tasks.checkProgressItemMoved( 1, false);

        tasks.selectCorrectAnswer(ЛИС.value);
        tasks.checkProgressItemMoved(2, false);

        tasks.selectCorrectAnswer(МОЛЬ.value);
        tasks.checkProgressItemMoved( 3, false);

        tasks.selectCorrectAnswer(ПАР.value);
        tasks.checkProgressItemMoved( 4, false);

        tasks.selectCorrectAnswer(ПЯТЬ.value);
        tasks.checkProgressItemMoved( 5, false);

        tasks.selectCorrectAnswer(РАБ.value);
        tasks.checkProgressItemMoved( 6, true);
    }

    @Test(dependsOnMethods = {"checkProgressBarEx_2"})
    public void checkProgressBarEx_3() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.selectSingleSyllableLoadNoiseEx(2);
        tasks.play();

        tasks.selectCorrectAnswer(РАК.value);
        tasks.checkProgressItemMoved( 1, false);

        tasks.selectCorrectAnswer(РОЖЬ.value);
        tasks.checkProgressItemMoved( 2, false);

        tasks.selectCorrectAnswer(СЕТЬ.value);
        tasks.checkProgressItemMoved( 3, false);

        tasks.selectCorrectAnswer(ТОПЬ.value);
        tasks.checkProgressItemMoved( 4, false);

        tasks.selectCorrectAnswer(ХОД.value);
        tasks.checkProgressItemMoved( 5, false);

        tasks.selectCorrectAnswer(ШЕФ.value);
        tasks.checkProgressItemMoved(6, false);

        tasks.selectCorrectAnswer(МОР.value);
        tasks.checkProgressItemMoved( 7, true);
    }
}
