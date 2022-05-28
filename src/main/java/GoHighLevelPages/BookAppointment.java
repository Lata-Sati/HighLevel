package GoHighLevelPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookAppointment {
    public WebDriver driver;

    By bookAppointmentButton= By.xpath("//button[@id='pg-appt__btn--appt-add']");
    //Book Appointment Wizard
    By searchField=By.xpath("//input[@placeholder='Search by name, email, phone or company']");


    public BookAppointment(WebDriver driver){
        this.driver=driver;
    }
    public WebElement BookAppointmentBtn(){return driver.findElement(bookAppointmentButton);}
    public WebElement SearchBox(){
        return driver.findElement(searchField);
    }
}
