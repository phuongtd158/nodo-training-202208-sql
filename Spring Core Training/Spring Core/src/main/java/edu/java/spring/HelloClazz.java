package edu.java.spring;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {
    String message;
    private List<JavaClazz> clazzes;

    public HelloClazz() {
        message = "From constructor: Say hello everyone!";
    }

    public HelloClazz(int person) {
        message = "From constructor: Say hello " + person + " persons";
    }

    public HelloClazz(HelloClazz clazz) {
        message = clazz.message;
    }

    private void initMessage() {
        System.out.println("Calling init method...");
        message = "From init method: Say hello bean!";
    }

    public void setMessage(String message) {
        this.message = "Call from setter:" + message;
    }

    public void printMessage() {
        System.out.println("Your message: " + message);
    }

    private void release() {
        message = null;
        System.out.println("Message is null");
    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("Message is null");
    }

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }
}
