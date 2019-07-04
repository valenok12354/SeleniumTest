package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HTMLUnitTest {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        ChromeDriverService driverService = ChromeDriverService.createDefaultService();

        WebDriver driver = new ChromeDriver(driverService, options);
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("entered");

        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("kartashivan@gmail.com");
        //driver.findElement(By.id("identifierNext")).click();
        System.out.println("logged");

//        WebElement password = driver.fndElement(By.xpath("//input[@name='password']"));
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//
//        wait.until(ExpectedConditions.elementToBeClickable(password));
//        password.sendKeys("Fake2017");
//        driver.findElement(By.id("passwordNext")).click();
//        System.out.println("password entered");
    }
}
