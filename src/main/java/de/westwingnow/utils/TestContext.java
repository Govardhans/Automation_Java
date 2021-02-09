package de.westwingnow.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Test context has Map<string, object>
 *  this can be used to store result of the test step and
 *  share with other test steps
 */
public class TestContext {

    private Map<String, Object> scenarioContext;

    public TestContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getContext(String key) {
        return scenarioContext.get(key);
    }

    public Boolean isContains(String key) {
        return scenarioContext.containsKey(key);
    }

}