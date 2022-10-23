package org.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement getElementAfterWait(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static String displayTimezone(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dayOfMonth = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        if (hour.length() == 1){
            hour = "0" + hour;
        }
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String currentTimeZone =  year + "-" + month + "-" +dayOfMonth + " " + hour + ":" + minute;
        return currentTimeZone;
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE: " + overlays.size());
        if (overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAY SIZE INVISIBLE ");
        } else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }


}
