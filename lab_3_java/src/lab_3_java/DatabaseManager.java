package lab_3_java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class DatabaseManager {
    public static void writeDataToFile(String fileName, String data[]) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String item : data) {
                writer.println(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void addDataToFile(String fileName, String newData) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(newData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static String[] readDataFromFile(String fileName) {
    	try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int size = 40;
            
            String[] data = new String[size];
            
            
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                data[index] = line;
                index++;
            }
            String[] new_data = new String[index];
            
            for (int i = 0; i < index; i++) {
            	new_data[i] = data[i];
            }
            
            return new_data;
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0]; // Возврат пустого массива в случае ошибки
        }
    }
    
    public static void deleteData(String fileName, String id) {
    	String[] s = DatabaseManager.readDataFromFile(fileName);
    	ArrayList<String> arrayList = new ArrayList<>();
   
    	
    	for (String item:  s) {
    		String[] split_arr = item.split("-");
    		if (!split_arr[0].equals(id)) {
    			arrayList.add(item);
    		}
    	}
    		
    	String[] new_s = new String[arrayList.size()];
    	
    	new_s = arrayList.toArray(s);
    	DatabaseManager.writeDataToFile(fileName, new_s);
    	
    	
    	
    }
    
    public static void changeData(String fileName, String id, String newData) {
    	String[] s = DatabaseManager.readDataFromFile(fileName);
    	int counter = 0;
    	for (String item:  s) {
    		if (id.contains(item)) {
    			break;
    		}
    		counter ++;
    		

    	s[counter] = newData;
    	DatabaseManager.writeDataToFile(fileName, s);
    	
    	
    	}
    	
    }
    
    
}
