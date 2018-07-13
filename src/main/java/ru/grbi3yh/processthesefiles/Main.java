package ru.grbi3yh.processthesefiles;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.grbi3yh.processthesefiles.Robots.CustomRobot;
import ru.grbi3yh.processthesefiles.Utils.LanguageIdentifier;
import ru.grbi3yh.processthesefiles.Utils.PropertyLoader;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    private static PropertyLoader prop;
    private static CustomRobot robot;
    private static Integer delayOpenWindow;
    private static Integer extra;

    public static void main(String[] args) {
        //System.out.print(Main.class.getClassLoader().getResource("chromedriver.exe").getPath());
        prop = new PropertyLoader();
        //System.out.print(1);
        robot = new CustomRobot(Integer.parseInt(prop.getProperty("delay.pauseClick")));
        //System.out.print(2);
        delayOpenWindow = Integer.parseInt(prop.getProperty("delay.openWindow"));
        //System.out.print(3);
        extra = Integer.parseInt(prop.getProperty("delay.extra"));
        //System.out.print(4);

//        robot.getBrowserControl().openBrowser(new ChromeDriver());
//        robot.delay(3000);
//        robot.getBrowserControl().closeBrowser();
//        robot.delay(3000);
//        System.out.print(5);

        /**
         * инструкция для робота
         */
        processTheseFiles();
        workWithBrowser();
        moveFile();
    }

    public static void processTheseFiles() {

        robot.keyClick(asList(KeyEvent.VK_WINDOWS, KeyEvent.VK_R));
        robot.delay(extra);
        robot.enterTheStringWithBuffer(prop.getProperty("filePath.queue"));
        robot.keyClick(KeyEvent.VK_ENTER);
        robot.keyClick(KeyEvent.VK_SPACE);
        robot.delay(delayOpenWindow);


        List<String> fileName = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(prop.getProperty("numberOfFiles")); i++) {//Todo Надо КАК ТО Получить количество файлов

            robot.keyClick(KeyEvent.VK_F2);
            robot.keyClick(asList(KeyEvent.VK_CONTROL, KeyEvent.VK_A));
            robot.keyClick(asList(KeyEvent.VK_CONTROL, KeyEvent.VK_C));
            fileName.add(robot.getStringOfBuffer());
            robot.keyClick(KeyEvent.VK_ESCAPE);
            robot.keyClick(KeyEvent.VK_DOWN);
        }

        robot.setDataToMemory("Files", fileName);

        robot.keyClick(asList(KeyEvent.VK_ALT, KeyEvent.VK_F4));
    }

    public static void workWithBrowser() {
        robot.getBrowserControl().openBrowser(new ChromeDriver());
        robot.getBrowserControl().openURL("http://www.google.com");
        robot.getBrowserControl().findElement(By.id("gb_70")).click();
        robot.getBrowserControl().findElement(By.id("identifierId")).sendKeys(prop.getProperty("login.mail"));
        robot.delay(delayOpenWindow);
        robot.getBrowserControl().findElement(By.id("identifierNext")).click();
        robot.delay(delayOpenWindow);
        robot.getBrowserControl().findElement(By.name("password")).sendKeys(prop.getProperty("login.password"));
        robot.delay(delayOpenWindow);
        robot.getBrowserControl().findElement(By.id("passwordNext")).click();
        robot.delay(delayOpenWindow);
        robot.getBrowserControl().openURL("https://mail.google.com/mail/u/0/#inbox");
        robot.delay(delayOpenWindow);
        List<String> fileName = (List<String>) robot.getOfMemoryByKey("Files");
        fileName.forEach(file -> {
            String[] data = file.split("_", 3);
            if (!(data.length >= 2)) {
                return;
            }
            robot.getBrowserControl().findElement(By.xpath("//div[.='НАПИСАТЬ']")).click();
            robot.delay(delayOpenWindow);
            robot.enterTheStringWithBuffer(prop.getProperty("addressee"));
            robot.delay(delayOpenWindow);
            robot.keyClick(KeyEvent.VK_ENTER);
            //robot.keyClick(KeyEvent.VK_TAB);
            try {
                robot.getBrowserControl().findElement(By.name("subjectbox")).click();
            } catch (Exception e) {
                robot.keyClick(KeyEvent.VK_ESCAPE);
                robot.getBrowserControl().findElement(By.name("subjectbox")).click();
            }
            robot.enterTheStringWithBuffer(data[1]);
            //robot.enterTheStringWithBuffer("grbi3yh@gmail.com");
            robot.keyClick(KeyEvent.VK_TAB);
            robot.enterTheStringWithBuffer(data[0]);

            robot.keyClick(KeyEvent.VK_TAB);
            robot.keyClick(KeyEvent.VK_TAB);
            robot.keyClick(KeyEvent.VK_ENTER);
            robot.enterTheStringWithBuffer(prop.getProperty("filePath.queue") + "\\" + file);
            robot.keyClick(KeyEvent.VK_ENTER);
            robot.getBrowserControl().findElement(By.name("subjectbox")).click();
            robot.keyClick(KeyEvent.VK_TAB);
            robot.keyClick(KeyEvent.VK_TAB);
            robot.keyClick(KeyEvent.VK_ENTER);
        });

        robot.delay(delayOpenWindow);
        robot.getBrowserControl().closeBrowser();
    }

    private static void moveFile() {
        robot.keyClick(asList(KeyEvent.VK_WINDOWS, KeyEvent.VK_R));
        robot.delay(extra);
        robot.enterTheStringWithBuffer(prop.getProperty("filePath.queue"));
        robot.keyClick(KeyEvent.VK_ENTER);
        robot.delay(delayOpenWindow);
        robot.keyClick(asList(KeyEvent.VK_CONTROL, KeyEvent.VK_A));
        robot.keyClick(asList(KeyEvent.VK_CONTROL, KeyEvent.VK_X));
        robot.keyClick(asList(KeyEvent.VK_ALT, KeyEvent.VK_F4));

        robot.keyClick(asList(KeyEvent.VK_WINDOWS, KeyEvent.VK_R));
        robot.delay(extra);
        robot.switchLanguage(LanguageIdentifier.EN);
        robot.enterTheStringWithKey(prop.getProperty("filePath.processed"));
        robot.keyClick(KeyEvent.VK_ENTER);
        robot.delay(delayOpenWindow);
        robot.keyClick(asList(KeyEvent.VK_CONTROL, KeyEvent.VK_V));
    }
}
