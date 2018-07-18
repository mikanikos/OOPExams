public class Colore {
	
	private int red;
	private int green;
	private int blue;
	
	public Colore(int red, int green, int blue) {
		this.red = red; this.green = green; this.blue = blue; 
	}

	@Override
	public int hashCode() {
		return this.red + this.green + this.blue;
	}

	@Override
	public boolean equals(Object o) {
		Colore that = (Colore) o;
		return this.red == that.red && this.green == that.green && this.blue == that.blue;
	}
	
	
}
