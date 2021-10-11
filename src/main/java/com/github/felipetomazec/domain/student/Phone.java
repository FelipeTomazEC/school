package com.github.felipetomazec.domain.student;

public class Phone {
    private String number;
    private String ddd;

    public Phone (String ddd, String number) {
        var numberWithoutSpaces = number.trim();
        var dddWithoutSpaces = ddd.trim();

        if(!isValidDDD(dddWithoutSpaces)) {
            var message = String.format("%s is not a valid DDD.", dddWithoutSpaces);
            throw new IllegalArgumentException(message);
        }

        if(!isValidNumber(numberWithoutSpaces)) {
            var message = String.format("%s is not a valid phone number.", numberWithoutSpaces);
            throw new IllegalArgumentException(message);
        }

        this.ddd = dddWithoutSpaces;
        this.number = numberWithoutSpaces;
    }

    public String getPhoneNumber() {
        return String.format("(%s) %s", ddd, number);
    }

    private boolean isValidNumber(String number) {
        return number.matches("^[0-9]{8,9}$");
    }

    private boolean isValidDDD(String ddd) {
        return ddd.matches("^[0-9]{2}$");
    }
}
