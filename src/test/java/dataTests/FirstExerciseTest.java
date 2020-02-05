package dataTests;

import helpers.InitTest;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.ExercisePage;
import ui.MainPage;
import ui.TasksPage;

import static enums.DataEnum.*;
import static enums.UriEnum.NO_NOISE;
import static helpers.BrowserProxy.*;
import static helpers.JsonUtils.*;
import static ui.Driver.getProxyDriver;
import static ui.MainPage.ExerciseLists.VERBAL;

public class FirstExerciseTest extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exersicesPage;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
       driver = getProxyDriver();
       tasks = new TasksPage(driver);
       mainPage = new MainPage(driver);
       exersicesPage = new ExercisePage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void checkFirstExersice() {
        mainPage.open();
        mainPage.selectGroup(VERBAL.value);
        createHar();
        exersicesPage.selectSingleSyllableEx(0);
        tasks.play();

        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, БАЛ.audio);

        createHar();
        tasks.selectCorrectAnswer(БАЛ.value);

        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, БУМ.audio);

        createHar();
        tasks.selectCorrectAnswer(БУМ.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, БЫЛь.audio);

        createHar();
        tasks.selectCorrectAnswer(БЫЛь.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, ВИТЬ.audio);

        createHar();
        tasks.selectCorrectAnswer(ВИТЬ.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, ГАД.audio);

        createHar();
        tasks.selectCorrectAnswer(ГАД.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, ДУБ.audio);
        tasks.selectCorrectAnswer(ДУБ.value);
    }

    public void checkMaterial(String har, String path, String option) {
        JSONArray g = getParsedHar(har, path, option);
        Assert.assertTrue(g.size() != 0, String.format("Material for %s is not loaded", option));
    }
}
