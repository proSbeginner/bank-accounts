package com.pros;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestException {
    public static void main(String[] args) {
        System.out.println("TestException main....");
        try {
            System.out.println(args[0]);
        } catch (NullPointerException e) {
            System.out.println("End bad program: " + e.getMessage());
        }
    }
}

class MyMath {
    public static void main(String[] args) {
        System.out.println("My Math main....");
        TestException.main(null);
    }
}
