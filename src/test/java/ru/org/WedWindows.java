package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class WedWindows {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru/");
        Set<String> windId = driver.getWindowHandles();
//        List<String> widowsId = new ArrayList<>();
//        widowsId.addAll(windId);
        Iterator<String> iterator = windId.iterator();
        System.out.println(iterator.next());
        driver.findElement(By.xpath("//a[contains(text(),'Видео')]")).click();
        System.out.println("------------------------");
//        System.out.println(widowsId.get(1));
        windId = driver.getWindowHandles();
        iterator = windId.iterator();
        String firstWindow = iterator.next();
        String tabWindow = iterator.next();
//        System.out.println(firstWindow);
//        System.out.println(tabWindow);

        driver.switchTo().window(tabWindow);
        driver.findElement(By.xpath("//span[@class='service__name'][contains(text(),'Новости')]")).click();
        System.out.println("-----------------------------------");

        windId = driver.getWindowHandles();
        iterator = windId.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        String newPage = iterator.next();
        System.out.println(newPage);

        Thread.sleep(3000L);
        driver.switchTo().window(newPage);
        driver.close();
        driver.switchTo().window(tabWindow);
        driver.close();
        driver.switchTo().window(firstWindow);
        driver.close();

    }
}
