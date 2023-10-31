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
		SettingsManager.param_setting("C:\\Users\\lotarev_rv\\Downloads\\java_code-main\\java_code\\lab_3_java\\settings");
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
            System.out.println("4. Read file");
            System.out.println("5. Write information to file");
            System.out.println("6. Delete information from file");
            System.out.println("0. Exit");
            userInput = scanner.nextLine();
            if (userInput.equals("1") ||  userInput.equals("2") || userInput.equals("3") || userInput.equals("4")) {
            	System.out.println(SettingsManager.nickname + " " + SettingsManager.password);
            	Menu_Manager.Menu(userInput);
            	if (Menu_Manager.getFlagDebug()) {
            		LocalTime time = LocalTime.now();
            		DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\Downloads\\java_code-main\\java_code\\lab_3_java\\log-file", SettingsManager.nickname);
            		DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\Downloads\\java_code-main\\java_code\\lab_3_java\\log-file", String.valueOf(time));
            	}
            	}
            else if(userInput.equals("5")) {
            	DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\Downloads\\java_code-main\\java_code\\lab_3_java\\data_file",String.valueOf(LocalTime.now()) + "-" +  u1.toString());
            }else if(userInput.equals("6")) {
            	String new_user_input = scanner.nextLine();
            	DatabaseManager.deleteData("C:\\Users\\lotarev_rv\\Downloads\\java_code-main\\java_code\\lab_3_java\\data_file", new_user_input);
            	
            }
            else {
            	scanner.close();
            	break;
            	}
		}

	}
}
