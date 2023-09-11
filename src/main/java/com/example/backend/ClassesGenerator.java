package com.example.backend;

import com.example.library.annotation.classes.ApiController;

import java.io.IOException;
import java.util.List;

public class ClassesGenerator {
    public static void main(String[] args) {
        // Read yaml file
        List<Class<?>> classes;
        try {
            classes = ClassScanner.getClassesWithAnnotation("com.example.backend", ApiController.class);
            System.out.println(classes);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Class<?> c: classes) {
            ClassInspector.inspect(c.getName());
        }

        // Generate classes
    }
}
