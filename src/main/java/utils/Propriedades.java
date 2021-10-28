package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propriedades {

    private final Properties properties;

    public static String browser;

    public Propriedades() {

        properties = new Properties();

        InputStream input = null;

        try{
            input = new FileInputStream("config.properties");
            properties.load(input);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        browser = properties.getProperty("browser");
    }
}
