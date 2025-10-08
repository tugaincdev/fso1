import java.util.ArrayList;

public class Comando {
	
	
	private int arg1, arg2, indent;
	public static int ID_Reta = 1;
	public static int ID_CurvarEsquerda = 2;
	public static int ID_CurvarDireita = 3;
	public static int ID_Parar = 0;
	public static int ID_Ligar = 4;

	
	
	
	
	public Comando( int argID, int arg1, int arg2) {
		
		this.indent = argID;
		this.arg1 = arg1;
		this.arg2 = arg2;
		
		
		
	}
    public Comando( int argID, int arg1) {
		
		this.indent = argID;
		this.arg1 = arg1;
		
		
		
	}
    
    

}
