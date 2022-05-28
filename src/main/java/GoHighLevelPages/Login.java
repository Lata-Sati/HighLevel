package GoHighLevelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public WebDriver driver;

    By email= By.id("email");
     By password=By.id("password");
     By signin=By.xpath("//button[@type='button']");

     public Login(WebDriver driver){
         this.driver=driver;
     }

     public WebElement EmailField(){
         return driver.findElement(email);
     }

     public WebElement PasswordField(){
         return driver.findElement(password);
     }

     public WebElement SubmitLogin(){
         return  driver.findElement(signin);
     }

}
