package com.example.backend;

import com.example.library.annotation.classes.ApiController;

import java.io.IOException;

public class ClassScannerTest {

    public static void main(String[] args) {
        try {
            System.out.println(ClassScanner.getClassesWithAnnotation("com.example.backend", ApiController.class));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
