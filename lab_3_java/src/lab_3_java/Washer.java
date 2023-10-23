package lab_3_java;


public class Washer {
	
	private String type_powder, conditioner, color_underwear;
	private int temperature_washing, loc_counter;
	private static int counter = 0;
	
	public Washer(String t_p, String cond, String c_u, int t_w) {
		type_powder = t_p;
		conditioner = cond;
		color_underwear = c_u;
		temperature_washing = t_w;
		counter++;
		loc_counter = counter;
	}
	
	public String getpowder() {
		
		return type_powder;
	}
	
	public void setpowder(String value) {
		
		type_powder = value;
	}
	
	public String getconditioner() {
		
		return conditioner;
	}
	
	public void setconditioner(String value) {
		
		conditioner = value;
	}
	
	public String getcolor_underwear() {
		
		return color_underwear;
	}
	
	public void setcolor_underwear(String value) {
		
		color_underwear = value;
	}
	
	public int temperature_washing() {
		
		return temperature_washing;
	}
	
	public void setcolor_underwear(int value) {
		
		temperature_washing = value;
	}
	
	public int Load(Underwear_Color a, Underwear b){
		
		if (a.getColor() == color_underwear && b.getWashTemp() == temperature_washing) {
			String textBlock = """
				    Underwear with, %s color,
				    and %d temperature washing.
				    loaded in %d washer
				    """.formatted(a.getColor(), b.getWashTemp(), loc_counter);
			System.out.print(textBlock);
			return 1;
		}
		return 0;
			
		}
}