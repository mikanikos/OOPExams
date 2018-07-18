import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Territorio {

	private int dimensione;	
	private Map<Posizione, Animale> posizione2animale;	
	
	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2animale = new HashMap<Posizione, Animale>();
	}
	
	public Animale getAnimale(Posizione posizione){
		return posizione2animale.get(posizione);
	}

	public void rimuoviAnimale(Animale animale) {
		this.posizione2animale.remove(animale.getPosizione());
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
			if (this.getAnimale(p)==null) {
				return p;
			}
		}
		return null;
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

	public int getDimensione() {
		return this.dimensione;
	}

	public void sposta(Animale animale, Posizione nuovaPosizione) {
		this.rimuoviAnimale(animale);
		this.setAnimale(animale, nuovaPosizione);		
	}	
}
