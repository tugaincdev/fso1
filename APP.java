import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.io.*;
import java.util.List;

public class App  extends Thread{
    private GUI_TP1 gui;
    private GUI_TP2_Gravador gui2;
    private Dados dados, dados2;
    private MovimentosAleatorios movimentosAl, movimentosAl2;
    private SensorTouch sensor2;
    private RecorderThread gravador;
    private ReplayThread replay;
    private GestorRobot gestor, gestor2;
    
 

    public App() {
        gui = new GUI_TP1();
        dados = new Dados(gui);
        movimentosAl = new MovimentosAleatorios();
        gestor = new GestorRobot();
        dados.setGestor(gestor);

        gui.setDados(dados);
        gui.setMovimentosAl(movimentosAl);

        movimentosAl.setDados(dados);

        gui2 = new GUI_TP2_Gravador();
        dados2 = new Dados(gui2);
        movimentosAl2 = new MovimentosAleatorios();
        gestor2 = new GestorRobot();

        gui2.setDados(dados2);
        gui2.setMovimentosAl(movimentosAl2);

        movimentosAl2.setDados(dados2);
        sensor2 = new SensorTouch();
        sensor2.setDados(dados2);
        sensor2.start();
        List<Comando> queue = new ArrayList<>();
        String filename = "recording.dat";
        try {
            gravador = new RecorderThread(queue, filename);
            dados2.setRecorder(gravador);
            gravador.setDados(dados2); // Links to robot buffer for commands
            gravador.start();  // Start the recorder thread
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            replay = new ReplayThread(filename, dados2);
            dados2.setReplay(replay);
            replay.setDados(dados2);
            replay.start();  // Start the replay thread
        } catch (IOException e) {
            e.printStackTrace();
        }

        dados2.setGestor(gestor2);
    }

    public static void main(String[] args) {
       
        
                App app = new App();
                
                app.start();
                
         
    
}
    public void run() {
    	
    }
    
}
	


