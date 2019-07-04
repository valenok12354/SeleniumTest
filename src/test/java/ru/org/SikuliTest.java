package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;

public class SikuliTest {
    public static void main(String[] args) throws FindFailed {

        Screen screen = new Screen();
        Pattern img1 = new Pattern("C:\\Users\\kwx641848\\Pictures\\loc.PNG");
        Pattern img2 = new Pattern("C:\\Users\\kwx641848\\Pictures\\open.PNG");


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.zamzar.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        screen.wait(img1, 10);
        screen.type(img1,"C:\\Users\\kwx641848\\Pictures\\1.jpg");
        screen.click(img2);


//                sendKeys("C:\\Users\\kwx641848\\Pictures\\1.jpg");

    }
}
