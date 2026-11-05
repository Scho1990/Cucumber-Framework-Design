package context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private final Map<String , Object> scenarioContext;

    public TestContext() {
        scenarioContext = new HashMap<>();
    }

    //Store data
    public void set(String key, Object value) {
        scenarioContext.put(key, value);
    }

    //Retrieve data
    public Object get(String key) {
        return scenarioContext.get(key);
    }

    //Retrieve data with generic type
    public <T> T get(String key, Class<T> clazz) {
        Object value = scenarioContext.get(key);
        if (value == null) {
            throw new IllegalArgumentException(key + " not found");
        }
        return clazz.cast(value);
    }

    //Check whether key exists
    public boolean containsKey(String key) {
        return scenarioContext.containsKey(key);
    }

    //Remove specific data
    public void remove(String key) {
        scenarioContext.remove(key);
    }

    //Clear all scenario data
    public void clear() {
        scenarioContext.clear();
    }
}
