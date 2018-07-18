import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TerritorioTest {

	private Animale erb, car;
	private Territorio t;
	
	@Before
	public void setUp() throws Exception {
		this.erb = new Erbivoro();
		this.car = new Carnivoro();
		this.t = new Territorio(2);
	}

	@Test
	public void testAnno2animali_TerritorioVuoto() {
		assertEquals(0, this.t.anno2animali().size());
	}
	
	@Test
	public void testAnno2animali_TerritorioSingleton() {
		this.t.setAnimale(this.erb, new Posizione(0,0));
		assertEquals(1, this.t.anno2animali().size());
	}
	
	@Test
	public void testAnno2animali_TerritorioDoubletonAnnoConDiverso() {
		this.t.setAnimale(this.erb, new Posizione(0,0));
		this.t.setAnimale(this.car, new Posizione(1,0));
		this.car.incrementaAnni();
		assertEquals(2, this.t.anno2animali().size());
	}
	
	@Test
	public void testAnno2animali_TerritorioDoubletonAnnoUguale() {
		this.t.setAnimale(this.erb, new Posizione(0,0));
		this.t.setAnimale(this.car, new Posizione(1,0));
		assertEquals(1, this.t.anno2animali().size());
		assertEquals(2, this.t.anno2animali().get(0).size());
	}

}
