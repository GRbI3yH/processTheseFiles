package ru.grbi3yh.processthesefiles.Robots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserRobot {

    private WebDriver driver;
    private WebDriverWait wait;
    private long waitTimeOutInSeconds;
    private long waitSleepInMillis;

    BrowserRobot(long waitTimeOutInSeconds, long waitSleepInMillis){
        this.waitTimeOutInSeconds = waitTimeOutInSeconds;
        this.waitSleepInMillis = waitSleepInMillis;
    }

    public void openBrowser(WebDriver driver){
        closeBrowser();
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver , waitTimeOutInSeconds ,waitSleepInMillis);
    }

    public void openURL(String by) {
        driver.get(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void closeTabInBrowser(){
        if (driver != null){
            driver.close();
        }
    }

    public void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
