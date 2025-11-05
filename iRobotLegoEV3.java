
public interface iRobotLegoEV3 {
	
	void Reta(int distancia);
	
	void CurvarDireita(int raio, int angulo);

	void CurvarEsquerda(int raio, int angulo);
	
	void Parar(boolean b);
	
	boolean OpenEV3(String s);
	
	void CloseEV3();
	
	int SensorToque(int sensor);

}
