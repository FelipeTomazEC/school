package com.github.felipetomazec.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneTest {
    @Test
    public void shouldNotHaveLessThan10Numbers() {
        assertThrows(IllegalArgumentException.class, () -> Phone.getInstance("311234567"));
    }

    @Test
    public void shouldNotHaveMoreThan11Numbers() {
        assertThrows(IllegalArgumentException.class, () -> Phone.getInstance("123456789123"));
    }

    @Test
    public void shouldRemoveExtraSpaces() {
        var number = "31987654321";
        var numberWithSpaces = String.format("      %s       ", number);
        var phone = Phone.getInstance(numberWithSpaces);

        assertEquals(number, phone.getNumber());
    }
}
