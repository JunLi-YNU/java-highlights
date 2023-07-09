package system;

import java.util.Properties;
import java.util.Set;

public class SystemProperties {

    public static void main(String[] args){
        getSystemProperties();
    }

    public static void getSystemProperties(){
        Properties properties = System.getProperties();
        Set<String> propertiesNames = properties.stringPropertyNames();
        for (String propertyName : propertiesNames
             ) {
            String propertyValue = properties.getProperty(propertyName);
            System.out.println("属性："+propertyName+" 属性值："+propertyValue);
        }
    }
}
