package ui;

import helpers.InitTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static ui.Driver.getProxyDriver;
import static ui.Driver.setCookies;
import static ui.MainPage.ExerciseLists.VERBAL;

public class ProgressBarWrongAnswerTest extends InitTest {
    TasksPage tasks;
    MainPage mainPage;
    ExercisePage exercisePage;
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getProxyDriver();
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
    public void checkItemColor() {
        mainPage.selectGroup(VERBAL.value);
        exercisePage.selectSingleSyllableNoNoiseEx(1);
        tasks.play();
        driver.findElement(By.xpath("//*[@data-test-progress-indicator-item-number=1]/span")).getCssValue("background-color");
    }

}
