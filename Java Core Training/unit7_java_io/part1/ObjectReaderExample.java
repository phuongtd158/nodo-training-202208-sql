package com.demo.unit7_java_io.part1;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectReaderExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        File folder = new File("C:\\Temp\\test1\\");
        FileInputStream fileInputStream = new FileInputStream(new File(folder, "my_object.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();
        Method method = object.getClass().getMethod("run", new Class[0]);
        method.invoke(object, new Object[0]);

        objectInputStream.close();
        fileInputStream.close();
    }
}
