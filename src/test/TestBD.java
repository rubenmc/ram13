package test;


import main.BD;

public class TestBD extends Thread{

	public static void main(String[] args) {
		BD bd = new BD();
		int res;
		try {
			res = bd.connecta("usuari", "serverm13");
			System.out.println(res);
			while (true){
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
