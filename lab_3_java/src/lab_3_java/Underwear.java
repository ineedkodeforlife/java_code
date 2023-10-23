package lab_3_java;


public class Underwear {
		private int temp_wash, temp_ironing;
		
	
		public Underwear(int wash, int ironing){
			temp_wash = wash;
			temp_ironing = ironing;
		}
		
		public int getWashTemp() {
			
			return temp_wash;
		}
		
		public void setWashTemp(int value) {
			
			temp_wash = value;
		}
		
		public int getIroningTemp() {
			
			return temp_ironing;
		}
		
		public void setIroningTemp(int value) {
			
			temp_ironing = value;
		}
		
		@Override
		public String toString() {
			return "temp wash : " + temp_wash + ", temp_ironing : " + temp_ironing;
		}

}
