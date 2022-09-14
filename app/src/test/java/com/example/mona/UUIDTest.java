package com.example.mona;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.UUID;

public class UUIDTest {

    @Test
    public void generateUuidSuccessfully() {
        // Given
        UUID uuid = UUID.randomUUID();

        // When
        String uuidString = uuid.toString();

        // Then
        // Example: 61a6cae6-6af2-4b4b-b11c-33282deaaf4a
        assertTrue(uuidString.length() > 0);
        assertNotNull(uuidString);
    }
}
