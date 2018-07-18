package battlefield;

public abstract class Robot implements Comparable<Robot> {
	
	private Position posizione;
	private int longevita;
	
	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0 ;
	}
	
	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	public void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);
		if (nuova!=null) {
			Robot clone = this.creaClone(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	public abstract Robot creaClone(Position nuova);
	
	public abstract Position decidiMossa(Battlefield field);

	@Override
	public int hashCode() {
		return this.posizione.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		Robot that = (Robot) o;
		return this.getPosizione().equals(that.getPosizione());
	}
	
	@Override
	public int compareTo(Robot r) {
		int ris = this.getLongevita() - r.getLongevita();
		if(ris == 0)
			ris = new ComparatorePerPosizione().compare(this, r);
		return ris;
	}

}
