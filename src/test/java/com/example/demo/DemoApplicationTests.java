package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoApplicationTests {

    @Test
    void testHello() {
        String message = "CI Spring Boot Application Running Successfully!";
        assertEquals("CI Spring Boot Application Running Successfully!", message);
    }
}