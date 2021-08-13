package de.hoomb.testdemo.service;

import de.hoomb.testdemo.model.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {

    private static final String PARAM1_TEST = "DUMMY_1";
    private static final String PARAM2_TEST = "DUMMY_2";
    private static final String PARAM3_TEST = "DUMMY_3";

    @Spy
    @InjectMocks
    private MyService myService;

    @Test
    void testMyPublicMethod() {
        final JSONObject mockedJsonObject = new JSONObject(PARAM3_TEST);
        when(myService.myPublicMethod(anyString())).thenReturn(mockedJsonObject);

        final JSONObject jsonObject = myService.myPublicMethod("Test");

        assertNotNull(jsonObject);
        assertEquals(PARAM3_TEST, jsonObject.getParam1());
        assertNull(jsonObject.getParam2());
    }

    @Test
    void testProcess() {
        final JSONObject mockedJsonObject = new JSONObject(PARAM1_TEST, PARAM2_TEST);
        when(ReflectionTestUtils.invokeMethod(myService, "myProtectedMethod", "Param1", "Param2")).thenReturn(mockedJsonObject);

        final JSONObject jsonObject = myService.process("Param1", "Param2");

        assertNotNull(jsonObject);
        assertEquals(PARAM1_TEST, jsonObject.getParam1());
        assertEquals(PARAM2_TEST, jsonObject.getParam2());
    }
}
