
public class MyRobotLegoEV3  extends Thread {
	RobotLegoEV3 robot;
	BufferCircularM buffer;
	private static int VEL_ROBOT = 20;
	boolean movAlF = false;
	
	public MyRobotLegoEV3(){
		buffer = new BufferCircularM();
		robot = new RobotLegoEV3();	
	}
	
	
	public void Reta (int distancia) {
		Comando c = new Comando(Comando.ID_Reta, distancia);
		buffer.escrever(c);
		
	}
	public void CurvarEsquerda(int angulo, int raio ) {
		Comando c = new Comando(Comando.ID_CurvarEsquerda, angulo, raio);
		buffer.escrever(c);
		
	}
	public void CurvarDireita(int angulo, int raio ) {
		Comando c = new Comando(Comando.ID_CurvarDireita, angulo, raio);
		buffer.escrever(c);
		
	}
	public boolean OpenEV3(String nome) {
		return(robot.OpenEV3(nome));
	}
	
	public void Parar (boolean con) {
		Comando c = new Comando(Comando.ID_Parar, con);	
		buffer.escrever(c);
	}
	public void CloseEV3 () {
		robot.CloseEV3();
		
	}
	
	

	
	
	
	
	
	
	
	 public void run() {
		 
		 
		 
		 
		 
		 
	    	
	    }

}
