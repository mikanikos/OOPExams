import java.util.*;
public abstract class Personaggio {

	public static final int MORIBONDO = 5;
	public static final int VITA_INIZIALE = 100;
	private String nome;
	private int livelloVita;
	private Set<Personaggio> amici;
	private Set<Personaggio> nemici;
	private List<String> inventarioOggetti;

	public Personaggio(String nome) {
		this.nome = nome;
		this.amici = new HashSet<>();
		this.nemici = new HashSet<>();
		this.livelloVita = VITA_INIZIALE; 
		this.inventarioOggetti = new ArrayList<String>();
	}

	public String getNome() {
		return this.nome;
	}

	public int getVita() {
		return this.livelloVita;
	}

	public void setVita(int vita) {
		this.livelloVita = vita;
	}

	public void aggiungiOggetto(String oggetto) {
		inventarioOggetti.add(oggetto);
	}

	public void togliOggetto(String oggetto) {
		this.inventarioOggetti.remove(oggetto);
	}

	public boolean possiedeOggetto(String oggetto){
		return inventarioOggetti.contains(oggetto);
	}

	public void addAmico(Personaggio amico) {
		if (!this.nemici.contains(amico))
			this.amici.add(amico);
	}

	public void addNemico(Personaggio nemico) {
		if (!this.amici.contains(nemico))
			this.nemici.add(nemico);
	}

	public Set<Personaggio> getAmici() {
		return this.amici;
	}

	public Set<Personaggio> getNemici() {
		return this.nemici;
	}

	public void colpisci(Personaggio personaggio) {
		personaggio.subisciColpo();
	}

	public void subisciColpo() {
		this.livelloVita--;
		for(Personaggio amico : this.amici)
			amico.riceviNotificaColpoSubitoDa(this);
		for(Personaggio nemico : this.nemici)
			nemico.riceviNotificaColpoSubitoDa(this);
	}

	public void riceviNotificaColpoSubitoDa(Personaggio personaggio) {
		if (personaggio.getVita() < MORIBONDO) {
			if (this.amici.contains(personaggio))
				this.prestaSoccorso(personaggio);
			if(this.nemici.contains(personaggio))
				this.infierisci(personaggio);
		}
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Personaggio that = (Personaggio) o;
		return this.getNome().equals(that.getNome());
	}

	public abstract void prestaSoccorso(Personaggio amico);
	public abstract void infierisci(Personaggio nemico);
}