package ru.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CalendarsTest {
//  some statement for Jenkins trigger
    static int targetDay = 0;
    static int targetMonth = 0;
    static int targetYear = 0;
    static int currentDay = 0;
    static int currentMonth = 0;
    static int currentYear = 0;
    static int jumpMonthsBy = 0;
    static boolean increment = true;
    static String dateString = "19/02/2019";

    public static void getCurentDateMonthYear() {
        Calendar calendar = Calendar.getInstance();
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        currentMonth = calendar.get(Calendar.MONTH) + 1;
        currentYear = calendar.get(Calendar.YEAR);
    }

    public static void getTargetDateMonthYear(String dateString) {
        int firstIndex = dateString.indexOf("/");
        int lastIndex = dateString.lastIndexOf("/");
        String day = dateString.substring(0, firstIndex);
        targetDay = Integer.parseInt(day);
        String month = dateString.substring(firstIndex + 1, lastIndex);
        targetMonth = Integer.parseInt(month);
        String year = dateString.substring(lastIndex + 1, dateString.length());
        targetYear = Integer.parseInt(year);
    }

    public static void howManyMonthsToJump() {
        int differenceMonth = targetMonth - currentMonth;
        if ((differenceMonth) > 0) {
            jumpMonthsBy = (differenceMonth);
        } else {
            jumpMonthsBy = (currentMonth - targetMonth);
            increment = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        getCurentDateMonthYear();
        System.out.println(currentDay + " " + currentMonth + " " + currentYear);
        getTargetDateMonthYear(dateString);
        System.out.println(targetDay + " " + targetMonth + " " + targetYear);
        howManyMonthsToJump();
        System.out.println(jumpMonthsBy);
        System.out.println(increment);

        WebDriver driver = new ChromeDriver();
        driver.get("https://fengyuanchen.github.io/datepicker/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Pick a date']")).click();
        for (int i = 0; i < jumpMonthsBy; i++) {
            if (increment) {
                driver.findElement(By.xpath("//div[@class='datepicker-panel']//li[contains(text(),'›')]")).click();

            } else {
                driver.findElement(By.xpath("//div[@class='datepicker-panel']//li[contains(text(),'‹')]")).click();

            }
            Thread.sleep(300);
        }   //li[contains(text(),'22')]
        String day=null;
        if (increment) {
             day = Integer.toString(targetDay + 4);
        } else {
             day = Integer.toString(targetDay + 2);
        }
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[3]/li[" + day + "]")).click();
    }
}
