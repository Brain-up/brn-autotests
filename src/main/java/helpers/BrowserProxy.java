package helpers;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.Driver;

import java.io.*;
import java.util.concurrent.ExecutionException;

import static enums.FilePathEnum.HAR_FILE;

public class BrowserProxy {

    private static BrowserMobProxy proxy;
    private static Proxy seleniumProxy;
    public static DesiredCapabilities capabilities;
    public static String HAR_FILE_NAME = "Response.har";

     public BrowserProxy() {
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
    }

    public static void stopProxy() {
        proxy.stop();
    }

    public static Har createHar() {
         if(getCurrentHar() != null) {
              proxy.endHar();
         }
         return proxy.newHar();
    }

    public static Har newPage() {
        return proxy.newPage();
    }

    public static Har endHar() {
        return proxy.endHar();
    }

    public static Har getCurrentHar(){
        return proxy.getHar();
    }

    public static void writeHar(Har har) {
         Driver.waitPage(4000);
        try {
            File file = new File(HAR_FILE.value + HAR_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            try {
                har.writeTo(fos);
            }
            finally {
                fos.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName) {
        String strLine = null;
        String s = null;
        try{
            FileInputStream fstream = new FileInputStream(HAR_FILE.value + fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            while ((strLine = br.readLine()) != null){
                s = strLine;
            }
        } catch (IOException e){
            System.out.println("Error");
        }
        return s;
    }
}
