package com.github.felipetomazec.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void shouldHaveAtMarker() {
        assertThrows(IllegalArgumentException.class, () -> Email.getInstance("not.email.com"));
    }

    @Test
    public void shouldNotHaveMoreThanOneDot() {
        assertThrows(IllegalArgumentException.class, () -> Email.getInstance("email@email..com"));
    }

    @Test
    public void shouldCreateAnEmailInstance() {
        var address = "email@email.com";
        var email = Email.getInstance(address);

        assertNotNull(email);
        assertEquals(address, email.getAddress());
    }

    @Test
    public void shouldNotBeEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Email.getInstance("   "));
    }

    @Test
    public void shouldRemoveExtraSpaces() {
        var address = "      email@email.com      ";
        var email = Email.getInstance(address);

        assertNotNull(email);
        assertEquals(email.getAddress(), "email@email.com");
    }
}
