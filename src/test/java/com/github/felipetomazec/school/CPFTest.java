package com.github.felipetomazec.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CPFTest {
    @Test
    public void shouldNotHaveMoreThan11Characters() {
        assertThrows(IllegalArgumentException.class, () -> CPF.getInstance("123456789123"));
    }

    @Test
    public void shouldNotHaveLessThan11Characters() {
        assertThrows(IllegalArgumentException.class, () -> CPF.getInstance("1234567891"));
    }

    @Test
    public void shouldRemoveExtraSpaces() {
        var number = "12345678912";
        var numberWithExtraSpaces = String.format("     %s     ", number);
        var cpf = CPF.getInstance(numberWithExtraSpaces);

        assertNotNull(cpf);
        assertEquals(number, cpf.getNumber());
    }

    @Test
    public void shouldHaveOnlyNumbers() {
        assertThrows(IllegalArgumentException.class, () -> CPF.getInstance("1234567891a"));
        assertThrows(IllegalArgumentException.class, () -> CPF.getInstance("1234567891$"));
        assertThrows(IllegalArgumentException.class, () -> CPF.getInstance("1234567891^"));
    }
}
