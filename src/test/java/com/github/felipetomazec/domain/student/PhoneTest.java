package com.github.felipetomazec.domain.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneTest {
    @Test
    public void shouldNotHaveNumberWithLessThan8Numbers() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("31", "1234567"));
    }

    @Test
    public void shouldNotHaveNumberWithMoreThan9Numbers() {
        assertThrows(IllegalArgumentException.class, () -> new Phone("31", "123456789123"));
    }

    @Test
    public void shouldRemoveExtraSpaces() {
        var ddd = "31";
        var dddWithSpaces = String.format("     %s  ", ddd);
        var number = "987654321";
        var numberWithSpaces = String.format("      %s       ", number);
        var phone = new Phone(dddWithSpaces, numberWithSpaces);
        var phoneNumber = String.format("(%s) %s", ddd, number);

        assertEquals(phoneNumber, phone.getPhoneNumber());
    }

    @Test
    public void shouldHaveDDDWith2Numbers () {
        var dddWithMoreThan2Numbers = "031";
        var dddWithLessThan2Numbers = "3";
        var number = "994856589";

        assertThrows(IllegalArgumentException.class, () -> new Phone(dddWithMoreThan2Numbers, number));
        assertThrows(IllegalArgumentException.class, () -> new Phone(dddWithLessThan2Numbers, number));
    }
}
