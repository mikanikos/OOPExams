import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartellaTest {

	private File file1, file2;
	private Cartella cart1, cart2;

	@Before
	public void setUp() throws Exception {
		this.cart1 = new Cartella("cartella1", "responsabile1");
		this.cart2 = new Cartella("cartella2", "responsabile2");
		this.file1 = new File("file1", 2, "responsabile1");
		this.file2 = new File("file2", 3, "responsabile3");
		this.cart1.addRisorsa(file1);
	}

	@Test
	public void testGetCosto_ProgettoSemplice() {
		this.cart1.addRisorsa(file2);
		assertEquals(5, this.cart1.getDimensione());
	}
	
	@Test
	public void testGetCosto_ProgettoComplesso() {
		this.cart2.addRisorsa(file2);
		this.cart1.addRisorsa(cart2);
		assertEquals(5, this.cart1.getDimensione());
	}
	
	@Test
	public void testResponsabile2compito_ProgettoSemplice() {
		this.cart1.addRisorsa(file2);
		assertEquals(2, this.cart1.proprietario2risorsa().size());
		assertTrue(this.cart1.proprietario2risorsa().get(cart1.getProprietario()).contains(this.cart1));
		assertTrue(this.cart1.proprietario2risorsa().get(file1.getProprietario()).contains(this.file1));
		assertTrue(this.cart1.proprietario2risorsa().get(file2.getProprietario()).contains(this.file2));
	}
	
	@Test
	public void testResponsabile2compito_ProgettoComplesso() {
		this.cart2.addRisorsa(file2);
		this.cart1.addRisorsa(cart2);
		this.cart1.addRisorsa(file2);
		assertEquals(3, this.cart1.proprietario2risorsa().size());
		assertTrue(this.cart1.proprietario2risorsa().get(cart1.getProprietario()).contains(this.cart1));
		assertTrue(this.cart1.proprietario2risorsa().get(file1.getProprietario()).contains(this.file1));
		assertTrue(this.cart1.proprietario2risorsa().get(file2.getProprietario()).contains(this.file2));
		assertTrue(this.cart1.proprietario2risorsa().get(cart2.getProprietario()).contains(this.cart2));
	}

}
