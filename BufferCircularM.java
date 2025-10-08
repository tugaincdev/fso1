import java.util.ArrayList;
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
    buffer = new Comando[dimBuffer]; //maybe wrong
  }

  public void escrever(Comando c) {
    try {
    	livres.acquire();
        acesso.acquire();
        buffer[putBuffer] = c;
        putBuffer = ++putBuffer % dimBuffer;
    } catch (InterruptedException e) {
    	Thread.currentThread().interrupt();
        System.err.println("Thread interrupted while writing to buffer: " + e.getMessage());
    }
    acesso.release();
    ocupados.release();
  }

  public Comando ler() {
	Comando c = null; //tive de por para n dar erro
	try {	  
		ocupados.acquire();
		acesso.acquire();
	} catch(InterruptedException e) {
    	Thread.currentThread().interrupt();
        System.err.println("Thread interrupted while writing to buffer: " + e.getMessage());
	}
	acesso.release();
	livres.release();
	return c;
  }
  
  public void inserirElemento(Comando c) {
  	
  	
  	
  	
  }
}
