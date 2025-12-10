import java.io.*;

public class ReplayThread extends Thread {

    private volatile Estado state = Estado.NOT_ACTIVE;
    private DataInputStream in;
    private Dados dados;

    private boolean justActivated = false;
    private String filename;

    public ReplayThread(String filename, Dados dados) throws IOException {
        this.filename = filename;
        this.dados = dados;
        this.in = new DataInputStream(new FileInputStream(filename));
    }

    @Override
    public void run() {
        while (state != Estado.CLOSED) {

            if (state == Estado.ACTIVE) {

                // When replay starts → reopen file so it replays from start
                if (justActivated) {
                    try {
                        if (in != null) in.close();
                        in = new DataInputStream(new FileInputStream(filename));
                        System.out.println("[REPLAY] Restarted replay file (reset pointer)");
                    } catch (IOException e) {
                        e.printStackTrace();
                        state = Estado.CLOSED;
                    }
                    justActivated = false;
                }

                try {
                    // Read one command
                    int argID = in.readInt();
                    int arg1 = in.readInt();
                    int arg2 = in.readInt();
                    boolean arg1B = in.readBoolean();

                    System.out.println("argID=" + argID + " arg1=" + arg1 +
                                       " arg2=" + arg2 + " arg1B=" + arg1B);

                    // Build correct command
                    Comando c;
                    switch (argID) {
                        case Comando.ID_Parar:
                            c = new Comando(argID, arg1B);
                            break;
                        case Comando.ID_Reta:
                            c = new Comando(argID, arg1);
                            break;
                        case Comando.ID_CurvarEsquerda:
                        case Comando.ID_CurvarDireita:
                            c = new Comando(argID, arg1, arg2);
                            break;
                        default:
                            c = new Comando(argID);
                            c.setArg1(arg1);
                            c.setArg2(arg2);
                            c.setArg1B(arg1B);
                            break;
                    }

                    // Send to robot buffer
                    if (dados != null && dados.getRobot() != null && dados.getRobot().buffer != null) {
                        dados.getRobot().buffer.escrever(c);
                        System.out.println("[REPLAY] Sent command: " + c);
                    }

                } catch (EOFException e) {
                    System.out.println("[REPLAY] End of file reached – replay complete.");
                    state = Estado.NOT_ACTIVE;  // allow replay again
                } catch (IOException e) {
                    System.err.println("IO error during replay: " + e);
                    state = Estado.CLOSED;
                }

            } else {
                // Not active → sleep lightly
                try { Thread.sleep(1); } catch (InterruptedException ignored) {}
            }
        }

        try { in.close(); } catch (IOException ignored) {}
        System.out.println("[REPLAY] ReplayThread closed.");
    }

    // Detect transition to ACTIVE
    public void setEstado(Estado newEstado) {
        if (this.state != Estado.ACTIVE && newEstado == Estado.ACTIVE) {
            justActivated = true;
        }
        this.state = newEstado;
    }

    public Estado getEstado() {
        return state;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }
    

    public void setFileName(String newFileName) throws IOException {
        if (in != null) in.close();
        this.filename = newFileName;   // <-- store new file name!
        this.in = new DataInputStream(new FileInputStream(newFileName));
    }
}
