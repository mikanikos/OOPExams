public class Autore implements Comparable<Autore> {
	
	private int annoNascita;
	private String nome;
	private int libriPubblicati;
	
	public Autore(String nome, int annoNascita) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.libriPubblicati = 0;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getAnnoNascita() {
		return this.annoNascita;
	}
	
	public int getLibriPubblicati() {
		return this.libriPubblicati;
	}
	
	public void aggiungiLibroPubblicato() {
		this.libriPubblicati++;
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getAnnoNascita();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		Autore that = (Autore) o;
		return this.getNome().equals(that.getNome()) && this.getAnnoNascita() == that.getAnnoNascita();
	}

	@Override
	public int compareTo(Autore that) {
		int a = this.getAnnoNascita() - that.getAnnoNascita();
		if(a == 0)
			a = this.getNome().compareTo(that.getNome());
		return a;
	}
	
	
}