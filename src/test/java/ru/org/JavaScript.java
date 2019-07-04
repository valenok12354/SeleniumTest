package ru.org;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.pleer.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//table[@class='icons_akcii info_icon pie']//td[@class='info_icon_text'][contains(text(),'Акции и скидки')]")).click();
        Thread.sleep(1000L);
        driver.findElement(By.xpath("//div[@class='pop_info_icons']//td[@class='info_icon_text'][contains(text(),'100% товаров сертифицировано')]")).click();
        Thread.sleep(1000L);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //alert.accept();

    }
}
