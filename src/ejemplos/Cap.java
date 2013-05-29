package ejemplos;

import java.util.Random;

public class Cap {
	public static void main(String args[]){
		Random rand = new Random();
		System.out.println("Te toca hacer el apartado "+(rand.nextInt(3)+1));
	}
}
