package Academy;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.apache.poi.openxml4j.opc.internal.FileHelper.copyFile;

public class base_utility {
    public WebDriver driver;
    public Properties prop;
    public String username;
    public String password;

    public WebDriver initializeDriver() throws IOException {
        //Chrome
        //IE
        //firefox
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\data.properties");
        prop.load(fis);
        String browserName = (prop.getProperty("browser"));
        username=(prop.getProperty("username"));
        password=(prop.getProperty("password"));

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Academy\\Chromedriver\\chromedriver.exe");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("firefox") ){

            driver = new FirefoxDriver();

        }
        else if (browserName.equals("IE")) {
            driver = new InternetExplorerDriver();
        }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void getScreenShotPath(String testcasename, WebDriver driver) throws IOException{
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        String DestinationFile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";

       copyFile(source,new File(DestinationFile));




    }
}
