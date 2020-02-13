package ui;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.LinkedList;
import java.util.List;

import static helpers.InitTest.baseUri;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MainPage {

    WebDriver driver;

    public enum ExerciseLists {

        NON_VERBAL ("Неречевые упражнения"),
        VERBAL ("Речевые упражнения");

        public String value;

        ExerciseLists(String value) {
            this.value = value;
        }

        public static List<String> getValues() {
            List<String> values = new LinkedList<>();
            for(ExerciseLists element : ExerciseLists.values()) {
                values.add(element.value);
            }
            return values;
        }
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test-group-breadcrumb] .active")
    private WebElement currentBreadcrumbItem;

    @FindBy(xpath = "//*[text()[contains(.,'Группы')]]")
    private WebElement groupBreadcrumb;

    @FindBy(css = ".p-1 a")
    private List<WebElement> groups;

    @Step
    public void open() {
        driver.get(baseUri);
    }

    @Step
    public void selectGroup(String groupName) {
        for (WebElement item : groups) {
            if (item.getText().equals(groupName)) {
              item.click();
            }
        }
    }

    @Step
    public void checkNavigationListItems(List<String> navList) {
        assertTrue(groups.size() == navList.size());
        assertTrue(getNavElementsText().containsAll(navList));
    }

    @Step
    public void checkNavigationToEach(String option) {
        for (WebElement element : groups) {
            if (element.getText().equals(option)) {
                element.click();
                assertEquals(currentBreadcrumbItem.getText(), option);
                break;
            }
        }
        navigateToGroups();
    }

    @Step
    public void navigateToGroups() {
        groupBreadcrumb.click();
    }

    public List<String> getNavElementsText() {
        List<String> navElementsText = new LinkedList<>();
        for (WebElement item : groups) {
            navElementsText.add(item.getText());
        }
        return navElementsText;
    }
}
