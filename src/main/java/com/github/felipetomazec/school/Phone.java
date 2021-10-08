package com.github.felipetomazec.school;

public class Phone {
    private String number;

    private Phone (String number) {
        this.number = number;
    }

    public static Phone getInstance(String number) {
        var numberWithoutSpaces = number.trim();
        if(!numberWithoutSpaces.matches("^[0-9]{10,11}$")) {
            throw new IllegalArgumentException(String.format("%s is not a valid phone number.", numberWithoutSpaces));
        }

        return new Phone(numberWithoutSpaces);
    }

    public String getNumber() {
        return number;
    }
}
