package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class MouseMovement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
        WebListeners listener = new WebListeners();
        driver.register(listener);

        EventFiringMouse mouse = new EventFiringMouse(driver,listener);
        webDriver.get("https://www.google.com");
        Thread.sleep(3000L);
        Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnI']"));
        Coordinates coordinates = hoverItem.getCoordinates();
        mouse.mouseMove(coordinates);
        


    }
}
