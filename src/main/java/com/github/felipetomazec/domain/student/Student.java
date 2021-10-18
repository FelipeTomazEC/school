package com.github.felipetomazec.domain.student;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private CPF cpf;
    private Email email;
    private Set<Phone> phones;

    public Student (String name, CPF cpf, Email email) {
        if(name == null) {
            throw new IllegalArgumentException("A student must have a name.");
        }

        if(cpf == null) {
            throw new IllegalArgumentException("A student must have a CPF.");
        }

        if(email == null) {
            throw new IllegalArgumentException("A student must have an e-mail.");
        }

        this.cpf = cpf;
        this.name = name.trim();
        this.email = email;
        this.phones = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf.getNumber();
    }

    public String getEmail() {
        return email.getAddress();
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void addPhone(String ddd, String number) {
        var phone = new Phone(ddd, number);
        phones.add(phone);
    }
}
