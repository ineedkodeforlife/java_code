package lab_1_java;

import java.util.Properties;


public class First_class {
	
public static String model(int[] numbers) {
	int n = numbers.length;
    if (n < 3) {
        return "Enter more digits";
    }
    
    boolean isArithmeticProgression = true;
    boolean isGeometricProgression = true;
    
    int commonDifference = numbers[1] - numbers[0];
    int commonRatio = numbers[1] / numbers[0];
    
    for (int i = 2; i < n; i++) {
        if (numbers[i] - numbers[i - 1] != commonDifference) {
            isArithmeticProgression = false;
        }
        if (numbers[i] / numbers[i - 1] != commonRatio) {
            isGeometricProgression = false;
        }
    }
    
    if (isArithmeticProgression) {
        return " arifmetic progressiom with diff : " + commonDifference;
    } else if (isGeometricProgression) {
        return " geometric progressiom with multy : " + commonRatio;
    } else {
        return " This is not progression ";
    }
}
	

public static void view(String string) {
	System.out.println("Result" + string);
}

public static void controller(int[] numbers) {
	if (numbers.length < 3) {
		view("Enter 3 and more digits");
	}else {
		view(model(numbers));
	}
		
}

public static void main(String[] args) {
	if (args.length == 0) {
        System.out.println("You dont enter digits");
        return;
    }

    int[] numbers = new int[args.length];

    for (int i = 0; i < args.length; i++) {
        try {
            numbers[i] = Integer.parseInt(args[i]);
        } catch (NumberFormatException e) {
            System.out.println("Error string to digit " + args[i]);
            return;
        }
    }
	
	controller(numbers);
}
}