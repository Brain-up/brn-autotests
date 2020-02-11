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
import static ui.MainPage.ExerciseLists.VERBAL;

public class SecondExerciseTest extends InitTest {

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
    public void checkExerciseSmallNoise_1() {
        mainPage.selectGroup(VERBAL.value);

        createHar();
        exercisePage.selectSingleSyllableNoiseEx(0);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoise6db(БАЛ)));

        tasks.checkTaskMaterial(БАЛ, asList(getPic(БАЛ), getNoise6db(БУМ)));
        tasks.checkTaskMaterial(БУМ, asList(getPic(БУМ), getNoise6db(БЫЛь)));
        tasks.checkTaskMaterial(БЫЛь, asList(getPic(БЫЛь), getNoise6db(ВИТЬ)));
        tasks.checkTaskMaterial(ВИТЬ, asList(getPic(ВИТЬ), getNoise6db(ГАД)));
        tasks.checkTaskMaterial(ГАД, asList(getPic(ГАД), getNoise6db(ДУБ)));
        tasks.checkTaskMaterial(ДУБ, asList(getPic(ДУБ)));
    }

    @Test(dependsOnMethods = {"checkExerciseSmallNoise_1"})
    public void checkExerciseSmallNoise_2() {
        createHar();
        exercisePage.selectSingleSyllableNoiseEx(1);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoise6db(ЛИНЬ)));

        tasks.checkTaskMaterial(ЛИНЬ, asList(getPic(ЛИНЬ), getNoise6db(ЛИС)));
        tasks.checkTaskMaterial(ЛИС, asList(getPic(ЛИС), getNoise6db(МОЛЬ)));
        tasks.checkTaskMaterial(МОЛЬ, asList(getPic(МОЛЬ), getNoise6db(ПАР)));
        tasks.checkTaskMaterial(ПАР, asList(getPic(ПАР), getNoise6db(ПЯТЬ)));
        tasks.checkTaskMaterial(ПЯТЬ, asList(getPic(ПЯТЬ), getNoise6db(РАБ)));
        tasks.checkTaskMaterial(РАБ, asList(getPic(РАБ)));
    }

    @Test(dependsOnMethods = {"checkExerciseSmallNoise_2"})
    public void checkExerciseSmallNoise_3() {
        createHar();
        exercisePage.selectSingleSyllableNoiseEx(2);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoise6db(РАК)));

        tasks.checkTaskMaterial(РАК, asList(getPic(РАК), getNoise6db(РОЖ)));
        tasks.checkTaskMaterial(РОЖ, asList(getPic(РОЖ), getNoise6db(СЕТЬ)));
        tasks.checkTaskMaterial(СЕТЬ, asList(getPic(СЕТЬ), getNoise6db(ТОПЬ)));
        tasks.checkTaskMaterial(ТОПЬ, asList(getPic(ТОПЬ), getNoise6db(ХОД)));
        tasks.checkTaskMaterial(ХОД, asList(getPic(ХОД), getNoise6db(ШЕФ)));
        tasks.checkTaskMaterial(ШЕФ, asList(getPic(ШЕФ), getNoise6db(МОР)));
        tasks.checkTaskMaterial(МОР, asList(getPic(МОР)));
    }
}
