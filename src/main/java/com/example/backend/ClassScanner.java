package com.example.backend;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class ClassScanner {
    public static List<Class<?>> getClassesWithAnnotation(String packageName, Class<?> annotationClass)
            throws ClassNotFoundException, IOException {
        List<Class<?>> classesWithAnnotation = new ArrayList<>();

        String path = "src/main/java/" + packageName.replace('.', '/');
        File directory = new File(path);
        if (!directory.exists()) {
            return classesWithAnnotation;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".java")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 5);
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent((Class<? extends Annotation>) annotationClass)) {
                        classesWithAnnotation.add(clazz);
                    }
                } else if (file.isDirectory()) {
                    // Recursively scan sub-packages
                    String subPackageName = packageName + "." + file.getName();
                    classesWithAnnotation.addAll(getClassesWithAnnotation(subPackageName, annotationClass));
                }
            }
        }

        return classesWithAnnotation;
    }
}
