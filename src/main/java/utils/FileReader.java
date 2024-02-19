package utils;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class FileReader {

    static Properties properties = new Properties();

    public static void loadPropertyFile(){
        try(FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/configuration.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDataFromPropFile(String key){
        String data = null;
        try{
            if(Optional.ofNullable(key).isPresent()){
                data = properties.getProperty(key).trim();
                System.out.println("The " + "'" + data + "'" + " data fetched from the configuration property file");
            }
        }catch (NullPointerException exception){
            Assert.fail("The key - " + "'" + key + "'" + " - is not present in the configuration property file" + "\n"
                    + exception.getMessage());
        }
        return data;
    }

}
