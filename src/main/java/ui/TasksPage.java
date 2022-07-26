package ui;

import enums.DataEnum;
import net.minidev.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static enums.DataEnum.*;
import static helpers.BrowserProxy.*;
import static helpers.JsonUtils.getUrlHar;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.*;


public class TasksPage {

    WebDriver driver;
    WebDriverWait wait;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(6), Duration.ofMillis(100));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test-start-task-button]")
    private WebElement play;

    @FindBy(xpath = "//*[@data-test-play-audio-button]")
    private WebElement playAudioDisabled;

    @FindBy(xpath = "//*[@data-test-task-answer-option]")
    private List<WebElement> answers;

    @FindBy(xpath = "//*[@data-test-task-answer and @disabled]")
    private List<WebElement> disabledAnswers;

    @FindBy(xpath = "//*[@data-test-timer-wrapper]/button")
    private WebElement timerButton;

    private static final String progressBarCompleted = "//*[@style='--progress:100%;']";

    private static final String playButton = "[data-test-play-audio-button]";

    private static final String successNotification = ".mb-4";

    private static final String progressItems = "//*[contains(@style, 'transform')]";

    @Step
    public void play() {
        int attempts = 0;
        while(attempts < 3) {
            try {
                play.click();
                break;
            } catch (Exception e) {
                attempts++;
            }
        }
    }

    @Step
    public void checkAnswersDisabled(int size, boolean isDisabled) {
        Driver.waitPage(2000);
        if (isDisabled) {
        assertTrue(disabledAnswers.size() == size);
        } else assertTrue(disabledAnswers.size() == 0);

    }

    @Step
    public void checkPlayAudioButtonDisabled(boolean isDisabled) {
        if (isDisabled) {
            assertFalse(playAudioDisabled.isEnabled());
        } else assertTrue(playAudioDisabled.isEnabled());
    }

    @Step
    public void clickTimerButton() {
        Driver.waitPage(2000);
        timerButton.click();
    }

    public List<WebElement> getTransformedItems(int count, boolean isLast) {
        if (isLast) {
            wait.until(
                    presenceOfElementLocated(cssSelector(successNotification)));
        } else
            wait.until(
                    presenceOfElementLocated(cssSelector(playButton)));

        return driver.findElements(xpath(progressItems));
    }


    @Step
    public void checkProgressItemMoved(int totalNumber, boolean isLast) {
        List<WebElement> items;
                items = getTransformedItems(totalNumber, isLast);
                assertEquals(items.size(), totalNumber);
    }

    @Step
    public void selectCorrectAnswer(String answer) {
        wait.until(presenceOfElementLocated(xpath(progressBarCompleted)));

        int attempts = 0;
        while(attempts < 4) {
            try {
                Actions action = new Actions(driver);
                WebElement we = driver.findElement(cssSelector(playButton));
                action.moveToElement(we).build().perform();

                for (WebElement element : answers) {
                    if (element.getText().equals(answer)) {
                        element.click();
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                attempts++;
                if (attempts == 3) {
                    throw new AssertionError("Correct answer is not clicked" + attempts);
                }
            }
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
            assertTrue(g.contains(element));
        }
    }

    @Step
    public void selectCorrectAnswers() {
        wait.until(presenceOfElementLocated(xpath(progressBarCompleted)));

        List<String> correctAnswers = retrieveCorrectAnswers();

        String actor = String.format("//button[@data-test-task-answer-option = '%s']", correctAnswers.get(0));
        String act = String.format("//button[@data-test-task-answer-option = '%s']", correctAnswers.get(1));

        int attempts = 0;
        while(attempts < 4) {
            try {
                Actions action = new Actions(driver);
                WebElement we = driver.findElement(cssSelector(playButton));
                action.moveToElement(we).build().perform();

                driver.findElement(xpath(actor)).click();
                driver.findElement(xpath(act)).click();

                break;
            } catch (Exception e) {
                attempts++;
                if (attempts == 3) {
                    throw new AssertionError("Correct answer is not clicked");
                }
            }
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
