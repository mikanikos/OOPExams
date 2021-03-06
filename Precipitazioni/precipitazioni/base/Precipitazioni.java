package base;

import java.util.LinkedList;
import java.util.List;

public class Precipitazioni {

	private int[][] cartaPrecipitazioni;
	private Visualizzatore visualizzatore;

	public Precipitazioni () {
		this.cartaPrecipitazioni = new int[20][20];
		this.visualizzatore = new VisualizzatoreMatrice();
	}

	int[][] getCartaPrecipitazioni() {
		return this.cartaPrecipitazioni;
	}

	public void addVisualizzatore(Visualizzatore visualizzatore) {
		this.visualizzatore = visualizzatore;
		visualizzatore.setPrecipitazioni(this);
	}
	
	public void notificaAggiornamento(int tempo) {
			this.visualizzatore.aggiornaSchermata(tempo);
	}

	private void calcolaPrecipitazioni(int istanteTemporale){
		for (int i=0; i<this.cartaPrecipitazioni.length; i++)
			for (int j=0; j<this.cartaPrecipitazioni[i].length; j++)
				this.cartaPrecipitazioni[i][j] = (int)(Math.random()*10);
		try { Thread.sleep( 100); }
		catch( InterruptedException e ) {
			e.printStackTrace();
		}
	}

	public void eseguiSimulazione() {
		for (int tempo=0; tempo<100; tempo++) {
			this.calcolaPrecipitazioni(tempo);
			this.notificaAggiornamento(tempo);
		}
	}
}