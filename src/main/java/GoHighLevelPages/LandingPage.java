package GoHighLevelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    By dashboard=By.id("sb_dashboard");
    By calendar=By.xpath("//a[@id='sb_calendars']");
  public LandingPage(WebDriver driver){
      this.driver=driver;
  }
  public WebElement isDashboardSelected(){
        return driver.findElement(dashboard);
    }
  public WebElement gotoCalendar(){
      return driver.findElement(calendar);
    }






}
