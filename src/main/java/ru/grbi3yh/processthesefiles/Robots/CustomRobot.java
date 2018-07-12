package ru.grbi3yh.processthesefiles.Robots;

import ru.grbi3yh.processthesefiles.Utils.BufferEmployee;
import ru.grbi3yh.processthesefiles.Utils.LanguageIdentifier;
import ru.grbi3yh.processthesefiles.Utils.StringReader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Робот собирающий в себе возможности для работы с ОС и браузером
 */
public class CustomRobot {

    private Robot bot;
    private BrowserRobot browserRobot = new BrowserRobot(30, 300);
    private int delayBetweenClick;
    private Map<String, Object> botMemory = new HashMap<>();
    private BufferEmployee bufferEmployee = new BufferEmployee();
    private StringReader strReader = new StringReader();
    private LanguageIdentifier languageIdentifier = new LanguageIdentifier();

    public CustomRobot(int delayBetweenClick) {
        try {
            bot = new Robot();
            this.delayBetweenClick = delayBetweenClick;
        } catch (AWTException e) {
            e.printStackTrace();
        }
        //strReader = new StringReader();
    }

    public void keyPress(List<Integer> keys) {
        keys.forEach(bot::keyPress);
    }

    public void keyRelease(List<Integer> keys) {
        keys.forEach(bot::keyRelease);
    }

    public void delay(int delay) {
        bot.delay(delay);
    }

    public void keyClick(int key) {
        bot.keyPress(key);
        bot.keyRelease(key);
        delay(delayBetweenClick);

    }

    public void keyClick(List<Integer> keys) {
        keyPress(keys);
        keyRelease(keys);
        delay(delayBetweenClick);
    }

    public Object getOfMemoryByKey(String key) {
        return botMemory.get(key);
    }

    public void setDataToMemory(String key, Object value) {
        botMemory.put(key, value);
    }

    public String getStringOfBuffer() {
        return bufferEmployee.getStringOfBuffer();
    }

    /**
     * Вводит строку через буфер(Ctrl+V)
     *
     * @param str
     */
    public void enterTheStringWithBuffer(String str) {
        bufferEmployee.setStringToBuffer(str);
        delay(100);
        keyClick(asList(KeyEvent.VK_CONTROL, KeyEvent.VK_V));
    }

    /**
     * Вводит строку через клавиши
     *
     * @param str
     */
    public void enterTheStringWithKey(String str) {
        strReader.toKeyEvent(str).forEach(keys -> {
            keyPress(keys);
            keyRelease(keys);
        });
    }

    public BrowserRobot getBrowserControl() {
        return browserRobot;
    }

    public boolean switchLanguage(String leng) {
        String firstLang = languageIdentifier.contextLanguage();
        while (!(languageIdentifier.contextLanguage().equals(leng))) {
            keyClick(asList(KeyEvent.VK_SHIFT, KeyEvent.VK_ALT));
            if (languageIdentifier.contextLanguage().equals(firstLang)) {
                return false;
            }
        }
        return true;
    }

    //    public void mouseClick(int x, int y) throws AWTException {
//        mouseClick(x, y, InputEvent.BUTTON1_MASK, mouseDelay);
//    }
//
//    public void mouseClick(int x, int y, int button_mask) throws AWTException {
//        mouseClick(x, y, button_mask, mouseDelay);
//    }
//
//    public void mouseClick(int x, int y, int button_mask, int sleepTime) throws AWTException {
//        bot.mouseMove(x, y);
//        bot.mousePress(button_mask);
//        sleep(sleepTime);
//        bot.mouseRelease(button_mask);
//    }
//
//    public void mouseClick(MatrixPosition mp) throws AWTException {
//        mouseClick(mp.x, mp.y);
//    }
//
//    public void mouseClick(MatrixPosition mp, int button_mask) throws AWTException {
//        mouseClick(mp.x, mp.y, button_mask);
//    }
//
//    public void mouseClick(MatrixPosition mp, int button_mask, int sleepTime) throws AWTException {
//        mouseClick(mp.x, mp.y, button_mask, sleepTime);
//    }
//
//    public MatrixPosition mousePos() {
//        return new MatrixPosition(MouseInfo.getPointerInfo().getLocation());
//    }
//
//
}
