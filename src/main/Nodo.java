package main;

public class Nodo {
	
	public static final String PIU = "+";
	public static final String PER = "*";
	public static final String MENO = "-";
	public static final String DIVISO = "/";
	public static final String[] OPERAZIONI = {PIU, PER, MENO, DIVISO};
	
	private Nodo padre;
	private Nodo nextNodoDX, nextNodoSX;
	private String operazione;
	private double valore;
	
	public Nodo(){
		padre = null;
		nextNodoDX = null;
		nextNodoSX = null;
	}
	
	public Nodo(Nodo padre){
		this.padre = padre;
		nextNodoDX = null;
		nextNodoSX = null;
	}
	
	public Nodo(Nodo padre, String operazione){
		this.padre = padre;
		nextNodoDX = null;
		nextNodoSX = null;
		
		this.operazione = operazione;
	}
	
	public Nodo(Nodo padre, double valore){
		this.padre = padre;
		nextNodoDX = null;
		nextNodoSX = null;
		
		this.operazione = null;
		this.valore = valore;
	}
	
	public Nodo(Nodo padre, Nodo nextNodoDX, Nodo nextNodoSX){
		this.padre = padre;
		this.nextNodoDX = nextNodoDX;
		this.nextNodoSX = nextNodoSX;
	}
	
	//*****
	
	public Nodo getPadre() {
		return padre;
	}
	
	public Nodo getNextNodoDX() {
		return nextNodoDX;
	}

	public Nodo getNextNodoSX() {
		return nextNodoSX;
	}
	
	public String getOperazione() {
		return operazione;
	}
	
	public double getValore() {
		return valore;
	}
	
	public String getContenuto() {
		return (operazione == null)? String.valueOf(valore) : operazione;
	}
	
	//*****

	public void setNextNodoDX(Nodo nextNodoDX) {
		this.nextNodoDX = nextNodoDX;
	}

	public void setNextNodoSX(Nodo nextNodoSX) {
		this.nextNodoSX = nextNodoSX;
	}
	
	public void setOperazione(String operazione) {
		this.operazione = operazione;
	}
	
	public void setValore(double valore) {
		this.operazione = null;
		this.valore = valore;
	}
	
	//*****
	
	public boolean isFoglia() {
		return nextNodoDX == null && nextNodoSX == null;
	}
	
	//*****
	
	public boolean rendiOperazione(String operazione) {
		if(this.operazione != null)
			return false;
		
		this.operazione = operazione;
		this.nextNodoDX = new Nodo(this,valore);
		this.valore = 0.0;
		
		if(operazione == "+" || operazione == "-")
			this.nextNodoSX = new Nodo(this,0);
		else
			this.nextNodoSX = new Nodo(this,1);
		
		return true;
	}
	
	public boolean rendiOperazione(String operazione, double v1, double v2) {
		if(this.operazione != null)
			return false;
		
		this.operazione = operazione;
		this.nextNodoSX = new Nodo(this,v1);
		this.nextNodoDX = new Nodo(this,v2);
		this.valore = 0.0;
		
		return true;
	}
	
	public static double eseguiOperazione(String operazione, double v1, double v2) {
		double risultato = 0;
		
		switch(operazione) {
		case "+":
			risultato = v1 + v2;
			break;
		case "*":
			risultato = v1 * v2;
			break;
		case "-":
			risultato = v1 - v2;
			break;
		case "/":
			risultato = v1 / v2;
			break;
		}
		
		return risultato;
	}
}