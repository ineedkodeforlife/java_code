package lab_4_java;


import java.util.Scanner;
import java.time.*;
import java.util.ArrayList;
import java.util.LinkedList;



public class Main {
	public static void main(String[] args) {
	
            
            
        Scanner scanner = new Scanner(System.in);
        String userInput;
		SettingsManager.param_setting("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\settings");
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
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("Menu: ");
            System.out.println("1. Ener login and password in one string");
            System.out.println("2. Debug mode");
            System.out.println("3. Read file");
            System.out.println("4. Write information to file");
            System.out.println("5. Delete information from file");
            System.out.println("0. Exit");
            userInput = scanner.nextLine();
            recording_error_handling.recording_user_input(userInput);
            if (userInput.equals("1") ||  userInput.equals("2") || userInput.equals("3")) {
            	System.out.println(SettingsManager.nickname + " " + SettingsManager.password);
            	Menu_Manager.Menu(userInput);
            	if (Menu_Manager.getFlagDebug()) {
            		LocalTime time = LocalTime.now();
            		DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\log-file", SettingsManager.nickname);
            		DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\log-file", String.valueOf(time));
            	}
            	}
            else if(userInput.equals("4")) {
            	recording_error_handling.recording_write(String.valueOf(LocalTime.now()) + "-" +  u1.toString());
            	DatabaseManager.addDataToFile("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\data_file",String.valueOf(LocalTime.now()) + "-" +  u1.toString());
            }else if(userInput.equals("5")) {
            	String new_user_input = scanner.nextLine();
            	DatabaseManager.deleteData("C:\\Users\\lotarev_rv\\eclipse-workspace\\lab_4_java\\data_file", new_user_input);
            	
            }
            else {
            	flag = false;
            	scanner.close();
            	}
		}
		
		ArrayList<Integer> newArray = new ArrayList<Integer>();
        LinkedList <Integer> link_lst = new LinkedList<Integer>();
        int [] values = {10, 100, 1000, 10000, 100000};
        long tot_arr_add = 0, tot_arr_remove = 0, tot_link_add = 0, tot_link_removed = 0;
        
        for (int i = 1; i <= 10; i++) {
            if (i <= 5) {
                long startTime = System.nanoTime();
            	ArrayList<Integer> arr = generate_del_collections.generateArrayList(values[i-1], newArray);
            	long endTime = System.nanoTime();
            	long sum_time = endTime-startTime;
            	recording_error_handling.write_time("add_arr", sum_time);
            	tot_arr_add += sum_time;
            	
            	startTime = System.nanoTime();
            	arr = generate_del_collections.removeArrayList(arr);
            	endTime = System.nanoTime();
            	sum_time = endTime-startTime;
            	recording_error_handling.write_time("del_arr", sum_time);
            	tot_arr_remove += sum_time;
            } else {
            	if(i==6) { 
            	recording_error_handling.write_time("total_arr", tot_arr_add);
            	recording_error_handling.write_time("mean_arr", tot_arr_add/5);
            	recording_error_handling.write_time("total_del", tot_arr_remove);
            	recording_error_handling.write_time("mean_del", tot_arr_remove/5);
            	}
            	
            	long startTime = System.nanoTime();
            	LinkedList<Integer> arr = generate_del_collections.generateLinkedList(values[i-6], link_lst);
            	long endTime = System.nanoTime();
            	long sum_time = endTime-startTime;
            	recording_error_handling.write_time("add_link", sum_time);
            	tot_link_add += sum_time;
            	
            	startTime = System.nanoTime();
            	arr = generate_del_collections.removeLinkedList(arr);
            	endTime = System.nanoTime();
            	sum_time = endTime-startTime;
            	recording_error_handling.write_time("del_link", sum_time);
            	tot_link_removed += sum_time;
            }
            

	}
        
        recording_error_handling.write_time("total_link", tot_link_add);
    	recording_error_handling.write_time("mean_link", tot_link_add/5);
    	recording_error_handling.write_time("total_del_link", tot_link_removed);
    	recording_error_handling.write_time("mean_del_link", tot_link_removed/5);
    	recording_error_handling.write_end_programm();
    	//dop
    	
//    	ArrayList<Integer> arrayList = new ArrayList<>(0);
//    	long startTime = System.nanoTime();
//
//    	int numElementsToAdd = 100000; 
//
//    	for (int i = 0; i < numElementsToAdd; i++) {
//    	    arrayList.add(i);
//    	}
//
//    	long endTime = System.nanoTime();
//    	long elapsedTime = endTime - startTime;
//
//    	System.out.println("Время добавления " + numElementsToAdd + " элементов: " + elapsedTime + " наносекунд");
//    	int oldCapacity = arrayList.size();
//    	int newCapacity = (oldCapacity * 3) / 2 + 1;
//    	arrayList.ensureCapacity(newCapacity);
//    	startTime = System.nanoTime();
//
//    	for (int i = numElementsToAdd; i < numElementsToAdd * 2; i++) {
//    	    arrayList.add(i);
//    	}
//
//    	endTime = System.nanoTime();
//    	elapsedTime = endTime - startTime;
//
//    	System.out.println("Время добавления " + numElementsToAdd + " элементов после увеличения емкости: " + elapsedTime + " наносекунд");




	}
}
