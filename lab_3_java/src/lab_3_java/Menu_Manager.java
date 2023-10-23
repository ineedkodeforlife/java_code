package lab_3_java;
import java.util.Scanner;

public class Menu_Manager {
	private static String log_pass;
	private static boolean flag_debug = false;
	private static boolean Flag = false;
	
	public static boolean Valid(String log_pas) {
		String[] parts = log_pas.split(" ");
		if (parts[0].equals(SettingsManager.nickname) && parts[1].equals(SettingsManager.password)) {
			Flag = true;
		}
		return Flag;
	}
	
	public static void Menu(String s) {
		switch(s) {
		case "1":
			System.out.println("You enter digit '1' enter your login and password");
			Scanner scanner = new Scanner(System.in);
	        log_pass = scanner.nextLine();
	        Menu_Manager.Valid(log_pass);
	        break;
	        
		case "2":
			System.out.println("You enter digit '2' you wanna debug mode");
			if (Flag){
				flag_debug = !flag_debug;
				System.out.println("Debug mode has meaning :" + flag_debug + " if you need to chenge it enter 2");
			}else {
			System.out.println("You don't have rights for this");
		}
			break;
			
		case "3":
			System.out.println("You enter digit '3' you wanna test mode");
			//Now in implementation
			break;
	}
	}
	
	public static boolean getFlagDebug(){
		return flag_debug;
	}

	

}
