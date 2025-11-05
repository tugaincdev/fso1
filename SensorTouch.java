
public class SensorTouch {
	
	private Dados dados;
	private int curvaChoice;

	
	public SensorTouch() {
		
	}
	
	
	public void run() {
		int sensorTouches = 0;
		
    	while (true) {
    		sensorTouches = dados.getRobot().SensorToque(dados.getRobot().sensor);
    		if (sensorTouches == 1) {
    			
    			curvaChoice = (int)(Math.random() * 2) + 1;
    			
    			
    			switch (curvaChoice) {
    			case 1:
    				break;

    			dados.getRobot().Parar(true);
    			System.out.println("SENSOR IS TOUCHING SOMETHING !!!!");
    		}
    	}
	}
}
