
public class RobotLegoSimulado implements iRobotLegoEV3 {

	@Override
	public void Reta(int distancia) {
		System.out.println("Reta, distancia=" + distancia);
		
	}

	@Override
	public void CurvarDireita(int raio, int angulo) {
		System.out.println("Curva à direita, raio=" + raio + ", angulo = " + angulo);
		
	}

	@Override
	public void CurvarEsquerda(int raio, int angulo) {
		System.out.println("Curva à esquerda, raio=" + raio + ", angulo = " + angulo);
		
	}

	@Override
	public void Parar(boolean b) {
		System.out.println("Parar, boolean=" + b);
		
	}

	@Override
	public boolean OpenEV3(String s) {
		System.out.println("OpenEV3, string=" + s);
		return false;
	}

	@Override
	public void CloseEV3() {
		System.out.println("CloseEV3");
		
	}

}
