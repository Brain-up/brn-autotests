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

public class ThirdExerciseTest extends InitTest {

    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
       driver = getProxyDriver();
       driver.manage().timeouts().implicitlyWait(4, SECONDS);
       setCookies(driver);

       tasks = new TasksPage(driver);
       mainPage = new MainPage(driver);
       exercisePage = new ExercisePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void checkExerciseLoudNoise_1() {
        mainPage.selectGroup(VERBAL.value);

        createHar();
        exercisePage.selectSingleSyllableLoadNoiseEx(0);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoise9db(БАЛ)));

        tasks.checkTaskMaterial(БАЛ, asList(getPic(БАЛ), getNoise9db(БУМ)));
        tasks.checkTaskMaterial(БУМ, asList(getPic(БУМ), getNoise9db(БЫЛь)));
        tasks.checkTaskMaterial(БЫЛь, asList(getPic(БЫЛь), getNoise9db(ВИТЬ)));
        tasks.checkTaskMaterial(ВИТЬ, asList(getPic(ВИТЬ), getNoise9db(ГАД)));
        tasks.checkTaskMaterial(ГАД, asList(getPic(ГАД), getNoise9db(ДУБ)));
        tasks.checkTaskMaterial(ДУБ, asList(getPic(ДУБ)));
    }

    @Test(dependsOnMethods = {"checkExerciseLoudNoise_1"})
    public void checkExerciseLoudNoise_2() {
        createHar();
        exercisePage.selectSingleSyllableLoadNoiseEx(1);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoise9db(ЛИНЬ)));

        tasks.checkTaskMaterial(ЛИНЬ, asList(getPic(ЛИНЬ), getNoise9db(ЛИС)));
        tasks.checkTaskMaterial(ЛИС, asList(getPic(ЛИС), getNoise9db(МОЛЬ)));
        tasks.checkTaskMaterial(МОЛЬ, asList(getPic(МОЛЬ), getNoise9db(ПАР)));
        tasks.checkTaskMaterial(ПАР, asList(getPic(ПАР), getNoise9db(ПЯТЬ)));
        tasks.checkTaskMaterial(ПЯТЬ, asList(getPic(ПЯТЬ), getNoise9db(РАБ)));
        tasks.checkTaskMaterial(РАБ, asList(getPic(РАБ)));
    }

    @Test(dependsOnMethods = {"checkExerciseLoudNoise_2"})
    public void checkExerciseLoudNoise_3() {
        createHar();
        exercisePage.selectSingleSyllableLoadNoiseEx(2);
        tasks.play();
        writeHar(getCurrentHar());
        tasks.checkMaterialsInHar(asList(getNoise9db(РАК)));

        tasks.checkTaskMaterial(РАК, asList(getPic(РАК), getNoise9db(РОЖЬ)));
        tasks.checkTaskMaterial(РОЖЬ, asList(getPic(РОЖЬ), getNoise9db(СЕТЬ)));
        tasks.checkTaskMaterial(СЕТЬ, asList(getPic(СЕТЬ), getNoise9db(ТОПЬ)));
        tasks.checkTaskMaterial(ТОПЬ, asList(getPic(ТОПЬ), getNoise9db(ХОД)));
        tasks.checkTaskMaterial(ХОД, asList(getPic(ХОД), getNoise9db(ШЕФ)));
        tasks.checkTaskMaterial(ШЕФ, asList(getPic(ШЕФ), getNoise9db(МОР)));
        tasks.checkTaskMaterial(МОР, asList(getPic(МОР)));
    }
}
