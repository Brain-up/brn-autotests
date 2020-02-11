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
import java.util.List;
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
}
