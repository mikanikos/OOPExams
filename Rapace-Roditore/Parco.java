import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parco {
	private static final int NUM_INIZIALE_ANIMALI = 2200;
	private static final double PROBABILITA_RAPACE = 0.2;

	private int dimensione;
	private Map<Posizione, Animale> posizione2animale;

	public Parco(int dimensione){
		this.dimensione = dimensione;
		this.posizione2animale = new TreeMap<Posizione, Animale>();
		this.popolaTerritorio();
	}

	public Animale getAnimale(Posizione posizione){
		return posizione2animale.get(posizione);
	}

	public void eliminaAnimale(Animale animale) {
		this.posizione2animale.remove(animale.getPosizione());
	}

	public void setAnimale(Animale animale, Posizione posizione) {
		if (this.getAnimale(posizione)==null){
			this.posizione2animale.put(posizione, animale);
			animale.setPosizione(posizione);
		}
	}

	public Collection<Animale> getAnimali(){
		return this.posizione2animale.values();
	}

	public Map<Integer, Integer> cibo2numeroRoditori() {
		Map<Integer, Integer> cibo2rod = new HashMap<>();
		for (Animale a : this.posizione2animale.values()) {
			if (a.getClass() == Roditore.class) {
				Integer num = cibo2rod.get(a.getCibo());
				if (num == null) {
					num = 1;
					cibo2rod.put(a.getCibo(), num);
				}
				num++;
			}
		}
		return cibo2rod;
	}

	public List<Animale> roditoriOrdinatiPerEtaCibo() {
		List<Animale> listaRoditori = new ArrayList<>();
		for (Animale a : this.posizione2animale.values())
			if (a.getClass() == Roditore.class)
				listaRoditori.add(a);
		Collections.sort(listaRoditori, new ComparatorePerEtaCibo());
		return listaRoditori;
	}

	public void muovi(Animale animale, Posizione nuovaPosizione) {
		this.eliminaAnimale(animale);
		this.setAnimale(animale, nuovaPosizione);
	}

	public List<Posizione> adiacenti(Posizione posizione) {
		List<Posizione> adiacenti = new LinkedList<Posizione>();
		int x = posizione.getX();
		int y = posizione.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				adiacenti.add(new Posizione(x+i, y+j));
			}
		}
		Iterator<Posizione> it = adiacenti.iterator();
		while(it.hasNext()){
			Posizione p = it.next();
			if ((p.getX()<0) || (p.getX()>=this.dimensione) || (p.getY()<0) ||
					(p.getY()>=this.dimensione) || (p.equals(posizione)))
				it.remove();
		}
		Collections.shuffle(adiacenti);
		return adiacenti;
	}

	public Posizione posizioneLiberaVicino(Posizione posizione) {
		for(Posizione p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Posizione posizione) {
		if (this.getAnimale(posizione)==null) {
			return true;
		} else
			return false;
	}

	public int getDimensione() {
		return this.dimensione;
	}

	private void popolaTerritorio(){

		int numeroAnimali = 0;

		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*this.dimensione);
			int y = (int)(Math.random()*this.dimensione);
			Posizione posizione = new Posizione(x, y);
			if (this.isLibera(posizione)) {
				if(Math.random() < PROBABILITA_RAPACE) {
					Rapace nuovoAnimale = new Rapace();
					this.setAnimale(nuovoAnimale, posizione);
				} else {
					Roditore nuovoAnimale = new Roditore();
					this.setAnimale(nuovoAnimale, posizione);
				}
				numeroAnimali++;
			}
		}
	}

}
