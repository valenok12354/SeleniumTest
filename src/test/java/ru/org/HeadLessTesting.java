package ru.org;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class HeadLessTesting {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("window-size=1400,800");
        chromeOptions.addArguments("headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.zamzar.com/");
        System.out.println(driver.getTitle());
    }
}
