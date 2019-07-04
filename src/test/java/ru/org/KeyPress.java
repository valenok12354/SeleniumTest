package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class KeyPress {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
//        email_phone.sendKeys("kartashivan@gmail.com");
//
//        driver.findElement(By.id("identifierNext")).click();
//
//        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//
//        wait.until(ExpectedConditions.elementToBeClickable(password));
//        password.sendKeys("Fake2017");
//        //driver.findElement(By.id("passwordNext")).click();
//        driver.findElement(By.id("passwordNext")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(text(),'Подробнее…')]")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//a[contains(text(),'Cправка - Google Chrome')]")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//a[contains(text(),'Cправка - Google Chrome')]")).sendKeys(Keys.PAGE_UP);
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//a[contains(text(),'Cправка - Google Chrome')]")).sendKeys(Keys.BACK_SPACE);

    }
}
