package project.quack.beep;

public class Beep {

	public static void main(String[] args) {
		Thread thread =  new Thread();
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
