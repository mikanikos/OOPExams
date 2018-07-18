package soluzione;

public class Precipitazioni {

	private int[][] cartaPrecipitazioni;
	private Visualizzatore[] visualizzatori;
	private int numeroVisualizzatoriRegistrati;

	public Precipitazioni () {
		cartaPrecipitazioni = new int[20][20];
		visualizzatori = new Visualizzatore[10];
		numeroVisualizzatoriRegistrati=0;
	}

	int[][] getCartaPrecipitazioni() {
		return cartaPrecipitazioni;
	}

	public void aggiungiVisualizzatore(Visualizzatore v) {
		visualizzatori[numeroVisualizzatoriRegistrati]=v;
		numeroVisualizzatoriRegistrati++;
		v.setPrecipitazioni(this);
	}

	public void notificaAggiornamento(int tempo) {
		for (int i=0; i<numeroVisualizzatoriRegistrati;i++) {
			visualizzatori[i].aggiornaSchermata(tempo);
		}
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
			calcolaPrecipitazioni(tempo);
			notificaAggiornamento(tempo);
		}
	}

	public int getNumeroVisualizzatoriRegistrati() {
		return numeroVisualizzatoriRegistrati;
	}

}