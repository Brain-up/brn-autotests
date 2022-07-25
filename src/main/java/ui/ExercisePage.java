package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class ExercisePage {

    public enum NavigationMenu {

        РАСПОЗНАВАНИЕ_СЛОВ ("Распознование слов"),
        РАСПОЗНОВАНИЕ_ПОСЛЕДОВАТЕЛЬНОСТИ ("Распознование последовательности слов"),
        РАСПОЗНОВАНИЕ_ПРЕДЛОЖЕНИЙ ("Распознование предложений"),
        ДИХОТИЧЕСКОЕ_СЛУШАНИЕ ("Дихотическое слушание");

        public String value;

        NavigationMenu(String value) {
            this.value = value;
        }

        public static List<String> getValues() {
            List<String> values = new LinkedList<>();
            for(NavigationMenu element : NavigationMenu.values()) {
                values.add(element.value);
            }
            return values;
        }
    }

    WebDriver driver;
    WebDriverWait wait;

    public ExercisePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(6), Duration.ofMillis(100));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-test-exercise-level and @data-test-exercise-name ='Однослоговые слова без шума']")
    private List<WebElement> singleSyllableNoNoiseEx;

    @FindBy(xpath = "//*[@data-test-exercise-level and @data-test-exercise-name ='Однослоговые слова малым шумом']")
    private List<WebElement> singleSyllableNoiseEx;

    @FindBy(xpath = "//*[@data-test-exercise-level and @data-test-exercise-name ='Однослоговые слова c сильным шумом']")
    private List<WebElement> singleSyllableLoadNoiseEx;

    @FindBy(xpath = "//*[@data-test-exercise-level and @data-test-exercise-name ='Шесть слов']")
    private List<WebElement> wordSeqRecEx;

    @FindBy(css = ".group-nav-list li a")
    private List<WebElement> navMenu;

    @FindBy(xpath = "//*[@data-test-series-navigation-header][1]")
    private WebElement header;

    public void selectSingleSyllableNoNoiseEx(int exNumber) {
        waitExercisePage();
       singleSyllableNoNoiseEx.get(exNumber).click();
    }

    public void selectSingleSyllableNoiseEx(int exNumber) {
        waitExercisePage();
        singleSyllableNoiseEx.get(exNumber).click();
    }

    public void selectSingleSyllableLoadNoiseEx(int exNumber) {
        waitExercisePage();
        singleSyllableLoadNoiseEx.get(exNumber).click();
    }

    public void waitExercisePage() {
        wait.until(
                presenceOfElementLocated(cssSelector("[data-test-series-navigation-header]")));
    }

    public void selectWordSeqEx(int exNumber) {
        wordSeqRecEx.get(exNumber).click();
    }

    @Step
    public void navigateTo(String navOption) {
        for (WebElement item : navMenu) {
            if (item.getText().equals(navOption)) {
                item.click();
            }
        }
    }

    @Step
    public void checkPageFirstHeader(String title) {
        Driver.waitPage(1000);
        assertEquals(header.getText(), title);

    }
}
