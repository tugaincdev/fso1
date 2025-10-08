import javax.swing.SwingUtilities;

public class App  extends Thread{
    private GUI_TP1 gui;
    private Dados dados;
    private MovimentosAleatorios movimentosAl;

    public App() {
        
        gui = new GUI_TP1();
        
        dados = new Dados(gui);
        
        movimentosAl = new MovimentosAleatorios();
       
        gui.setDados(dados);
        
        movimentosAl.setDados(dados);
        
        
    }

    public static void main(String[] args) {
       
        
                App app = new App();
                app.start();
                
         
    
}
    public void run() {
    	
    }
    
}
	


