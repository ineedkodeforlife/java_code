package lab_2_java;

public class Main {
	public static void main(String[] args) {
		Underwear u1 = new Underwear(20, 25);
		Underwear_Color u_c1 = new Underwear_Color("white");
		Washer[] myObjects = new Washer[3];
		myObjects[0] = new Washer("liquid", "mif", "black", 40);
		myObjects[1] = new Washer("dry", "mif", "colored", 60);
		myObjects[2] = new Washer("dry", "arial", "white", 20);
		System.out.println(u1);
		
		
		for (Washer obj: myObjects) {
			if(obj.Load(u_c1, u1) == 1) {
				break;
			}
		}
		
	}

}
