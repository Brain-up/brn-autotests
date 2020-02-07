package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExercisePage {

    WebDriver driver;

    public ExercisePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-test-exercise-level and @data-test-exercise-name ='Однослоговые слова без шума']")
    private List<WebElement> singleSyllableNoNoiseEx;


    public void selectSingleSyllableEx(int exNumber) {
       singleSyllableNoNoiseEx.get(exNumber).click();
    }
}
