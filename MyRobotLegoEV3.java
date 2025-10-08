
public class MyRobotLegoEV3  extends Thread {
	RobotLegoEV3 robot;
	BufferCircularM buffer;
	private static int VEL_ROBOT = 20;
	boolean movAlF = false;
	
	public MyRobotLegoEV3(){
		
		
	}
	
	
	
	public void Reta (int distancia) {
		Comando c = new Comando(Comando.ID_Reta, distancia);
		
	}
	public void CurvarEsquerda (int angulo, int raio ) {
		Comando c = new Comando(Comando.ID_CurvarEsquerda, angulo, raio);
		
	}
	public void CurvarDireita (int angulo, int raio ) {
		Comando c = new Comando(Comando.ID_CurvarDireita, angulo, raio);
		
	}
	public void OpenEV3(String nome) {
		Comando c = new Comando(Comando.ID_OpenEV3, nome);	
	}
	
	public void Parar (boolean con) {
		Comando c = new Comando(Comando.ID_Parar, con);	
	}
	
	
	public void parar (boolean b) {
		
		
	}
	
	
	
	 public void run() {
	    	
	    }

}
