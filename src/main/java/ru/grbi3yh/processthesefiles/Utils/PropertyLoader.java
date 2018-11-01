package ru.grbi3yh.processthesefiles.Utils;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {

    private Properties property;
    private String fileName = "config.properties";//"src/main/resources/config.properties"
    //private String filePath = this.getClass().getClassLoader().getResource("chromedriver.exe");

    public PropertyLoader() {
        property = new Properties();
        try {
            loadProperty();
        } catch (IOException e) {
            gereraiteDefoltPropertyFile();
        }
        initSystemProperty();
    }

    public void saveProperty(String key, String value) {
        try {
            OutputStream file = new FileOutputStream(fileName);
            property.setProperty(key, value);
            property.store(file, "This is properties!!!");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProperty() throws IOException {
        InputStream file = new FileInputStream(fileName);
        property.load(file);
        file.close();
    }

    public String getProperty(String str) {
        return property.getProperty(str);
    }

    private void gereraiteDefoltPropertyFile() {
        try {
            OutputStream file = new FileOutputStream(fileName);
            property.setProperty("login.mail", "");
            property.setProperty("login.password", "");
            property.setProperty("filePath.queue", "D:\\disk G\\java Program");
            property.setProperty("filePath.processed", "D:\\disk G\\java Program\\321");
            property.setProperty("addressee", "");
            property.setProperty("numberOfFiles", "5");
            property.setProperty("delay.openWindow", "1000");
            property.setProperty("delay.pauseClick", "200");
            property.setProperty("delay.extra", "100");
            property.setProperty("driver.chrome", "GoogleChromePortable\\chromedriver.exe");
            property.setProperty("browsers.chrome", "GoogleChromePortable\\GoogleChromePortable.exe");
            property.store(file,
                    "Примерные настройки \n" +
                            "numberOfFiles=5\n" +
                            "login.mail=___@Gmail.com\n" +
                            "addressee=____@Gmail.com\n" +
                            "driver.chrome=D\\:\\\\programms\\\\ProTheseFil\\\\Chrome\\\\chromedriver.exe\n" +
                            "filePath.processed=D\\:\\\\disk G\\\\java Program\\\\321\n" +
                            "delay.openWindow=1000\n" +
                            "login.password=__\n" +
                            "filePath.queue=D\\:\\\\disk G\\\\java Program\\\\3211\n" +
                            "delay.extra=100\n" +
                            "delay.pauseClick=200\n" +
                            "browsers.chrome=D\\:\\\\programms\\\\ProTheseFil\\\\Chrome\\\\App\\\\Chrome-bin\\\\chrome.exe\n" +
                            "-----------------------------------------------------------------------------------------------");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSystemProperty() {
        System.setProperty("webdriver.chrome.driver", getProperty("driver.chrome"));
    }
}
