package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class TestListeners {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);

        WebListeners listener = new WebListeners();
        driver.register(listener);


        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signin");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("identifierNext")).click();

    }
}
