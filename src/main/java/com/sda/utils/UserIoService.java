package com.sda.utils;

import java.util.Scanner;

public class UserIoService {

    public String getString(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
