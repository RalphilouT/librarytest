package com.example.librarywebtest.utilities;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtilities {
    InputStream inputStream;
    Properties properties = new Properties();
    public Properties getPropBase() throws IOException {
        try {
            String propFileName = "application.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return properties;
    }
    public Properties getPropSearch() throws IOException {
        try {
            String propFileName = "searchProperies.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return properties;
    }
    public String[] getCompareProperties(String compareName) throws IOException {
        String[] compare = {};
        try {
            String propFileName = "searchProperies.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
                compare = fetchArrayFromPropFile(compareName,properties);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        System.out.println(compare[0]);
        return compare;
    }
    private String[] fetchArrayFromPropFile(String compareName, Properties prop) {
        String[] comparison = prop.getProperty(compareName).split("#");
        return comparison;
    }
}
