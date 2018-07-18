package it.uniroma3.diadia.selezionatori;

import it.uniroma3.diadia.Autore;
import it.uniroma3.diadia.Libro;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SelezionatoreAutoriGiovani implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		Set<Autore> autoriGiovani = new HashSet<Autore>();
		int annoDeiPiuGiovani = getAnnoPiuGiovane(libriInBiblioteca);
		for (Libro libro : libriInBiblioteca){
			for (Autore autore : libro.getAutori()){
				if (autore.getAnnoNascita() == annoDeiPiuGiovani)
					autoriGiovani.add(autore);
			}
		}
		return new ArrayList<Autore>(autoriGiovani);
	}
	
	private int getAnnoPiuGiovane(List<Libro> libri){
		int annoMax = 0; //Nessun autore avrà un anno di nascita negativo, quindi 0 è il minimo
		for (Libro libro : libri){
			for (Autore autore : libro.getAutori()){
				if (autore.getAnnoNascita() > annoMax)
					annoMax = autore.getAnnoNascita();
			}
		}
		return annoMax;
	}

}
