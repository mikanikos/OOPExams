import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulatore {

	private static final int NUM_INIZIALE_ANIMALI = 2200;
	private static final double PROBABILITA_CARNIVORO = 0.2;
	private static final int PASSI = 100000;
	private static final int DIMENSIONE = 100;

	private Territorio territorio;
	private VisualizzatoreTerritorio visualizzatore;
	
	public Simulatore(){
		this.territorio = new Territorio(DIMENSIONE);
		this.popolaTerritorio();
		this.visualizzatore = new VisualizzatoreTerritorio(DIMENSIONE);
	}

	public void run(){
		for(int i=0;i<PASSI; i++) {
			List<Animale> animali = new ArrayList<Animale>(this.territorio.getAnimali());
			Collections.shuffle(animali);
			for(Animale a : animali) {
				a.agisci(territorio);
			}
			this.visualizzatore.aggiornaSchermata(i, this.territorio);
		}
	}
	
	private void popolaTerritorio(){
		
		int numeroAnimali = 0;
		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*DIMENSIONE);
			int y = (int)(Math.random()*DIMENSIONE);
			Posizione posizione = new Posizione(x, y);
			if (this.territorio.getAnimale(posizione)==null) {
				Animale nuovoAnimale;
				if(Math.random() < PROBABILITA_CARNIVORO) {
					nuovoAnimale = new Carnivoro();
				} else {
					nuovoAnimale = new Erbivoro();
				}
				this.territorio.setAnimale(nuovoAnimale, posizione);
				numeroAnimali++;
			}
		}
	}
	
	public static void main(String[] args) {
		Simulatore s = new Simulatore();
		s.run();
	}
}
