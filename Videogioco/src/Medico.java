
public class Medico extends Personaggio {

	final static String OGGETTO_CURATIVO = "vitamine";
	
	public Medico(String nome) {
		super(nome);
	}

	@Override
	public void prestaSoccorso(Personaggio amico) {
		if(possiedeOggetto(OGGETTO_CURATIVO)) {
			amico.setVita(amico.getVita() + 4);
			this.togliOggetto(OGGETTO_CURATIVO);
		}
	}

	@Override
	public void infierisci(Personaggio nemico) {}

}
