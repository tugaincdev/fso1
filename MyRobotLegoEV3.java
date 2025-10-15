
public class MyRobotLegoEV3  extends Thread implements iRobotLegoEV3 {
	RobotLegoEV3 robot;
	BufferCircularM buffer;
	private static int VEL_ROBOT = 20;
	boolean movAlF = false;
	
	public MyRobotLegoEV3(){
		buffer = new BufferCircularM();
		robot = new RobotLegoEV3();	
	}
	
	
	public void Reta(int distancia) {
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
	
	public void Parar(boolean con) {
		Comando c = new Comando(Comando.ID_Parar, con);	
		buffer.escrever(c);
	}
	public void CloseEV3() {
		robot.CloseEV3();
		
	}
	
	

	
	
	
	
	
	
	
	 public void run() {
		 

		
		try {
			Comando c = buffer.ler();
			
			
			
			//public static int ID_Reta = 1;
			//public static int ID_CurvarEsquerda = 2;
			//public static int ID_CurvarDireita = 3;
			//public static int ID_Parar = 0;
			//public static int ID_LigarID = 4;
			//public static int ID_OpenEV3 = 5;
			//public static int ID_CloseEV3 = 6;
			
			
			
			
			switch (c.getArgID()) {
				case 1:
					robot.Reta(c.getArg1());
					long tempoReta = (long) (Math.abs(c.getArg1()) / VEL_ROBOT * 1000) + 100;
					Thread.sleep(tempoReta);
					break;
				case 2:
					robot.CurvarEsquerda(c.getArg1(), c.getArg2());
					long tempoEsq = (long) (c.getArg2() * Math.toRadians(c.getArg1()) / VEL_ROBOT * 1000) + 100;
					Thread.sleep(tempoEsq);
					break;
				case 3:
					robot.CurvarDireita(c.getArg1(), c.getArg2());
					long tempoDir = (long) (c.getArg2() * Math.toRadians(c.getArg1()) / VEL_ROBOT * 1000) + 100;
					Thread.sleep(tempoDir);
					break;
				case 0:
					robot.Parar(c.getArg1B());
					Thread.sleep(100);
					break;	
			} 
			
		} catch(InterruptedException e) {
			 Thread.currentThread().interrupt(); 
			 System.err.println("Thread interrupted while writing to buffer: " + e.getMessage());
		}	    	
    }
}
