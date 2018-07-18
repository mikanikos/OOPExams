package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;

	private int versoSpostamento;

	final private Random rnd;

	public Pendo(Citta citta) {
		super(citta, progId++);
		this.rnd = new Random();
		this.versoSpostamento = deltaCasuale();
	}

	@Override
	public Posizione decidiDirezione(Posizione p) {
		Posizione nuova = p.traslazioneUnitaria(this.versoSpostamento,0); 
		if(getCitta().sulBordo(nuova)) {
			this.versoSpostamento = - this.versoSpostamento;
			return p.traslazioneUnitaria(this.versoSpostamento,0);
		}
		else
			return nuova;
		/*if(this.getCitta().sulBordo(p)) {
			if(this.versoSpostamento == 1)
				this.versoSpostamento = -1;
			if(this.versoSpostamento == -1)
				this.versoSpostamento = 1;
		}
		return p.traslazioneUnitaria(this.versoSpostamento,0);*/
	}

	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	private int deltaCasuale() {
		int a = 0;
		do {
			a = this.rnd.nextInt(3)-1;
		} while(a == 0);
		return a;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
