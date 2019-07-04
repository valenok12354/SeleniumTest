package mail;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
    public static void main(String[] args) throws IOException, MessagingException {
        WebDriver driver = new ChromeDriver();
        SendMail mail = new SendMail();
        driver.get("http://www.gmail.com");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // in case of an error
        try {
            driver.findElement(By.xpath("//*[@id='ddd']"));
        } catch (Throwable t) {
            FileUtils.copyFile(scrFile, new File("D:\\ERRscreen.jpg"));
            mail.postMail(SendMail.emailTo,SendMail.emailSubjectTxt,SendMail.emailMsgTxt,SendMail.emailFromAddress);
        }
    }
}
