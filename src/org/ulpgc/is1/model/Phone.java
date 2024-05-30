package org.ulpgc.is1.model;


public class Phone {
    private String number;


    public Phone(String number) {
        if (isValid(number)) {
            this.number = number;
        } else {
            this.number = "XXXX";
        }
    }

    public static boolean isValid(String number) {
        return number.matches("\\d{10}");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (isValid(number)) {
            this.number = number;
        } else {
            this.number = "XXXX";
        }
    }
}