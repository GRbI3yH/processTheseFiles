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
            property.setProperty("driver.chrome", "chromedriver.exe");
            property.store(file, "This is properties!!!");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initSystemProperty() {
        System.setProperty("webdriver.chrome.driver", getProperty("driver.chrome"));
    }
}
