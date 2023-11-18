package com.example.backend;

import io.github.masterarbeit.Main;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryRunner {
    public static void main(String[] args) {

        String test = new Exception().getStackTrace()[0].getClassName();
        Main.generate("", test);
    }
}
