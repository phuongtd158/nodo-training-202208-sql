package edu.java.spring;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class);
    public String message;
    String a;

    @Autowired(required = true)
    private HelloClazz clazz;

    public HelloWorld() {
    }

    public HelloWorld(String name, HelloClazz clazz) {
        message = "From HelloWorld constructor: " + name + " : " + clazz.message;
    }

    public void sayHello() {
        clazz.printMessage();
        LOGGER.info("From hello world: " + message);
    }

    @Required
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setClazz(HelloClazz clazz) {
        this.clazz = clazz;
    }

    public HelloClazz getClazz() {
        return clazz;
    }
}
