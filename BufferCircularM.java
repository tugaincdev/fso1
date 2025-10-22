import java.util.concurrent.Semaphore;

public class BufferCircularM {
    final int dimBuffer = 16;
    private Semaphore livres, ocupados, acesso;
    private Comando[] buffer;
    private int putBuffer, getBuffer;
    
    public BufferCircularM() {
        livres = new Semaphore(dimBuffer);
        ocupados = new Semaphore(0);
        acesso = new Semaphore(1);
        buffer = new Comando[dimBuffer];
        putBuffer = 0; 
        getBuffer = 0;
    }

    public void escrever(Comando c) {
        try {
        	
            livres.acquire();
            acesso.acquire();
            buffer[putBuffer] = c;
            putBuffer = ++putBuffer % dimBuffer;
         
            System.out.println(">>> Comando recebido e escrito no buffer! Índice: " + (putBuffer - 1) % dimBuffer + 
                              ", Comando: " + c.toString() );  
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while writing to buffer: " + e.getMessage());
        } finally {
            
            try {
                acesso.release();
                ocupados.release();
            } catch (Exception ex) {
                System.err.println("Erro ao liberar semáforos em escrever: " + ex.getMessage());
            }
        }
    }

    public Comando ler() {
        Comando c = null;
        try {
        	System.out.println("adeus1");
            ocupados.acquire(); 
            acesso.acquire();   
            c = buffer[getBuffer]; 
            getBuffer = ++getBuffer % dimBuffer; 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while reading from buffer: " + e.getMessage());
        } finally {
            
            try {
                acesso.release();
                livres.release();
            } catch (Exception ex) {
                System.err.println("Erro ao liberar semáforos em ler: " + ex.getMessage());
            }
        }
        return c;
    }
    
}
