package PortalTesting;

import Academy.BaseUtils;
import GoHighLevelPages.BookAppointment;
import GoHighLevelPages.LandingPage;
import GoHighLevelPages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePage {

    static WebDriver driver;
    static BaseUtils baseUtils;


    private static void initialize() throws IOException {
         baseUtils = new BaseUtils();
        driver = baseUtils.initializeDriver();
        driver.manage().window().maximize();
    }

    private static void login() throws IOException, InterruptedException {
        initialize();
        String url= baseUtils.getUrl();
        String username=baseUtils.getUsername();
        String password=baseUtils.getPassword();
        GoHighLevelPages.Login lp = new Login(driver);
        driver.get(url);
        Thread.sleep(3000);
        lp.EmailField().sendKeys(username);
        lp.PasswordField().sendKeys(password);
        lp.SubmitLogin().click();
        Thread.sleep(15000);
    }

    @Test
    public void BookingAppointment() throws InterruptedException, IOException {
        login();
        LandingPage ldp=new LandingPage(driver);
        if(ldp.isDashboardSelected().isEnabled()){
            System.out.println("landed on to the Dashboard page successfully");
        }
        else System.out.println("something went wrong");
        Thread.sleep(5000);
        ldp.gotoCalendar().click();
Thread.sleep(10000);
        BookAppointment bkap=new BookAppointment(driver);
        bkap.BookAppointmentBtn().click();
        Thread.sleep(5000);
        System.out.println(bkap.SearchBox().getText());
        Thread.sleep(5000);
        System.out.println("*****");
    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }


}
