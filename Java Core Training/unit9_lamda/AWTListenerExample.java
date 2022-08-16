package com.demo.unit9_lamda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTListenerExample {
    public static void main(String[] args) {
        JFrame screen = new JFrame();
        Button button = new Button("Click");

        button.setSize(10, 5);
        screen.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Welcome to Java by Example",
                        "Java Sample",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        screen.setSize(250, 400);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
    }
}
