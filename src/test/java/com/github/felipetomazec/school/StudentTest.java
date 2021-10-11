package com.github.felipetomazec.school;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    String name = "George White";
    CPF cpf = new CPF("12345678912");
    Email email = new Email("email@email.com");

    @Test
    public void shouldHaveAName() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, cpf, email));
    }

    @Test
    public void shouldHaveAnEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Student(name, cpf, null));
    }

    @Test
    public void shouldHaveCPF() {
        assertThrows(IllegalArgumentException.class, () -> new Student(name, null, email));
    }

    @Test
    public void shouldRemoveSpacesFromName() {
        var nameWithSpaces = String.format("   %s   ", name);
        var student = new Student(nameWithSpaces, cpf, email);

        assertEquals(name, student.getName());
    }

    @Test
    public void shouldAddPhone() {
        var student = new Student(name, cpf, email);
        student.addPhone("31", "995659878");

        assertEquals(1, student.getPhones().size());
        assertTrue(student
                .getPhones()
                .stream()
                .anyMatch((p) -> p.getPhoneNumber().equals("(31) 995659878"))
        );
    }
}
