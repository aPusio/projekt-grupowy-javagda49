package com.sda.games.wheelOfFortune.methods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    static boolean letterValidation(String letter) {
        Pattern pattern = Pattern.compile("[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ@]{1}");
        Matcher matcher = pattern.matcher(letter);
        return matcher.matches();
    }
}
