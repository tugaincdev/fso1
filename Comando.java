import java.util.ArrayList;

public class Comando {
	
	
	private int arg1, arg2, indent;
	private boolean arg1B;
	private String arg1S;
	public static int ID_Reta = 1;
	public static int ID_CurvarEsquerda = 2;
	public static int ID_CurvarDireita = 3;
	public static int ID_Parar = 0;
	public static int ID_LigarID = 4;
	public static int ID_OpenEV3 = 5;
	public static int ID_CloseEV3 = 6;

	
	
	public Comando( int argID, int arg1, int arg2) {
		this.indent = argID;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
    public Comando(int argID, int arg1) {
		this.indent = argID;
		this.arg1 = arg1;	
	}
    
    public Comando(int argID, boolean arg1) {
		this.indent = argID;
		this.arg1B = arg1;
	}
    
    public Comando(int argID, String arg1) {
		this.indent = argID;
		this.arg1S = arg1;	
	}
    
    public Comando(int argID) {		
		this.indent = argID;		
	}
    
    

}
