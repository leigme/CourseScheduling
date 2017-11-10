package me.leig.tools.comm;

import java.io.Serializable;

public class ConfigBean implements Serializable {

    private boolean debug;

    private String driver;

    private String dbUrl;

    private String conditionPath;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getConditionPath() {
        return conditionPath;
    }

    public void setConditionPath(String conditionPath) {
        this.conditionPath = conditionPath;
    }
}
