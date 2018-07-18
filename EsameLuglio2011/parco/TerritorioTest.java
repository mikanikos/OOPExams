import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TerritorioTest {
	
	private Animale erbivoro, carnivoro;
	private Territorio territorio;

	@Before
	public void setUp() throws Exception {
		this.territorio = new Territorio(2);
		this.erbivoro = new Erbivoro();
		this.carnivoro = new Carnivoro();
	}

	@Test
	public void testAnni2animali_TerritorioVuoto() {
		assertEquals(0, this.territorio.anni2animali().size());
	}
	
	@Test
	public void testAnni2animali_TerritorioSingletonErbivoro() {
		this.territorio.setAnimale(erbivoro, new Posizione(0,0));
		assertEquals(1, this.territorio.anni2animali().size());
	}
	
	@Test
	public void testAnni2animali_TerritorioSingletonCarnivoro() {
		this.territorio.setAnimale(carnivoro, new Posizione(0,0));
		assertEquals(1, this.territorio.anni2animali().size());
	}
	
	@Test
	public void testAnni2animali_TerritorioDoubletonConAnniDiversi() {
		this.carnivoro.setAnni(1);
		this.erbivoro.setAnni(2);
		this.territorio.setAnimale(carnivoro, new Posizione(0,0));
		this.territorio.setAnimale(erbivoro, new Posizione(1,1));
		assertEquals(2, this.territorio.getAnimali().size());
		assertEquals(2, this.territorio.anni2animali().size());
		assertTrue(this.territorio.anni2animali().get(2).contains(erbivoro));
		assertTrue(this.territorio.anni2animali().get(1).contains(carnivoro));
	}
	
	@Test
	public void testAnni2animali_TerritorioDoubletonConAnniUguali() {
		this.carnivoro.setAnni(1);
		this.erbivoro.setAnni(1);
		this.territorio.setAnimale(carnivoro, new Posizione(0,0));
		this.territorio.setAnimale(erbivoro, new Posizione(1,1));
		assertEquals(2, this.territorio.getAnimali().size());
		assertEquals(1, this.territorio.anni2animali().size());
		assertTrue(this.territorio.anni2animali().get(1).contains(erbivoro));
		assertTrue(this.territorio.anni2animali().get(1).contains(carnivoro));
	}

}
