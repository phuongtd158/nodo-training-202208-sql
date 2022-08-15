package com.demo.main;

public class StringExample {
    public static void main(String[] args) {
//        example1();
        example6();
    }

    public static void example1() {
        String text = "Say hello to everyone";
        System.out.println("Length of text is: " + text.length());

        System.out.println("Vi tri cua phan tu hello la: " + text.indexOf("to"));

        System.out.println("Cat tu: " + text.substring(4, 8));
    }

    public static void example2() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String text = new String(chars);
        System.out.println(text);

        text = text.concat(" ");
        text = text.concat("Tran Duc Phuong");
        System.out.println("New text is: " + text);

        System.out.println("Hello java".equals(text));
    }

    public static void example3() {
        String text = "Absolute value";
        byte[] bytes = text.getBytes();
        System.out.print("Bye values are: ");

        for (int i = 0; i < bytes.length; i++) {
            System.out.print((int) bytes[i] + ", ");
        }
    }

    public static void example4() {
        String text = "Say hello to everybody";
        System.out.println("Length of text is: " + text.length());

        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            System.out.println("Character at " + i + " is: " + c);
            i++;
        }
    }

    public static void example5() {
        byte[] bytes = {99, -58, -80, -31, -69, -101, 112, 44, 32,
                104, 105, -31, -70, -65, 112, 44, 32, 103, 105, -31, -70, -65, 116};

        try {
            System.out.println(new String(bytes, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void example6() {
        String[][] values = {
                {"Tran", "Van", "A"},
                {"Tran", "Thi", "B"}
        };

        for (int i = 0; i < values.length; i++) {
            System.out.print("|");
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(i + "," + j + "|");
            }
            System.out.println();
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(values[i][j] + "|");
            }
            System.out.println();
        }
    }
}
