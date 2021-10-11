package com.github.felipetomazec.domain.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void shouldHaveAtMarker() {
        assertThrows(IllegalArgumentException.class, () -> new Email("not.email.com"));
    }

    @Test
    public void shouldNotHaveMoreThanOneDot() {
        assertThrows(IllegalArgumentException.class, () -> new Email("email@email..com"));
    }

    @Test
    public void shouldCreateAnEmailInstance() {
        var address = "email@email.com";
        var email = new Email(address);

        assertNotNull(email);
        assertEquals(address, email.getAddress());
    }

    @Test
    public void shouldNotBeEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new Email("   "));
    }

    @Test
    public void shouldRemoveExtraSpaces() {
        var address = "      email@email.com      ";
        var email = new Email(address);

        assertNotNull(email);
        assertEquals(email.getAddress(), "email@email.com");
    }
}
