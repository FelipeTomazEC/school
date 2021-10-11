package com.github.felipetomazec.domain.student;

import java.util.regex.Pattern;

public class Email {
    private final String address;

    public Email(String address) {
        var addressWithoutSpaces = address.trim();
        if(!isValid(addressWithoutSpaces)) {
            throw new IllegalArgumentException(String.format("%s is not a valid e-mail.", address));
        }

        this.address = addressWithoutSpaces;
    }

    public String getAddress() {
        return address;
    }

    private boolean isValid(String address) {
        var emailPattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", Pattern.CASE_INSENSITIVE);
        var doubleDotPattern = Pattern.compile("\\.(\\.)+");
        var hasEmailFormat = emailPattern
                .matcher(address)
                .matches();
        var hasDoubleDot = doubleDotPattern
                .matcher(address)
                .matches();

        return hasEmailFormat && !hasDoubleDot;
    }
}
