package lab_4_java;

public class recording_error_handling {
		
	
	private static int counter_error = 0;
	
	public static void recording_write(String value) {
		try {
			
		DatabaseManager.addDataToFile("C:\\\\Users\\\\lotarev_rv\\\\eclipse-workspace\\\\lab_4_java\\\\log-file", value);
		}
		 catch (Exception  e) {
	            DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\log-file", e.getMessage());
	            counter_error++;
	        }
	}
	
	public static void recording_user_input(String usr_inp) {
	
		try {	
			int number = Integer.parseInt(usr_inp);
			
			if (number < 0 || number > 6) {
				throw new IllegalArgumentException("Число вне диапазона от 1 до 6.");
			}
		}
		catch(Exception e) {
			DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\log-file", e.getMessage());
            counter_error++;
		}
		
	}
	
	
	public static void write_end_programm() {
		DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\log-file","Ошибок за выполнение программы: " +  String.valueOf(counter_error));
	}
	
	public static void write_time(String type,long time) {
		DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\log-file", type + ", " + String.valueOf(time));
	}
	
	

}
