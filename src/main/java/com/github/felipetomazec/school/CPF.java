package com.github.felipetomazec.school;

public class CPF {
    private String number;

    private CPF(String number){
        this.number = number;
    }

    public static CPF getInstance(String number) {
        var numberWithoutSpaces = number.trim();
        if(!numberWithoutSpaces.matches("^[0-9]{11}$")) {
            throw new IllegalArgumentException("%s is not a valid CPF. A CPF must have 11 numeric characters.");
        }

        return new CPF(numberWithoutSpaces);
    }

    public String getNumber() {
        return this.number;
    }
}
