import java.util.ArrayList;

public class MovimentosAleatorios extends Thread  {
	private Dados dados;
	private int oneTwoThree;
	private int raio, distancia, angulo;
	
	
	
	
public MovimentosAleatorios() {
		
	
		
	}


public void run() {
	
	
	for (int i = 0; i < dados.getSpinner(); i++) {
		
		oneTwoThree = (int)(Math.random() * 3) + 1;

		switch (oneTwoThree) {
		case 1:
			
			distancia = (int)(Math.random() * 101);
			dados.getRobot().Reta(distancia);
			break;
			
		case 2:
			
			raio = (int)(Math.random() * 101);
			angulo = (int)(Math.random() * 361);
			dados.getRobot().CurvarEsquerda(dados.getRaio(), dados.getAngulo());
			break;
		case 3:
			
			raio = (int)(Math.random() * 101);
			angulo = (int)(Math.random() * 361);
			dados.getRobot().CurvarEsquerda(dados.getRaio(), dados.getAngulo());
			break;
		}
		dados.getRobot().Parar(false);
		
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
