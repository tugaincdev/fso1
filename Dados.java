import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Dados {
    private GUI_TP1 gui;
    private String nomeRobot;
    private ArrayList<String> texto;
    private int raio, angulo, distancia, spinner;
    private MyRobotLegoEV3 robot;
    private RobotLegoSimulado robot1;
    private boolean onOff, onOffAl, onOffSimulado;
    private Semaphore semaforoRobo = new Semaphore(1); 
    

    public Dados(GUI_TP1 g) {

        nomeRobot = "ZE";
        gui = g;
        texto = new ArrayList<String>();
        raio = 20;
        angulo = 20;
        distancia = 20;
        spinner = 1;

        
        robot = null;
        robot1 = null;

        onOff = false;
        onOffAl = false;
        onOffSimulado = false;
    }

    
    public Semaphore getSemaforoRobo() {
        return semaforoRobo;
    }
    
    public MyRobotLegoEV3 getRobot() {
        if (robot == null) {
            robot = new MyRobotLegoEV3();
            robot.start();
        }
        return robot;
    }

    // Cria o robô simulado apenas quando necessário
    public RobotLegoSimulado getRobotSimulado() {
        if (robot1 == null) {
            robot1 = new RobotLegoSimulado();
        }
        return robot1;
    }

    // Liberta o robô físico da memória
    public void limparRobot() {
        robot = null;
    }

    // Liberta o robô simulado da memória
    public void limparRobotSimulado() {
        robot1 = null;
    }

    // ============================================================
    // GETTERS & SETTERS
    // ============================================================

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
