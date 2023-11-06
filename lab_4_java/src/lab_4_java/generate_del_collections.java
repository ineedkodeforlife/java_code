package lab_4_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class generate_del_collections {
	public static ArrayList<Integer> generateArrayList(int size, ArrayList<Integer> arr){
		
		Random random = new Random();
		for(int i = 0; i < size; i++) {
			arr.add(random.nextInt(100));
		}
		
		return arr;
	}
	
	
	public static LinkedList<Integer> generateLinkedList(int size, LinkedList<Integer> arr){
		Random random = new Random();
		for(int i = 0; i < size; i++) {
			arr.add(random.nextInt(100));
		}
		
		return arr;
		
	}
	
	public static ArrayList<Integer> removeArrayList(ArrayList<Integer> list) {
        int size = list.size();
        int elementsToRemove = (int) (size * 0.10); 
        Random random = new Random();

        for (int i = 0; i < elementsToRemove; i++) {
            int randomIndex = random.nextInt(list.size());
            list.remove(randomIndex);
        }
        return list;
    }

    public static LinkedList<Integer> removeLinkedList(LinkedList<Integer> list) {
        int size = list.size();
        int elementsToRemove = (int) (size * 0.10); 
        Random random = new Random();

        for (int i = 0; i < elementsToRemove; i++) {
            int randomIndex = random.nextInt(list.size());
            list.remove(randomIndex);


	}
        return list;
}
	

}
