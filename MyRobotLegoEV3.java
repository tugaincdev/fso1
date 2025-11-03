
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
	public void CurvarEsquerda(int raio, int angulo) {
		Comando c = new Comando(Comando.ID_CurvarEsquerda, raio, angulo);
		buffer.escrever(c);
		
	}
	public void CurvarDireita(int raio, int angulo ) {
		Comando c = new Comando(Comando.ID_CurvarDireita, raio, angulo);
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
	    while (true) {  
	        try {
	           

	            Comando c = buffer.ler();  // BLOQUEIA até um comando chegar

	            if (c == null) {
	                System.out.println("Comando nulo recebido. Continuando a esperar...");
	                continue; // Em vez de parar, volta a esperar
	            }

	            switch (c.getArgID()) {
	                case 1:
	                    System.out.println("Executando RETA de " + c.getArg1() + " cm");
	                    robot.Reta(c.getArg1());
	                    Thread.sleep(RobotSleep.calculateSleepForReta(c.getArg1()));
	                    break;

	                case 2:
	                    System.out.println("Executando CURVA ESQUERDA...");
	                    robot.CurvarEsquerda(c.getArg1(), c.getArg2());
	                    Thread.sleep(RobotSleep.calculateSleepForCurva(c.getArg2(), c.getArg1()));
	                    break;

	                case 3:
	                    System.out.println("Executando CURVA DIREITA...");
	                    robot.CurvarDireita(c.getArg1(), c.getArg2());
	                    Thread.sleep(RobotSleep.calculateSleepForCurva(c.getArg2(), c.getArg1()));
	                    break;

	                case 0:
	                    System.out.println("Executando PARAR: con=" + c.getArg1B());
	                    robot.Parar(c.getArg1B());
	                    Thread.sleep(100);
	                    // Não finaliza mais
	                    break;

	                default:
	                    System.out.println("Comando desconhecido: " + c.getArgID() + " - Ignorando.");
	                    break;
	            }

	           

	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            System.err.println("Thread do robô interrompida: " + e.getMessage());
	            break; // aqui sim pode sair, se o programa quiser terminar mesmo
	        } catch (Exception e) {
	            System.err.println("Erro no processamento do comando: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    System.out.println("Thread do robô finalizada.");
	}

}
