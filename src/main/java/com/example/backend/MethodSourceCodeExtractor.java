package com.example.backend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MethodSourceCodeExtractor {
    public static void main(String[] args) {
        String className = "com.example.backend.controller.Test";
        String sourceFileName = "src/main/java/com/example/backend/controller/Test.java";
        String methodName = "test2";

        try {
            // Load the class using reflection to get the source file location
            Class<?> clazz = Class.forName(className);
            //String sourceFileName = clazz.getSimpleName() + ".java";

            // Read the source code file
            String sourceCode = readFile(sourceFileName);

            // Search for the method and extract its source code
            String methodPattern = ".*\\b" + methodName + "\\b.*?\\{([^\\}]+)\\}";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(methodPattern, java.util.regex.Pattern.DOTALL);
            java.util.regex.Matcher matcher = pattern.matcher(sourceCode);

            while (matcher.find()) {
                String methodSourceCode = matcher.group(1);
                System.out.println("Method Source Code:");
                System.out.println(methodSourceCode);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static String readMethod(String className, String methodName, String sourceFileName){
        try {
            // Load the class using reflection to get the source file location
            Class<?> clazz = Class.forName(className);
            //String sourceFileName = clazz.getSimpleName() + ".java";

            // Read the source code file
            String sourceCode = readFile(sourceFileName);

            // Search for the method and extract its source code
            String methodPattern = ".*\\b" + methodName + "\\b.*?\\{([^\\}]+)\\}";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(methodPattern, java.util.regex.Pattern.DOTALL);
            java.util.regex.Matcher matcher = pattern.matcher(sourceCode);

            String methodSourceCode = null;
            while (matcher.find()) {
                methodSourceCode = matcher.group(1);
                //System.out.println("Method Source Code:");
                //System.out.println(methodSourceCode);
            }
            return methodSourceCode;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
