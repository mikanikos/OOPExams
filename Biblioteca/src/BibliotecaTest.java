import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BibliotecaTest {
	
	private Biblioteca biblio;
	private Autore aut1, aut2;
	private Libro lib1, lib2;
	private Selezionatore selAG, selAP;

	@Before
	public void setUp() throws Exception {
		this.biblio = new Biblioteca();
		this.aut1 = new Autore("autore1", 1);
		this.aut2 = new Autore("autore2", 2);
		this.lib1 = new Libro("libro1");
		this.lib2 = new Libro("libro2");
		this.lib1.addAutore(aut1);
		this.selAG = new SelezionatoreAutoriGiovani();
		this.selAP = new SelezionatoreAutoriProlifici();
	}

	@Test
	public void testAutore2libri_BibliotecaVuota() {
		assertEquals(0, this.biblio.autore2libri().size());
	}
	
	@Test
	public void testAutore2libri_BibliotecaSingletonConSingoloAutore() {
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(1, this.biblio.autore2libri().size());
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib1));
	}
	
	@Test
	public void testAutore2libri_BibliotecaSingletonConDueAutori() {
		this.lib1.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(2, this.biblio.autore2libri().size());
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib1));
		assertTrue(this.biblio.autore2libri().get(this.aut2).contains(lib1));
	}
	
	@Test
	public void testAutore2libri_BibliotecaDoubletonConStessoAutore() {
		this.lib2.addAutore(aut1);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(1, this.biblio.autore2libri().size());
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib1));
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib2));
	}
	
	@Test
	public void testAutore2libri_BibliotecaDoubletonConAutoriDiversi() {
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(2, this.biblio.autore2libri().size());
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib1));
		assertTrue(this.biblio.autore2libri().get(this.aut2).contains(lib2));
	}
	
	@Test
	public void testAutore2libri_BibliotecaVaria() {
		this.lib1.addAutore(aut2);
		this.lib2.addAutore(aut1);
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(2, this.biblio.autore2libri().size());
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib1));
		assertTrue(this.biblio.autore2libri().get(this.aut1).contains(lib2));
		assertTrue(this.biblio.autore2libri().get(this.aut2).contains(lib1));
		assertTrue(this.biblio.autore2libri().get(this.aut2).contains(lib2));
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaVuota() {
		assertEquals(0, this.biblio.seleziona(selAG).size());
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaSingletonConSingoloAutore() {
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(1, this.biblio.seleziona(selAG).size());
		assertSame(this.aut1, this.biblio.seleziona(selAG).get(0));
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaSingletonConDueAutori() {
		this.lib1.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(1, this.biblio.seleziona(selAG).size());
		assertTrue(this.biblio.seleziona(selAG).contains(aut2));
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaSingletonConDueAutoriStessaEta() {
		this.lib1.addAutore(new Autore("aut3", 1));
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(2, this.biblio.seleziona(selAG).size());
		assertTrue(this.biblio.seleziona(selAG).contains(aut1));
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaDoubletonConStessoAutore() {
		this.lib2.addAutore(aut1);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(1, this.biblio.seleziona(selAG).size());
		assertTrue(this.biblio.seleziona(selAG).contains(aut1));
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaDoubletonConAutoriDiversi() {
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(1, this.biblio.seleziona(selAG).size());
		assertTrue(this.biblio.seleziona(selAG).contains(aut2));
	}
	
	@Test
	public void testSelezionaAutoriGiovani_BibliotecaVaria() {
		this.lib1.addAutore(aut2);
		this.lib2.addAutore(aut1);
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(1, this.biblio.seleziona(selAG).size());
		assertTrue(this.biblio.seleziona(selAG).contains(aut2));
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaVuota() {
		assertEquals(0, this.biblio.seleziona(selAP).size());
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaSingletonConSingoloAutore() {
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(1, this.biblio.seleziona(selAP).size());
		assertSame(this.aut1, this.biblio.seleziona(selAP).get(0));
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaSingletonConDueAutori() {
		this.lib1.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale", this.lib1);
		assertEquals(2, this.biblio.seleziona(selAP).size());
		assertSame(this.aut1, this.biblio.seleziona(selAP).get(0));
		assertSame(this.aut2, this.biblio.seleziona(selAP).get(1));
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaConDueAutoriDiversiLibriPubblicati() {
		this.lib1.addAutore(aut2);
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(1, this.biblio.seleziona(selAP).size());
		assertTrue(this.biblio.seleziona(selAP).contains(aut2));
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaDoubletonConStessoAutore() {
		this.lib2.addAutore(aut1);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(1, this.biblio.seleziona(selAP).size());
		assertTrue(this.biblio.seleziona(selAP).contains(aut1));
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaDoubletonConAutoriDiversi() {
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(2, this.biblio.seleziona(selAP).size());
		assertSame(this.aut1, this.biblio.seleziona(selAP).get(0));
		assertSame(this.aut2, this.biblio.seleziona(selAP).get(1));
	}
	
	@Test
	public void testSelezionaAutoriProlifici_BibliotecaVaria() {
		this.lib1.addAutore(aut2);
		this.lib2.addAutore(aut1);
		this.lib2.addAutore(aut2);
		this.biblio.addLibro("codiceCasuale1", this.lib1);
		this.biblio.addLibro("codiceCasuale2", this.lib2);
		assertEquals(2, this.biblio.seleziona(selAP).size());
		assertSame(this.aut1, this.biblio.seleziona(selAP).get(0));
		assertSame(this.aut2, this.biblio.seleziona(selAP).get(1));
	}

}
