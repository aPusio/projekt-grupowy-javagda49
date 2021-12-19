package com.sda;

import com.sda.utils.MainMenu;
import com.sda.utils.UserIoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserIoService userIoService = new UserIoService();
        MainMenu mainMenu = new MainMenu();
        userIoService.printOnScreen(mainMenu.createMenu());
        String userOption = userIoService.getInt("Wpisz numer gry:");
        switch (userOption){
            case "1":
                System.out.println("Implement me 🤣🤣");
                break;
            case "2":
                System.out.println("Implement me 🤣🤣");
                break;
            case "3":
                System.out.println("Implement me 🤣🤣");
                break;
            case "4":
                System.out.println("Implement me 🤣🤣");
                break;
            case "q":
                return;
            default:
                System.out.println("Option Not recognized");
        }
    }
}
