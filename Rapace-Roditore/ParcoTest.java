import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParcoTest {
	
	private Parco parco;
	private Roditore rod1, rod2;
	private Rapace rap;

	@Before
	public void setUp() throws Exception {
		this.parco = new Parco(2); 
		this.rap = new Rapace();
		this.rod1 = new Roditore();
		this.rod2 = new Roditore();
		this.parco.setAnimale(rap, new Posizione(1, 1));
		
	}

	@Test
	public void testRoditoriOrdinatiPerEtaCibo_ParcoVuoto() {
		assertEquals(0, this.parco.roditoriOrdinatiPerEtaCibo().size());
	}
	
	@Test
	public void testRoditoriOrdinatiPerEtaCibo_Singleton() {
		this.parco.setAnimale(rod1, new Posizione(0,0));
		assertEquals(1, this.parco.roditoriOrdinatiPerEtaCibo().size());
	}
	
	@Test
	public void testRoditoriOrdinatiPerEtaCibo_DoubletonConEtaDiversa() {
		this.parco.setAnimale(rod1, new Posizione(0,0));
		this.parco.setAnimale(rod2, new Posizione(1,0));
		this.rod1.invecchia();
		assertEquals(2, this.parco.roditoriOrdinatiPerEtaCibo().size());
		assertSame(this.rod2, this.parco.roditoriOrdinatiPerEtaCibo().get(0));
		assertSame(this.rod1, this.parco.roditoriOrdinatiPerEtaCibo().get(1));
	}
	
	@Test
	public void testRoditoriOrdinatiPerEtaCibo_DoubletonConStessaEta() {
		this.parco.setAnimale(rod1, new Posizione(0,0));
		this.parco.setAnimale(rod2, new Posizione(1,0));
		this.rod1.invecchia();
		this.rod2.invecchia();
		this.rod2.incrementaCibo(2);
		assertEquals(2, this.parco.roditoriOrdinatiPerEtaCibo().size());
		assertSame(this.rod1, this.parco.roditoriOrdinatiPerEtaCibo().get(0));
		assertSame(this.rod2, this.parco.roditoriOrdinatiPerEtaCibo().get(1));
	}

}
