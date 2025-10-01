

public class MyRobotLegoEV3  extends Thread {
	RobotLegoEV3 robot;
	BufferCircularM buffer;
	private static int VEL_ROBOT = 20;
	
	public MyRobotLegoEV3(){
		
		
	}
	
	
	
	public void reta (int distancia) {
		Comando c = new Comando(Comando.ID_Reta, distancia);
		
	}
	public void parar (boolean b) {
		Comando c = new Comando(Comando.ID_Parar, 0);
		buffer.inserirElemento(c);
	}
	
	
	
	 public void run() {
	    	
	    }

}
