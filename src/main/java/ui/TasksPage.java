package ui;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


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
        try {
            answers.forEach(ans -> {if (ans.getText().equals(answer)) ans.click();});
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
        }
    }
}
