package ui;
import helpers.BrowserProxy;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static helpers.InitTest.*;


public class Driver {
    public static WebDriver getDriver() {
        return new ChromeDriver();
    }

    public static WebDriver getProxyDriver() {
        BrowserProxy bp = new BrowserProxy();
        return new ChromeDriver(bp.capabilities);
    }

    public static void waitPage(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setCookies(WebDriver driver) {
        Cookie ck = new Cookie("JSESSIONID", cookie.get("JSESSIONID").getValue());
        driver.navigate().to(baseUri);
        driver.manage().addCookie(ck);
    }
}
