package testing.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigFileObject {


    public String testURL;
    private String testBrowser;

    public ConfigFileObject(String propFileName){
        Properties prop = new Properties();
        try {
            File propFile = new File(propFileName);
            prop.load(new FileInputStream(propFile));
            this.testURL = prop.getProperty("testURL");
            this.testBrowser = prop.getProperty("testBrowser");
        } catch (IOException e) {
            System.err.println("Error reading "+propFileName);
            e.printStackTrace();

        }
    }


}