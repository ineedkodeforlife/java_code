package lab_3_java;


import java.io.*;
import java.util.Scanner;
import lab_3_java.Underwear;
import lab_3_java.Underwear_Color;
import lab_3_java.Washer;
import lab_3_java.DatabaseManager;
import java.util.Scanner;
import java.time.*;
import lab_3_java.SettingsManager;
import lab_3_java.Menu_Manager;


public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String userInput;
		SettingsManager.param_setting("C:\\Users\\Vitaliy\\eclipse-workspace\\lab_3_java\\settings");
		Underwear u1 = new Underwear(20, 25);
		Underwear_Color u_c1 = new Underwear_Color("white");
		Washer[] myObjects = new Washer[3];
		myObjects[0] = new Washer("liquid", "mif", "black", 40);
		myObjects[1] = new Washer("dry", "mif", "colored", 60);
		myObjects[2] = new Washer("dry", "arial", "white", 20);
		
		for (Washer obj: myObjects) {
			if(obj.Load(u_c1, u1) == 1) {
				break;
			}
		}
		
		while(true) {
			System.out.println("Menu: ");
            System.out.println("1. Ener login and password in one string");
            System.out.println("2. Debug mode");
            System.out.println("3. Test mode");
            userInput = scanner.nextLine();
            if (userInput.equals("1") ||  userInput.equals("2") || userInput.equals("3")) {
            	System.out.println(SettingsManager.nickname + " " + SettingsManager.password);
            	Menu_Manager.Menu(userInput);
            	if (Menu_Manager.getFlagDebug()) {
            		LocalTime time = LocalTime.now();
            		DatabaseManager.addDataToFile("C:\\Users\\Vitaliy\\eclipse-workspace\\lab_3_java\\log-file", String.valueOf(time));
            	}
            	}
            else {
            	break;
            	}
		}

	}
}
