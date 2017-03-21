
package testing.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import testing.config.ConfigFileObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sramalin on 17/09/15.
 */
public class Basepage {
     WebDriver webDriver;
     WebDriverWait webDriverWait;
     private static ConfigFileObject configObject;

    public BaseLoginPage launchApp(){
        System.out.println("Environment chosen : "+ System.getProperty("environment"));
      String propertyFileName = System.getProperty("environment").toLowerCase()+"-testconfig.properties";
        System.out.println("Property file loaded: "+propertyFileName);
        configObject = new ConfigFileObject(propertyFileName);

        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
       // System.setProperty("webdriver.gecko.driver", "chromedriver.exe");

       // webDriver = new ChromeDriver();
        webDriver = new FirefoxDriver();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get(configObject.testURL);
       // webDriver.get("http://google.com");
        return new BaseLoginPage(webDriver);
    }

}
