import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class Dados {
    private JFrame gui;
    private RecorderThread recorder;
    private ReplayThread replay;
    private String nomeRobot;
    private ArrayList<String> texto;
    private int raio, angulo, distancia, spinner;
    private MyRobotLegoEV3 robot;
    private RobotLegoSimulado robot1;
    private boolean onOff, onOffAl, onOffSimulado, gravadorOn;
    
    private GestorRobot gestor;

    

    public Dados(JFrame g) {

        nomeRobot = "ZE";
        gui = g;
       
        texto = new ArrayList<String>();
        gestor = new GestorRobot();
        
        raio = 20;
        angulo = 20;
        distancia = 20;
        spinner = 1;

        
        robot = null;
        robot1 = null;

        onOff = false;
        onOffAl = false;
        onOffSimulado = false;
        
        gravadorOn = false;
    }

    public void setGestor(GestorRobot newgestor) {
    	gestor = newgestor;
    }
  
    public GestorRobot getGestor() {
    	return gestor;
    }
    
    public MyRobotLegoEV3 getRobot() {
        if (robot == null) {
            robot = new MyRobotLegoEV3();
           
            
            
            
          
            
            robot.start(); 
            robot.setGestor(gestor);
            
           
        }
        return robot;
    }

    
    public RobotLegoSimulado getRobotSimulado() {
        if (robot1 == null) {
            robot1 = new RobotLegoSimulado();
        }
        return robot1;
    }

    
    public void limparRobot() {
        robot = null;
    }

   
    public void limparRobotSimulado() {
        robot1 = null;
    }

    

    public boolean isOnOffAl() {
        return onOffAl;
    }

    public void setOnOffAl(boolean onOffAl) {
        this.onOffAl = onOffAl;
    }

    public void setSpinner(int spinner) {
        this.spinner = spinner;
    }

    public int getSpinner() {
        return spinner;
    }

    public JFrame getGui() {
        return gui;
    }

    public void setGui(JFrame gui) {
        this.gui = gui;
    }
    
    public ReplayThread getReplay() {
    	return replay;
    }
    
    public void setReplay (ReplayThread replay) {
    	this.replay = replay;
    }
    
    
    public RecorderThread getRecorder() {
    	return recorder;
    }
    
    public void setRecorder (RecorderThread recorder) {
    	this.recorder = recorder;
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

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public boolean isOnOffSimulado() {
        return onOffSimulado;
    }

    public void setOnOffSimulado(boolean onOffSimulado) {
        this.onOffSimulado = onOffSimulado;
    }
}
