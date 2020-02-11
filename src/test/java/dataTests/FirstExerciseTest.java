package dataTests;

import enums.DataEnum;
import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.ExercisePage;
import ui.MainPage;
import ui.TasksPage;

import java.util.EnumSet;
import java.util.Set;

import static enums.DataEnum.*;
import static helpers.BrowserProxy.*;
import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getProxyDriver;
import static ui.Driver.setCookies;
import static ui.MainPage.ExerciseLists.VERBAL;

public class FirstExerciseTest extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    Set<DataEnum> set = EnumSet.allOf(DataEnum.class);

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
    public void checkExercise_1() {
        mainPage.selectGroup(VERBAL.value);

        createHar();
        exercisePage.selectSingleSyllableEx(0);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoNoise(БАЛ)));

        tasks.checkTaskMaterial(БАЛ, asList(getPic(БАЛ), getNoNoise(БУМ)));
        tasks.checkTaskMaterial(БУМ, asList(getPic(БУМ), getNoNoise(БЫЛь)));
        tasks.checkTaskMaterial(БЫЛь, asList(getPic(БЫЛь), getNoNoise(ВИТЬ)));
        tasks.checkTaskMaterial(ВИТЬ, asList(getPic(ВИТЬ), getNoNoise(ГАД)));
        tasks.checkTaskMaterial(ГАД, asList(getPic(ГАД), getNoNoise(ДУБ)));
        tasks.checkTaskMaterial(ДУБ, asList(getPic(ДУБ)));
    }

    @Test(dependsOnMethods = {"checkExercise_1"})
    public void checkExercise_2() {
        createHar();
        exercisePage.selectSingleSyllableEx(1);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoNoise(ЛИНЬ)));

        tasks.checkTaskMaterial(ЛИНЬ, asList(getPic(ЛИНЬ), getNoNoise(ЛИС)));
        tasks.checkTaskMaterial(ЛИС, asList(getPic(ЛИС), getNoNoise(МОЛЬ)));
        tasks.checkTaskMaterial(МОЛЬ, asList(getPic(МОЛЬ), getNoNoise(ПАР)));
        tasks.checkTaskMaterial(ПАР, asList(getPic(ПАР), getNoNoise(ПЯТЬ)));
        tasks.checkTaskMaterial(ПЯТЬ, asList(getPic(ПЯТЬ), getNoNoise(РАБ)));
        tasks.checkTaskMaterial(РАБ, asList(getPic(РАБ)));
    }

    @Test(dependsOnMethods = {"checkExercise_2"})
    public void checkExercise_3() {
        createHar();
        exercisePage.selectSingleSyllableEx(2);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoNoise(РАК)));

        tasks.checkTaskMaterial(РАК, asList(getPic(РАК), getNoNoise(РОЖ)));
        tasks.checkTaskMaterial(РОЖ, asList(getPic(РОЖ), getNoNoise(СЕТЬ)));
        tasks.checkTaskMaterial(СЕТЬ, asList(getPic(СЕТЬ), getNoNoise(ТОПЬ)));
        tasks.checkTaskMaterial(ТОПЬ, asList(getPic(ТОПЬ), getNoNoise(ХОД)));
        tasks.checkTaskMaterial(ХОД, asList(getPic(ХОД), getNoNoise(ШЕФ)));
        tasks.checkTaskMaterial(ШЕФ, asList(getPic(ШЕФ), getNoNoise(МОР)));
        tasks.checkTaskMaterial(МОР, asList(getPic(МОР)));
    }
}
