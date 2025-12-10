import java.util.concurrent.Semaphore;

public class BufferCircularM {
    final int dimBuffer = 16;
    private Semaphore livres, ocupados, acesso;
    private Comando[] buffer;
    private int putBuffer, getBuffer;
    
    
    
    // TEMOSQUE LIMPAR O BUFFER SEMPRE QUE FAZEMOS UM PARAR COM TRUE OK!!==!=!?!?!?!!?!?
    
    
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
         
            
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted: " + e.getMessage());
        } finally {
            
            try {
                acesso.release();
                ocupados.release();
            } catch (Exception ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }
    }

    public Comando ler() {
        Comando c = null;
        try {
        	
            ocupados.acquire(); 
            acesso.acquire();   
            c = buffer[getBuffer]; 
            getBuffer = ++getBuffer % dimBuffer; 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread: " + e.getMessage());
        } finally {
            
            try {
                acesso.release();
                livres.release();
            } catch (Exception ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }
        return c;
    }
    
    public void limparBuffer() {
        try {
            acesso.acquire();
            
            // Reseta tudo
            ocupados.drainPermits();
            livres.drainPermits();
            livres.release(dimBuffer);
            
            putBuffer = 0;
            getBuffer = 0;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            acesso.release();
        }
    }
    
}
