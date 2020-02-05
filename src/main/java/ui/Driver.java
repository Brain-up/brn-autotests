package ui;

import helpers.BrowserProxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver {

    public static WebDriver getDriver() {
        return new ChromeDriver();
    }

    public static WebDriver getProxyDriver() {
        BrowserProxy bp = new BrowserProxy();
        return new ChromeDriver(bp.capabilities);
    }

    public static void waitPage() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
