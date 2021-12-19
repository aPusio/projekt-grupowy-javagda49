package com.sda.utils;

import java.util.List;
import java.util.Scanner;

public class UserIoService {

    public String getString(String message){
        if(message != null && !message.equals("")) {
            System.out.println(message);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String getInt(String message){
        if(message != null && !message.equals("")) {
            System.out.println(message);
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void printOnScreen(List<String> content){
        content.forEach(System.out::println);
    }
}
