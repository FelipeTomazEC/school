package com.github.felipetomazec.school;

import java.util.regex.Pattern;

public class Email {
    private final String address;

    private Email(String address) {
        this.address = address;
    }

    public static Email getInstance(String address) {
        var addressWithoutExtraSpaces = address.trim();
        var emailPattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", Pattern.CASE_INSENSITIVE);
        var doubleDotPattern = Pattern.compile("\\.(\\.)+");
        var hasEmailFormat = emailPattern
                .matcher(addressWithoutExtraSpaces)
                .matches();
        var hasDoubleDot = doubleDotPattern
                .matcher(addressWithoutExtraSpaces)
                .matches();
        var isInvalid = hasDoubleDot || !hasEmailFormat;

        if(isInvalid) {
            throw new IllegalArgumentException(String.format("%s is not a valid e-mail.", address));
        }

        return new Email(addressWithoutExtraSpaces);
    }

    public String getAddress() {
        return address;
    }
}
