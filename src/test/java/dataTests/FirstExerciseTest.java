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

import java.util.concurrent.TimeUnit;

import static enums.DataEnum.*;
import static enums.UriEnum.NO_NOISE;
import static enums.UriEnum.PIC;
import static helpers.BrowserProxy.*;
import static helpers.JsonUtils.*;
import static ui.Driver.*;
import static ui.Driver.getProxyDriver;
import static ui.MainPage.ExerciseLists.VERBAL;

public class FirstExerciseTest extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
       driver = getProxyDriver();
       driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       setCookies(driver);

       tasks = new TasksPage(driver);
       mainPage = new MainPage(driver);
       exercisePage = new ExercisePage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void checkExercise_1() {
        mainPage.open();
        mainPage.selectGroup(VERBAL.value);
        createHar();
        exercisePage.selectSingleSyllableEx(0);
        tasks.play();

        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, БАЛ.audio);

        createHar();
        tasks.selectCorrectAnswer(БАЛ.value);

        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, PIC.value, БАЛ.pic);
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, БУМ.audio);

        createHar();
        tasks.selectCorrectAnswer(БУМ.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, PIC.value, БУМ.pic);
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, БЫЛь.audio);

        createHar();
        tasks.selectCorrectAnswer(БЫЛь.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, PIC.value, БЫЛь.pic);
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, ВИТЬ.audio);

        createHar();
        tasks.selectCorrectAnswer(ВИТЬ.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, PIC.value, ВИТЬ.pic);
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, ГАД.audio);

        createHar();
        tasks.selectCorrectAnswer(ГАД.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, PIC.value, ГАД.pic);
        checkMaterial(HAR_FILE_NAME, NO_NOISE.value, ДУБ.audio);

        createHar();
        tasks.selectCorrectAnswer(ДУБ.value);
        writeHar(getCurrentHar());
        checkMaterial(HAR_FILE_NAME, PIC.value, ДУБ.pic);
    }

    public void checkMaterial(String har, String path, String option) {
        JSONArray g = getParsedHar(har, path, option);
        Assert.assertTrue(g.size() != 0, String.format("Material for %s is not loaded", option));
    }
}
