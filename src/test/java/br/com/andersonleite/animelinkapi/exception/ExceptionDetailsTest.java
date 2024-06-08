package br.com.andersonleite.animelinkapi.exception;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionDetailsTest {

    @Test
    public void testExceptionDetailsCreation() {
        LocalDateTime timestamp = LocalDateTime.now();

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Test Exception")
                .status(500)
                .details("Test details")
                .developerMessage("Developer message")
                .timestamp(timestamp)
                .build();

        assertNotNull(exceptionDetails);
        assertEquals("Test Exception", exceptionDetails.getTitle());
        assertEquals(500, exceptionDetails.getStatus());
        assertEquals("Test details", exceptionDetails.getDetails());
        assertEquals("Developer message", exceptionDetails.getDeveloperMessage());
        assertEquals(timestamp, exceptionDetails.getTimestamp());
    }

    @Test
    public void testEqualsAndHashCode() {
        LocalDateTime timestamp = LocalDateTime.now();

        ExceptionDetails exceptionDetails1 = ExceptionDetails.builder()
                .title("Test Exception")
                .status(500)
                .details("Test details")
                .developerMessage("Developer message")
                .timestamp(timestamp)
                .build();

        ExceptionDetails exceptionDetails2 = ExceptionDetails.builder()
                .title("Test Exception")
                .status(500)
                .details("Test details")
                .developerMessage("Developer message")
                .timestamp(timestamp)
                .build();

        // Verifica que os objetos são iguais
        assertEquals(exceptionDetails1, exceptionDetails2);
        assertEquals(exceptionDetails1.hashCode(), exceptionDetails2.hashCode());

        // Altera um campo e verifica que os objetos não são mais iguais
        exceptionDetails2.setTitle("Different Title");
        assertNotEquals(exceptionDetails1, exceptionDetails2);
        assertNotEquals(exceptionDetails1.hashCode(), exceptionDetails2.hashCode());
    }

    @Test
    public void testToString() {
        LocalDateTime timestamp = LocalDateTime.now();

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Test Exception")
                .status(500)
                .details("Test details")
                .developerMessage("Developer message")
                .timestamp(timestamp)
                .build();

        String expectedToString = "ExceptionDetails(title=Test Exception, status=500, details=Test details, " +
                "developerMessage=Developer message, timestamp=" + timestamp.toString() + ")";

        assertEquals(expectedToString, exceptionDetails.toString());
    }
}
