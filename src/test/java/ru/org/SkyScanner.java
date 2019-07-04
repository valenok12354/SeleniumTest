package ru.org;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SkyScanner {
    public static void main(String[] args) throws InterruptedException {
        String cityTo = "Minsk";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        //driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Moscow");
        driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='calc60']")).click();
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.
                        presenceOfElementLocated(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='calc60']")));
        //Thread.sleep(1000);

        driver.findElement(By.xpath("//input[contains(@placeholder,'To')]")).sendKeys(cityTo);
        driver.findElement(By.xpath("//p[text()='Minsk National Airport']")).click();


//        driver.findElement(By.xpath("//li[@id='react-autowhatever-fsc-destination-search--item-0']//div[@class='BpkAutosuggest_bpk-autosuggest__suggestion-inner__3q0Fn']")).click();
//        driver.findElement(By.xpath("//button[@class='BpkButton_bpk-button__12Eue BpkButton_bpk-button--large__2SwK9 App_SubmitButton__1EUd0']")).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)");
//        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"filter-controls\"]/div[2]/dl[2]/dd[1]"));
//        Actions action = new Actions(driver);
//        action.dragAndDropBy(scroll,30,0).build();
//        action.perform();
    }
}
