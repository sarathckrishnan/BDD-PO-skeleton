
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sramalin on 17/09/15.
 */
public class Basepage {

     WebDriver webDriver;
     String hostURL = "https://login-ci.schneider-electric.com";
     WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);


    public BaseLoginPage launchApp(){


        //System.setProperty("webdriver.chrome.driver", "../AuthTestAutomation/src/chromedriver/chromedriverMAC");
         System.setProperty("webdriver.chrome.driver", "../AuthTestAutomation/src/chromedriver/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to(hostURL);
        return new BaseLoginPage(webDriver);

    }
}
