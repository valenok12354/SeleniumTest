package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebRadio {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.echoecho.com/htmlforms10.htm");
        //List<WebElement> radio_button = driver.findElements(By.xpath("//div[@id='radio']//span[contains(text(),'Red')]"));
        List<WebElement> radio_button = driver.findElements(By.name("group1"));
        System.out.println(radio_button.get(0).getAttribute("value"));
        System.out.println(radio_button.get(0).getAttribute("checked"));
        radio_button.get(0).click();
        System.out.println(radio_button.get(0).getAttribute("checked"));
    }
}
