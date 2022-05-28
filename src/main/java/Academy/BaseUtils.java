package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.apache.logging.log4j.core.util.FileUtils.*;
import static org.apache.poi.openxml4j.opc.internal.FileHelper.copyFile;

public class BaseUtils {
    public WebDriver driver;

    public String username1;
    public String password1;
    public Properties prop = new Properties();

    FileInputStream fis;

    {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Academy\\data.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public WebDriver initializeDriver() throws IOException {
        //Chrome
        //IE
        //firefox
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        prop.load(fis);
        String browserName = (prop.getProperty("browser"));
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\Academy\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("firefox")) {

            driver = new FirefoxDriver();

        } else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getUrl() throws IOException {
        prop.load(fis);
        String url = (prop.getProperty("url"));
        return url;

    }
    public String getUsername() throws IOException {
        //prop.load(fis);
        String username = (prop.getProperty("username"));
        return username;
    }
    public String getPassword() throws IOException {
        //prop.load(fis);
        String password = (prop.getProperty("password"));
        return password;
    }

}
