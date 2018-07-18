package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;
	
	private int versoSpostamento;
	
	public Pendo(Citta citta) {
		super(citta, progId++);
		this.versoSpostamento = 1;
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		Posizione successiva = corrente.traslazioneUnitaria(this.versoSpostamento, 0);
		if(this.getCitta().sulBordo(successiva)) {
			this.versoSpostamento = - this.versoSpostamento;
			return successiva;
		}
		return corrente.traslazioneUnitaria(this.versoSpostamento, 0);
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
