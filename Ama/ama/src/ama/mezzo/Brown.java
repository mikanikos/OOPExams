package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_GIALLO;

import java.awt.Image;
import java.util.Random;

import ama.Citta;
import ama.Posizione;

public class Brown extends Politica{
	
	static private int progId=0;
	
	final private Random rnd;
	
	public Brown(Citta citta) {
		this(citta, progId++);
	}
	
	public Brown(Citta citta, int id) {
		super(citta, id);
		this.rnd = new Random();
	}
	
	@Override
	public Posizione decidiDirezione(Posizione p) {
		return p.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
	}

	/**
	 * 
	 * @return un numero intero casuale tra -1,0,+1
	 */
	private int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	
	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_GIALLO;
	}
}
