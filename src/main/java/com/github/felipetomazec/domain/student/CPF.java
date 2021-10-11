package com.github.felipetomazec.domain.student;

public class CPF {
    private String number;

    public CPF(String number) {
        var numberWithoutSpaces = number.trim();
        if(!numberWithoutSpaces.matches("^[0-9]{11}$")) {
            throw new IllegalArgumentException("%s is not a valid CPF. A CPF must have 11 numeric characters.");
        }

        this.number = numberWithoutSpaces;
    }

    public String getNumber() {
        return this.number;
    }
}
