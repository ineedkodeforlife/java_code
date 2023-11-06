package lab_4_java;



public class SettingsManager {
	public static String nickname, password, role;

	public static void param_setting(String filename) {
		String[] new_data = DatabaseManager.readDataFromFile(filename);
		nickname = new_data[0];
		password = new_data[1];
		role = new_data[2];
	}
	
}
