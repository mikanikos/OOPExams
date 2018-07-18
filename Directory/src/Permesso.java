public class Permesso {
	
	public String nome;
	
	public Permesso(String nome) { this.nome = nome; }
	
	public void setNome(String nome) { this.nome = nome; }
	
	public String getNome() { return this.nome; }

	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Permesso that = (Permesso) o;
		return this.getNome().equals(that.getNome());
	}
	
	

} 
