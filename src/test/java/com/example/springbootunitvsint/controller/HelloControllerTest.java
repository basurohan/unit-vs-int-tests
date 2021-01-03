package com.example.springbootunitvsint.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    @Test
    void hello() {
        // Given
        HelloController controller = new HelloController();

        // When
        String response = controller.hello("World");

        // Then
        assertEquals("Hello, World", response);
    }
}