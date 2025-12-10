public class SensorTouch extends Thread {
	
	private Dados dados;
	private int curvaChoice;

 private int previousSensor = 0;
	
	public SensorTouch() {
		
	}
	
	
	public void run() {
		int sensorTouches = 0;
		
		
		
    	while (true) {
    		try {
    			
    			
    	//	System.out.println(dados.isOnOff());
    		 
           if (!dados.isOnOff() ) {
        	   System.out.println("Sensor dados instance: " + dados);
        	    System.out.println("Sensor checking isOnOff(): " + dados.isOnOff());
             continue; 
           }
           
           Thread.sleep(50);
          
    		sensorTouches = dados.getRobot().SensorToque(dados.getRobot().sensor);
    		
    		
    		
	    		if (sensorTouches == 1 && previousSensor == 0 ) {
	    			dados.getRobot().PararSensor(true);
	    			 System.out.println("MAYBE");
	    			dados.getGestor().pedirVIP();
	    			System.out.println("OK");
	    			
	    			
	    			
	    			
	    			
	 
		    			
		    			dados.getRobot().robot.Reta(-20);
		    			Thread.sleep((long) (Math.abs(20 / 20 * 1000) + 100));
		    			
		    		
		    			
		    			curvaChoice = (int)(Math.random() * 2) + 1;
		    			switch (curvaChoice) {
			    			case 1:
			    				dados.getRobot().robot.CurvarEsquerda(1, 90);
			    				
			    				
			    				break;
			    			case 2:
			    				dados.getRobot().robot.CurvarDireita(1, 90);
			    				break;
			    		}
		    			Thread.sleep((long) (1 * Math.toRadians(90) / 20 * 1000) + 100);
		    			
		    			
		    			dados.getRobot().robot.Parar(false);
		    			
		    			dados.getGestor().devolverVIP();
		    			
		    			
		    			
		    				
		    			
		    			
		    			
	        	
					
							
							
							
							
							
						
					}
	        		previousSensor = 1;
	        		
		    	
	    		
	    		
	            if (sensorTouches == 0 && previousSensor == 1) {
	                previousSensor = 0;
	               
	            }
	            
    		} catch (Exception e) {
				System.err.println("Erro no processamento do comando: " + e.getMessage());
				e.printStackTrace();
		}
	}
    	}
	public void setDados(Dados data) {
		this.dados = data;
	}
	public Dados getDados() {
		return dados;
	}

}
