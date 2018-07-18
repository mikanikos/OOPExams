import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisegnoTest {
	
	private Disegno disegno;
	private Forma rect, circle;
	private Colore c1, c2;

	@Before
	public void setUp() throws Exception {
		this.c1 = new Colore(0, 0, 0);
		this.c2 = new Colore(1, 1, 1);
		this.rect = new Rettangolo(this.c1, new Punto(0,0), 1, 1);
		this.disegno = new Disegno();
	}

	@Test
	public void testColore2forme_DisegnoVuoto() {
		assertEquals(0, this.disegno.colore2forme().size());
	}
	
	@Test
	public void testColore2forme_DisegnoSingleton() {
		this.disegno.aggiungiForma(rect, 0);
		assertEquals(1, this.disegno.colore2forme().size());
		assertSame(this.rect, this.disegno.colore2forme().get(c1).get(0));
	}
	
	@Test
	public void testColore2forme_DisegnoDoubletonColoreDiverso() {
		this.circle = new Cerchio(this.c2, new Punto(1,0), 1);
		this.disegno.aggiungiForma(rect, 0);
		this.disegno.aggiungiForma(circle, 1);
		assertEquals(2, this.disegno.colore2forme().size());
		assertSame(this.rect, this.disegno.colore2forme().get(c1).get(0));
		assertSame(this.circle, this.disegno.colore2forme().get(c2).get(0));
	}
	
	@Test
	public void testColore2forme_DisegnoDoubletonStessoColore() {
		this.circle = new Cerchio(this.c1, new Punto(1,0), 1);
		this.disegno.aggiungiForma(circle, 0);
		this.disegno.aggiungiForma(rect, 1);
		assertEquals(1, this.disegno.colore2forme().size());
		assertSame(this.rect, this.disegno.colore2forme().get(c1).get(0));
		assertSame(this.circle, this.disegno.colore2forme().get(c1).get(1));
	}
	
	@Test
	public void testFormeOrdinatePerLuminosita_DisegnoVuoto() {
		assertEquals(0, this.disegno.formeOrdinatePerLuminosita().size());
	}
	
	@Test
	public void testFormeOrdinatePerLuminosita_DisegnoSingleton() {
		this.disegno.aggiungiForma(rect, 0);
		assertEquals(1, this.disegno.formeOrdinatePerLuminosita().size());
		assertSame(this.rect, this.disegno.formeOrdinatePerLuminosita().get(0));
	}
	
	@Test
	public void testFormeOrdinatePerLuminosita_DisegnoDoubletonColoreDiverso() {
		this.circle = new Cerchio(this.c2, new Punto(1,0), 1);
		this.disegno.aggiungiForma(circle, 0);
		this.disegno.aggiungiForma(rect, 1);
		assertEquals(2, this.disegno.formeOrdinatePerLuminosita().size());
		assertSame(this.rect, this.disegno.formeOrdinatePerLuminosita().get(0));
		assertSame(this.circle, this.disegno.formeOrdinatePerLuminosita().get(1));
	}
	
	@Test
	public void testFormeOrdinatePerLuminosita_DisegnoDoubletonStessoColore() {
		this.circle = new Cerchio(this.c1, new Punto(1,0), 1);
		this.disegno.aggiungiForma(circle, 0);
		this.disegno.aggiungiForma(rect, 1);
		assertEquals(2, this.disegno.formeOrdinatePerLuminosita().size());
		assertTrue(this.disegno.formeOrdinatePerLuminosita().contains(circle));
		assertTrue(this.disegno.formeOrdinatePerLuminosita().contains(rect));
	}
	
	@Test
	public void testColoriPresentiNelDisegno() {
		this.circle = new Cerchio(this.c2, new Punto(1,0), 1);
		Colore nuovo = new Colore(1, 1, 1);
		Forma forma = new Cerchio(nuovo, new Punto(1,0), 1);
		this.disegno.aggiungiForma(forma, 0);
		this.disegno.aggiungiForma(circle, 0);
		this.disegno.aggiungiForma(rect, 1);
		assertEquals(2, this.disegno.coloriPresentiNelDisegno().size());
		assertTrue(this.disegno.coloriPresentiNelDisegno().contains(c1));
		assertTrue(this.disegno.coloriPresentiNelDisegno().contains(nuovo));
		assertTrue(this.disegno.coloriPresentiNelDisegno().contains(c2));
	}
	
}
