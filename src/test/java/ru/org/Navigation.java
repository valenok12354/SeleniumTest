package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Для бизнеса')]")).click();
        Thread.sleep(2000L);
        driver.navigate().back();
        Thread.sleep(2000L);
        driver.navigate().forward();
    }
}
