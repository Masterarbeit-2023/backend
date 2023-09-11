package com.example.backend;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ClassInspector {
    public static void main(String[] args) {
        // Replace "YourClassName" with the name of the class you want to inspect
        String className = "com.example.backend.controller.Test";


    }

    public static void inspect(String className) {
        try {
            // Load the class
            Class<?> clazz = Class.forName(className);

            // Get all fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println("Name: " + field.getName() + ", Type: " + field.getType());

                // Get annotations on the field
                Annotation[] fieldAnnotations = field.getAnnotations();
                for (Annotation annotation : fieldAnnotations) {
                    System.out.println("  Annotation: " + annotation.annotationType().getName());
                }
            }

            // Get all methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.print("Name: " + method.getName() + ", Return Type: " + method.getReturnType());

                // Get method parameters
                Parameter[] parameters = method.getParameters();
                System.out.print(", Parameters: ");
                for (Parameter parameter : parameters) {
                    System.out.print(parameter.getType() + " " + parameter.getName() + ", ");
                }

                // Get annotations on the method
                Annotation[] methodAnnotations = method.getAnnotations();
                System.out.print(", Annotations: ");
                for (Annotation annotation : methodAnnotations) {
                    System.out.print(annotation.annotationType().getName() + ", ");
                }

                String sourceFileName = "src/main/java/com/example/backend/controller/Test.java";
                String body = MethodSourceCodeExtractor.readMethod(className, method.getName(), sourceFileName);
                System.out.println("Body: " + body);

                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
