package com.demo.unit2_javabasic2.main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {

    private final static Logger LOGGER = Logger.getLogger(ThrowableExample.class.getName());

    public static void main(String[] args) {
        try {
            System.out.println("Number: " + toNumber("1a"));
        } catch (SaiSoException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
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
