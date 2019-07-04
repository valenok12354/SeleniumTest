package ru.org;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Tests {

    @BeforeClass
    public static void setup() {
        // System.setProperty("webdriver.chrome.driver", "D:\\JDK\\chromedriver.exe");
//
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("network.proxy.http", "93.180.7.246");
//        capabilities.setCapability("network.proxy.http_port", "8080");
//        ChromeDriverService service =
//                new ChromeDriverService.Builder().withWhitelistedIps("").withVerbose(true).build();

    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
        email_phone.sendKeys("kartashivan@gmail.com");

        driver.findElement(By.id("identifierNext")).click();

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("Fake2017");
        driver.findElement(By.id("passwordNext")).click();

    }

}





