import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BufferCircularM {
  final int dimBuffer = 16;
  private Semaphore livres, ocupados, acesso;
  private Comando buffer;
  private int putBuffer, getBuffer;
  
  public BufferCircular() {
  
    livres = new Semaphore(dimBuffer);
    ocupados = new Semaphore(0);
    acesso = new Semaphore(1);
    buffer = new Comando()[dimBuffer]; //maybe wrong
  }

  public void escrever(Comando c) {
    
    livres.acquire();
    acesso.acquire();
    buffer[putBuffer] = c;
    putBuffer = ++putBuffer % dimBuffer;
    acesso.release();
    ocupados.release();
  }

  public String ler() {

    Comando c;
    ocupados.acquire();
    acesso.acquire();
    c = buffer[getBuffer];
    acesso.release();
    livres.release();
    return c;
  }
}
