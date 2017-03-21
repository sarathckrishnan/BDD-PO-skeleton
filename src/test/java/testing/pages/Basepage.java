
package testing.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import testing.config.ConfigFileObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sramalin on 17/09/15.
 */
public class BasePage {
     WebDriver webDriver;
     public static WebDriverWait webDriverWait;
     private static ConfigFileObject configObject;


    public LoginPage launchApp(){
        System.out.println("Environment chosen : "+ System.getProperty("environment"));
        System.out.println("Browser chosen : "+ System.getProperty("browser"));

        String propertyFileName = System.getProperty("environment").toLowerCase()+"-testconfig.properties";
        System.out.println("Property file loaded: "+propertyFileName);

        configObject = new ConfigFileObject(propertyFileName);
        webDriver = initBrowser(System.getProperty("browser"));

        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.get(configObject.testURL);
        return new LoginPage(webDriver);
    }

    public WebDriver initBrowser(String browserName){
        if(browserName.equalsIgnoreCase("FIREFOX")){
            webDriver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        }else if(browserName.equalsIgnoreCase("CHROME")) {
            webDriver = new ChromeDriver();
            System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
        }
        return webDriver;
    }


}
