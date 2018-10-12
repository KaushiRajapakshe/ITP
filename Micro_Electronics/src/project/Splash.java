package project;

public class Splash {

	public static void main(String args[]) throws InterruptedException{
		SplashScreen splash=new SplashScreen();
		
		for (int i = 0;i<=100;i++) {
			Thread.sleep(40);
			splash.setVisible(true);
			splash.Loading.setText("Loading.." +i+"%");
			splash.Load.setValue(i);
			
		}
	}
	
	
	
}
