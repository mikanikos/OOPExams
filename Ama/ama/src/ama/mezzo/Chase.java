package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Chase extends Brown {
	
	static private int progId=0;
	
	public Chase(Citta citta) {
		super(citta, progId++);
	}
	
	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return super.decidiDirezione(corrente);
		else return posizioneRifiutoNelleVicinanze;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}

}
