import java.io.*;
import java.util.List;

public class RecorderThread extends Thread {
	
    private volatile Estado state = Estado.NOT_ACTIVE;
    private final List<Comando> queue;
    private DataOutputStream out;
    private Dados dados;
    private Comando lastCommand = null;
    private boolean justActivated = false;
    private String currentFilename;




    public RecorderThread(List<Comando> queue, String filename) throws IOException {
        this.queue = queue;
        this.currentFilename = filename;
        this.out = new DataOutputStream(new FileOutputStream(filename));
    }

    public void run() {
        while (state != Estado.CLOSED) {
        	if (state == Estado.ACTIVE) {

        	    
        	    if (justActivated) {
        	        try {
        	            out.close(); 
        	            
        	            out = new DataOutputStream(new FileOutputStream(currentFilename, false));

        	            lastCommand = null; 
        	            System.out.println("[RECORDER] Started new recording (file cleared)");
        	        } catch (IOException e) {
        	            e.printStackTrace();
        	            state = Estado.CLOSED;
        	        }
        	        justActivated = false; 
        	    }
        	    Comando c = null;
        	    c = dados.getRobot().getC();

                System.out.println(c);
              

            // Fallback to queue if needed
            if (c != null) {

                // Only record if it's NEW (not the same object and not equal)
                if (!c.equals(lastCommand)) {
                    try {
                        out.writeInt(c.getArgID());
                        out.writeInt(c.getArg1());
                        out.writeInt(c.getArg2());
                        out.writeBoolean(c.getArg1B());
                        out.flush();

                        System.out.println("[RECORDER] Wrote NEW command: " + c);

                        lastCommand = c; // update last recorded

                    } catch (IOException e) {
                        e.printStackTrace();
                        state = Estado.CLOSED; 
                    }
                }
                // else -> same command, don’t record again
                
            } else {
                    // No command, sleep a bit to avoid busy loop
                    try { Thread.sleep(1); } catch (InterruptedException ignored) {}
                }
            } else {
                // NOT_ACTIVE state, just sleep a little
                try { Thread.sleep(1); } catch (InterruptedException ignored) {}
            }
        }

        // Close resources on exit
        try { out.close(); } catch (IOException e) { e.printStackTrace(); }
    }

    public void setEstado(Estado newEstado) {
        if (this.state == Estado.ACTIVE && newEstado == Estado.NOT_ACTIVE) {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                    System.out.println("[RECORDER] File closed after stopping recording");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Detect start of new recording
        if (this.state != Estado.ACTIVE && newEstado == Estado.ACTIVE) {
            justActivated = true;
        }

        this.state = newEstado;
    }


    // Getter method to return the current state (now uses top-level State)
    public Estado getEstado() {
        return state;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public Dados getDados() {
        return dados;
    }
    public void setFileName(String newFileName) throws IOException {
    	this.currentFilename = newFileName;
        if (out != null) out.close();

    }
}
