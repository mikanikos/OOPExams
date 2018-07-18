public class Colore {
	
	private int red;
	private int green;
	private int blue;
	
	public Colore(int red, int green, int blue) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	
	public int getRed() {
		return this.red;
	}
	
	public int getGreen() {
		return this.green;
	}
	
	public int getBlue() {
		return this.blue;
	}
	
	public int luminosita() {
		return (this.red + this.green + this.blue) ;
	}

	@Override
	public int hashCode() {
		return this.luminosita();
	}

	@Override
	public boolean equals(Object o) {
		Colore that = (Colore) o;
		return this.getBlue() == that.getBlue() && this.getGreen() == that.getGreen() && this.getRed() == that.getRed();
	}
	
	

}