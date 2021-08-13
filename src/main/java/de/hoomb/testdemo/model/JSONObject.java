package de.hoomb.testdemo.model;

import java.util.UUID;

public class JSONObject {
    private UUID id;
    private String param1;
    private String param2;

    public JSONObject(final String param1, final String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public JSONObject(final String param1) {
        this.param1 = param1;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(final String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(final String param2) {
        this.param2 = param2;
    }
}
