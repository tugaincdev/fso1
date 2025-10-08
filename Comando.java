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
    
    
    public int getArgID() {
    	return indent;
    }
    
    public void setID(int newArgID) {
    	indent = newArgID;
    }
    
	public int getArg1() {
		return arg1;
	}
	
	public void setArg1(int newArg1) {
		arg1 = newArg1;
	}
	
	public int getArg2() {
		return arg1;
	}
	
	public void setArg2(int newArg2) {
		arg1 = newArg2;
	} 
	
	public boolean getArg1B() {
		return arg1B;
	}
	
	public void setArg1B(boolean newArg1B) {
		arg1B = newArg1B;
	} 
    

}
