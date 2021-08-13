package de.hoomb.testdemo.service;

import de.hoomb.testdemo.model.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    protected JSONObject myProtectedMethod(final String param1, final String param2) {
        return new JSONObject(param1, param2);
    }

    public JSONObject myPublicMethod(final String param1) {
        return new JSONObject(param1);
    }

    public JSONObject process(final String param1, final String param2) {
        return myProtectedMethod(param1, param2);
    }
}
