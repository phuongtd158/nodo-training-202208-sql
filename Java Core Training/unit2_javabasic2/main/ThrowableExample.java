package com.demo.unit2_javabasic2.main;

public class ThrowableExample {
    public static void main(String[] args) {
        try {
            System.out.println("Number: " + toNumber("1a"));
        } catch (SaiSoException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int toNumber(String value) throws SaiSoException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new SaiSoException(value);
        }
    }

    public static class SaiSoException extends Exception {
        private String number;

        public SaiSoException(String value) {
            this.number = value;
        }

        public String getMessage() {
            return number + " not is number ";
        }
    }

}
