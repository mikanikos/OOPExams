public class Posizione {
	
	public int x, y;
	
	public Posizione (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public int hashCode() {
		return this.x + this.y;
	}
	
	public boolean equals(Object  that) {
		Posizione posizione = (Posizione) that;
		return ((this.x == posizione.getX()) && 
				(this.y == posizione.getY()));
	}
	
	public String toString() {
		return this.x+"-"+this.y;
	}
}