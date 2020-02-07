package ui;
import helpers.InitTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static helpers.InitTest.*;


public class MainPage {

    WebDriver driver;

    public enum ExerciseLists {

        NON_VERBAL ("Неречевые упражнения"),
        VERBAL ("Речевые упражнения");

        public String value;

        ExerciseLists(String value) {
            this.value = value;
        }
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".p-1 a")
    private List<WebElement> groups;

    public void open() {
        driver.get(baseUri);
    }

    public void selectGroup(String groupName) {
        for (WebElement item : groups) {
            if (item.getText().equals(groupName)) {
              item.click();
            }
        }
    }
}
