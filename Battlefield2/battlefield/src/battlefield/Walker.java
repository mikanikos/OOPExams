package battlefield;


public class Walker extends Robot {
	
	public Walker(Position p) {
		super(p);
	}
	
	@Override
	public Position decidiMossa(Battlefield field) {
		Position corrente = this.getPosizione();
		Position libera = field.posizioneLiberaVicino(corrente);
		return libera; // verso una posizione libera
					   // tutto occupato: fermo
	}
	
	@Override
	public Walker creaClone(Position nuova) {
		return new Walker(nuova);
	}
	
}

