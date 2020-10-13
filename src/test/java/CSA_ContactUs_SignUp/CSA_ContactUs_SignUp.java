package CSA_ContactUs_SignUp;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSA_ContactUs_SignUp {

    WebDriver driver;

    @Test
    public void Contact() throws InterruptedException {
        //Open the website
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.charterschoolsaccounting.com");
        Thread.sleep(2000);
        //Open the Contact Tab
        WebElement Contact = driver.findElement(By.xpath("//*[@id=\"comp-jkd5knbb5linkElement\"]/div[1]/div"));
        Contact.click();
        Thread.sleep(1000);
        //Contact Us Text verification
        String expectedText = "Contact Us";
        String actualText = driver.findElement(By.xpath("//*[@id=\"comp-jkd5s9rz5\"]/h1/span")).getText();
        if(expectedText.equals(actualText)){
            System.out.println("Contact Us text Passed!");
        }else{
            System.out.println("Contact Us text Failed!");
        }
        // verify open of info email link  or Verify Title
        WebElement infoEmail = driver.findElement(By.xpath("//*[@id=\"comp-jwercy5c\"]/p/span/span/object/a"));
        infoEmail.click();
        Thread.sleep(1000);
        String expectedTitle = "Contact | Charter Schools Accounting";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Info email open test Passed!");
        }else{
            System.out.println("Info email open test Failed!");
        }
        // verify open of csa email link or Verify Title
        WebElement csaEmail = driver.findElement(By.xpath("//*[@id=\"comp-jkd5s9rz3\"]/p/span/span/object/a"));
        csaEmail.click();
        Thread.sleep(1000);
        String expectedContactTitle = "Contact | Charter Schools Accounting";
        String actualContactTitle = driver.getTitle();
        if(expectedContactTitle.equals(actualContactTitle)){
            System.out.println("Csa email open test Passed!");
        }else{
            System.out.println("Csa email open test Failed!");
        }
        //Contact Phone Text verification
        String expectedPhoneText = "+1 (216) 571 7447";
        String actualPhoneText = driver.findElement(By.xpath("//*[@id=\"comp-jkd5s9rz2\"]/p/span/span")).getText();
        if(expectedPhoneText.equals(actualPhoneText)){
            System.out.println("Contact Phone text Passed!");
        }else{
            System.out.println("Contact Phone text Failed!");
        }
        //Entered requested information and check the Send button
        driver.findElement(By.xpath("//input[@id='field1']")).sendKeys("Sena Ay");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='field2']")).sendKeys("csa@csa.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='field3']")).sendKeys("222-222-2222");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='field4']")).sendKeys("123 Main St. Chicago, IL 60173");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='field5']")).sendKeys("Asking Treasurer Service");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@id='comp-jkd5s9s2fieldMessage']")).sendKeys("Hello, Please contact me.");
        Thread.sleep(2000);
        WebElement SendMessage = driver.findElement(By.xpath("//button[@id='comp-jkd5s9s2submit']"));
        SendMessage.click();
        Thread.sleep(1000);
        //Send message verify
        String expectedSendText = "Your details were sent successfully!";
        String actualSendText = driver.findElement(By.xpath("//div[@id='comp-jkd5s9s2notifications']")).getText();
        if(expectedSendText.equals(actualSendText)){
            System.out.println("Send message text Passed!");
        }else{
            System.out.println("Send message text Failed!");
        }
    }
    
    @Test
    public void SignUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.charterschoolsaccounting.com");
        Thread.sleep(1000);
        WebElement signup = driver.findElement(By.xpath("//button[@id='comp-jsb8hrzoactionTitle']"));
        signup.click();
        Thread.sleep(1000);
        WebElement signup1 = driver.findElement(By.xpath("//button[@id='signUpDialogswitchToEmailLink']"));
        signup1.click();
        Thread.sleep(1000);
        WebElement Email = driver.findElement(By.xpath("//input[@id='signUpDialogemailInputinput']"));
        Email.click();
        Thread.sleep(1000);
        WebElement Username = driver.findElement(By.xpath("//input[@id='signUpDialogemailInputinput']"));
        Username.sendKeys("csa@csa.com");
        Thread.sleep(1000);
        WebElement Password = driver.findElement(By.xpath("//input[@id='signUpDialogpasswordInputinput']"));
        Password.sendKeys("123abc");
        Thread.sleep(1000);
        WebElement SignupButton = driver.findElement(By.xpath("//button[@id='signUpDialogokButton']"));
        SignupButton.click();
        Thread.sleep(1000);
        String expectedMessage = "Success! Your member login request has been sent and is awaiting approval. The site administrator will notify you via email (csa@csa.com) once your request has been approved.";
        String SuccessMessage = driver.findElement(By.xpath("//p[@id='notificationDialogdialogDescription']")).getText();
        Thread.sleep(1000);
        if(SuccessMessage.equals(expectedMessage)){
            System.out.println("Success message verification Passed!");
        }else{
            System.out.println("Success message verification Failed!");
        }
        WebElement SuccessButton = driver.findElement(By.xpath("//button[@id='notificationDialogokButton']"));
        SuccessButton.click();
        Thread.sleep(1000);
    }

}
