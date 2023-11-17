package com.example.backend;

import com.example.library.Main;

public class LibraryRunner {
    public static void main(String[] args) {

        String test = new Exception().getStackTrace()[0].getClassName();
        Main.generate("", test);
    }
}
