

import java.util.ArrayList;

public class Dados {
	private GUI_TP1 gui;
	private String nomeRobot;
	private ArrayList<String> texto;
	private int raio, angulo, distancia;
	private RobotLegoEV3 robot;
	private boolean onOff;
	
	public Dados(GUI_TP1 g) {
		
		nomeRobot = "ZE";
		gui = g;
		texto = new ArrayList<String>();
		raio = 20;
		angulo = 20;
		distancia = 20;
		onOff = false;
		robot = new RobotLegoEV3();
		
	}

	public GUI_TP1 getGui() {
		return gui;
	}

	public void setGui(GUI_TP1 gui) {
		this.gui = gui;
	}

	public String getNomeRobot() {
		return nomeRobot;
	}

	public void setNomeRobot(String nomeRobot) {
		this.nomeRobot = nomeRobot;
	}

	public ArrayList<String> getTexto() {
		return texto;
	}

	public void setTexto(ArrayList<String> texto) {
		this.texto = texto;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public RobotLegoEV3 getRobot() {
		return robot;
	}

	public void setRobot(RobotLegoEV3 robot) {
		this.robot = robot;
	}

	public boolean isOnOff() {
		return onOff;
	}

	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}

}
