import java.util.ArrayList;

public class MovimentosAleatorios extends Thread  {
	private Dados dados;
	private int oneTwoThree;
	private int raio, distancia, angulo;
	private static int VEL_ROBOT = 20;
    private volatile boolean running = true;
	
	
    public void stopRunning() {
        running = false;
    }
	
public MovimentosAleatorios() {
		
	
		
	}


public void run() {
	
	System.out.println("RESULTARRR!!");
	
	while(true) {
		if(running) {
	
			
	
	
	try {
		dados.getSemaforoRobo().acquire();
		System.out.println("Semáforo disponível: " + dados.getSemaforoRobo().availablePermits());
		
		for (int i = 0; i < dados.getSpinner(); i++) {
			
			oneTwoThree = (int)(Math.random() * 3) + 1;

			switch (oneTwoThree) {
			case 1:
				
				distancia = (int)(10 + Math.random() * 41);
				dados.getRobot().Reta(distancia);
	            Thread.sleep((long) (Math.abs(distancia / VEL_ROBOT * 1000) + 100));
				break;
				
			case 2:
				
				raio = (int)(10 + Math.random() * 21);
				angulo = (int)(20 + Math.random() * 71);
				dados.getRobot().CurvarEsquerda(dados.getRaio(), dados.getAngulo());
                Thread.sleep((long) (raio * Math.toRadians(angulo) / VEL_ROBOT * 1000) + 100);

				break;
			case 3:
				
				raio = (int)(10 + Math.random() * 21);
				angulo = (int)(20 + Math.random() * 71);
				dados.getRobot().CurvarDireita(dados.getRaio(), dados.getAngulo());
                Thread.sleep((long) (raio * Math.toRadians(angulo) / VEL_ROBOT * 1000) + 100);
				break;
			}		
		}
		dados.getSemaforoRobo().release();
		dados.getRobot().Parar(false);
        Thread.sleep(100);

	} catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Thread do robô interrompida: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Erro no processamento do comando: " + e.getMessage());
        e.printStackTrace();
    } finally {
        
        try {
        } catch (Exception e) {
            System.err.println("Erro ao liberar semáforo em escrever: " + e.getMessage());
        }
    }
	
	
		}
	}
	
	
	
	
}

	
public void setDistancia(int distance) {
	this.distancia = distance;
}
public int getDistancia() {
	return distancia;
}

public void setRaio(int radius) {
	this.raio = radius;
}
public int getRaio() {
	return raio;
}

public void setAngulo(int angle) {
	this.angulo = angle;
}
public int getAngulo() {
	return angulo;
}

public void setOneTwoThree(int unoDosTres) {
	this.oneTwoThree = unoDosTres;
}
public int getOneTwoThree() {
	return oneTwoThree;
}

public void setDados(Dados data) {
	this.dados = data;
}
public Dados getDados() {
	return dados;
}

	
	

}
