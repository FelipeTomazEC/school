package com.github.felipetomazec.school;

public class Phone {
    private String number;
    private String ddd;

    private Phone (String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public static Phone getInstance(String ddd, String number) {
        var numberWithoutSpaces = number.trim();
        var dddWithoutSpaces = ddd.trim();

        if(!numberWithoutSpaces.matches("^[0-9]{8,9}$")) {
            throw new IllegalArgumentException(String.format("%s is not a valid phone number.", numberWithoutSpaces));
        }

        if(!dddWithoutSpaces.matches("^[0-9]{2}$")) {
            throw new IllegalArgumentException(String.format("%s is not a valid DDD.", dddWithoutSpaces));
        }

        return new Phone(dddWithoutSpaces, numberWithoutSpaces);
    }

    public String getPhoneNumber() {
        return String.format("(%s) %s", ddd, number);
    }
}
