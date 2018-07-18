package battlefield;

public abstract class Robot implements Comparable<Robot>{
	
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
	
	public abstract Robot creaClone(Position p);
	
	public abstract Position decidiMossa(Battlefield field);
	
	@Override
	public int compareTo(Robot that) {
		int a = this.getLongevita() - that.getLongevita();
		if(a == 0) {
			int b = this.getPosizione().getX() - that.getPosizione().getX();
			if(b == 0)
				return this.getPosizione().getY() - that.getPosizione().getY();
			return b;
		}
		return a;
		
	}
	
}
