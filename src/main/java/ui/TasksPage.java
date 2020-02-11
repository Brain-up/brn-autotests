package ui;

import enums.DataEnum;
import net.minidev.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static enums.DataEnum.*;
import static helpers.BrowserProxy.*;
import static helpers.JsonUtils.getUrlHar;


public class TasksPage {

    WebDriver driver;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test-start-task-button]")
    private WebElement play;

    @FindBy(xpath = "//button[@data-test-task-answer-option]")
    private List<WebElement> answers;

    public void play() {
        play.click();
    }

    @Step
    public void selectCorrectAnswer(String answer) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 3) {
            try {
                Actions action = new Actions(driver);
                WebElement we = driver.findElement(By.cssSelector("[data-test-play-audio-button]"));
                action.moveToElement(we).build().perform();

                Driver.waitPage(3500);

                for (WebElement element : answers) {
                    if (element.getText().equals(answer)) {
                        element.click();
                    }
                }
                result = true;
                break;
            } catch (Exception e) {
            }
            attempts++;
        }
    }

    @Step
    public void checkTaskMaterial(DataEnum correctAnswer, List <String> materials) {
        createHar();
        this.selectCorrectAnswer(correctAnswer.value);
        writeHar(getCurrentHar());
        checkMaterialsInHar(materials);
    }

    @Step
    public void checkMaterialsInHar(List<String> materials){
        JSONArray g = getUrlHar(HAR_FILE_NAME);
        for (String element : materials) {
            Assert.assertTrue(g.contains(element));
        }
    }

    @Step
    public void selectCorrectAnswers() {
        List<String> correctAnswers = retrieveCorrectAnswers();

        String actor = String.format("//button[@data-test-task-answer-option = '%s']", correctAnswers.get(0));
        String act = String.format("//button[@data-test-task-answer-option = '%s']", correctAnswers.get(1));

        boolean result = false;
        int attempts = 0;
        while(attempts < 3) {
            try {
                Actions action = new Actions(driver);
                WebElement we = driver.findElement(By.cssSelector("[data-test-play-audio-button]"));
                action.moveToElement(we).build().perform();

                Driver.waitPage(3500);

                driver.findElement(By.xpath(actor)).click();
                driver.findElement(By.xpath(act)).click();

                result = true;
                break;
            } catch (Exception e) {
            }
            attempts++;
        }
    }

    @Step
    public List<String> retrieveCorrectAnswers() {
        JSONArray g = getUrlHar(HAR_FILE_NAME);

        Map<String, String> actors = new HashMap();
        actors.put(getAudioSeries2(ДЕВОЧКА), ДЕВОЧКА.value);
        actors.put(getAudioSeries2(БАБУШКА), БАБУШКА.value);
        actors.put(getAudioSeries2(ДЕДУШКА), ДЕДУШКА.value);

        Map<String, String> action = new HashMap();
        action.put(getAudioSeries2(РИСУЕТ), РИСУЕТ.value);
        action.put(getAudioSeries2(БРОСАЕТ), БРОСАЕТ.value);
        action.put(getAudioSeries2(ЧИТАЕТ), ЧИТАЕТ.value);

        List<String> result = new LinkedList<>();

        for (Map.Entry entry : actors.entrySet()) {
            if (g.contains(entry.getKey().toString())) {
                result.add(entry.getValue().toString());
                break;
            }
        }

        for (Map.Entry entry : action.entrySet()) {
            if (g.contains(entry.getKey().toString())) {
                result.add(entry.getValue().toString());
                break;
            }
        }
        return result;
    }
}
