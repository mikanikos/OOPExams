import java.util.Collections;

public class Soldato extends Personaggio {

	final static String OGGETTO_DIFENSIVO = "scudo";
	
	public Soldato(String nome) {
		super(nome);
	}

	@Override
	public void prestaSoccorso(Personaggio amico) {
		this.colpisci(Collections.min(amico.getNemici(), new ComparatorePerVita()));
	}

	@Override
	public void infierisci(Personaggio nemico) {
		if(!possiedeOggetto(OGGETTO_DIFENSIVO)) {
			nemico.setVita(nemico.getVita() - 2);
		}
	}

}
