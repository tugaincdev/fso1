
import java.util.concurrent.Semaphore;

public class GestorRobot {
	
	Semaphore acessoRobot;
	Semaphore acessoVIP;
	
	
	
	public GestorRobot() {
		
		acessoRobot = new Semaphore(1);
		acessoVIP = new Semaphore(1);
	
	}
	
	public void pedirRobot() {
		
     try {
		acessoRobot.acquire();
	 } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	
		
	}
	
	public void devolverRobot() {
		
		acessoRobot.release();
		
	}
	
	public void pedirVIP() {
		
	     try {
			acessoVIP.acquire();
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
			
		}
		
		public void devolverVIP() {
			
			acessoVIP.release();
			
		}
		
	
 
	

}
