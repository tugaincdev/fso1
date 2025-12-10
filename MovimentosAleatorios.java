public class MovimentosAleatorios extends Thread  {

    private Dados dados;
    private int oneTwoThree;
    private int raio, distancia, angulo;
    private static int VEL_ROBOT = 20;

    private volatile Estado estado = Estado.NOT_ACTIVE;
    private volatile boolean running = true;

    public MovimentosAleatorios() {
    }

    public void setDados(Dados data) {
        this.dados = data;
    }
    public Estado getEstado() {
        return estado;
    }

    /** PARA parar temporariamente (GUI desmarca checkbox) **/
    public void stopRunning() {
        estado = Estado.NOT_ACTIVE;
    }

    /** PARA fechar de vez a thread **/
    public void closeThread() {
        running = false;
        estado = Estado.CLOSED;
        this.interrupt();
    }

    @Override
    public void run() {

        estado = Estado.ACTIVE;
        System.out.println("RESULTARRR!! (Estado = ACTIVE)");

        while (running) {

            if (estado != Estado.ACTIVE) {
                // Paused state
                try { Thread.sleep(100); } 
                catch (InterruptedException e) {}
                continue;
            }

            try {
                dados.getGestor().pedirRobot();

                for (int i = 0; i < dados.getSpinner(); i++) {

                    if (estado != Estado.ACTIVE) break;

                    oneTwoThree = (int)(Math.random() * 3) + 1;

                    switch (oneTwoThree) {

                        case 1:
                            distancia = (int)(10 + Math.random() * 41);
                            dados.getRobot().Reta(distancia);
                            Thread.sleep((long)(Math.abs(distancia / VEL_ROBOT * 1000) + 100));
                            break;

                        case 2:
                            raio = (int)(10 + Math.random() * 21);
                            angulo = (int)(20 + Math.random() * 71);
                            dados.getRobot().CurvarEsquerda(raio, angulo);
                            Thread.sleep((long)(raio * Math.toRadians(angulo) / VEL_ROBOT * 1000) + 100);
                            break;

                        case 3:
                            raio = (int)(10 + Math.random() * 21);
                            angulo = (int)(20 + Math.random() * 71);
                            dados.getRobot().CurvarDireita(raio, angulo);
                            Thread.sleep((long)(raio * Math.toRadians(angulo) / VEL_ROBOT * 1000) + 100);
                            break;
                    }
                }

                dados.getRobot().Parar(false);
                dados.getGestor().devolverRobot();
                Thread.sleep(100);

            } catch (InterruptedException e) {
                if (estado == Estado.CLOSED) break;
                System.err.println("Thread interrompida: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("Thread MovimentosAleatorios terminada (Estado = " + estado + ")");
    }
}
