package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdowns {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
//        driver.findElement(By.xpath("//select[@id='searchLanguage']")).sendKeys("Eesti");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']")));
//        select.selectByVisibleText("Ελληνικά");
        select.selectByValue("et");
//        List<WebElement> options = select.getOptions();
//
//        System.out.println(options.size());
//
//        for (int i = 0; i<options.size(); i++) {
//            System.out.println(options.get(i).getText());
//        }
        List<WebElement> option = driver.findElements(By.tagName("option"));
        for (int i = 0; i<option.size(); i++) {
            System.out.println(option.get(i).getText());
        }


    }
}
