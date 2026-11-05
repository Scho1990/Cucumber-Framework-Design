package config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {
    private ConfigManager()
    {}
    private static final Properties prop = new Properties();
    static {
        try(InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if(input != null) {
                prop.load(input);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getProperty(String key,String defaultValue)
    {
        return System.getProperty(key,prop.getProperty(key,defaultValue));
    }

    public static int getInt(String key,int defaultValue)
    {
        return Integer.parseInt(getProperty(key,String.valueOf(defaultValue)));
    }

    public static boolean getBoolean(String key,boolean defaultValue)
    {
        return Boolean.parseBoolean(getProperty(key,String.valueOf(defaultValue)));
    }
}
