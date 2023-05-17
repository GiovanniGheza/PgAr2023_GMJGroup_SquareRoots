package main;

public class Albero {
	private static final int MAX = 100;
	private static final int MIN = -100;
	Nodo radice = new Nodo();
	int numeroNodi;
	
	public Albero() {
	}
	
	/**
	 * genera casualmente un albero
	 * @param lunghezza - quante operazioni ci saranno nell'albero
	 */
	public void generaCasualmente(int lunghezza) {
		Nodo nodoInQuestone = radice;
		
		for(int i = 0; i < lunghezza; i++) {
			
			nodoInQuestone.setOperazione(operazioneCasuale());
			
			nodoInQuestone.setNextNodoDX(
					new Nodo(nodoInQuestone,NumeriCasuali.estraiIntero(MIN,MAX))
					);
			nodoInQuestone.setNextNodoSX(
					new Nodo(nodoInQuestone,NumeriCasuali.estraiIntero(MIN,MAX))
					);
			
			if(NumeriCasuali.tiraMoneta()) {
				nodoInQuestone = nodoInQuestone.getNextNodoDX();
			} else {
				nodoInQuestone = nodoInQuestone.getNextNodoSX();
			}
		}
	}
	
	/**
	 * generatore casuale dell'operazione
	 * @return una delle 4 operazioni
	 */
	private String operazioneCasuale() {
		return Nodo.OPERAZIONI[NumeriCasuali.estraiIntero(0, 3)];
	}
	
	//*****
	
	public String toString() {
		StringBuffer str = new StringBuffer("");
		
		str.append(toString(radice));
		
		str.deleteCharAt(0);
		str.deleteCharAt(str.length() - 1);
		
		return str.toString();
	}
	
	private String toString(Nodo nodoInQuestione) {
		if(nodoInQuestione.isFoglia())
			if(nodoInQuestione.getValore() < 0)
				return "(" + nodoInQuestione.getContenuto() + ")";
			else
				return nodoInQuestione.getContenuto();
		else
			return "("
					+ toString(nodoInQuestione.getNextNodoSX())
					+ nodoInQuestione.getContenuto()
					+ toString(nodoInQuestione.getNextNodoDX())
					+ ")";
	}
	
	public double calcola() {
		return calcola(radice);
	}
	
	private double calcola(Nodo nodoInQuestione) {
		if(nodoInQuestione.isFoglia()) {
				return nodoInQuestione.getValore();
		} else {
			return Nodo.eseguiOperazione(
						nodoInQuestione.getContenuto()
						,calcola(nodoInQuestione.getNextNodoSX())
						,calcola(nodoInQuestione.getNextNodoDX())
						);
		}
	}
}