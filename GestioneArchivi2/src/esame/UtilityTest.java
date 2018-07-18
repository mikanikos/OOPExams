package esame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UtilityTest {
	
	private List<Documento> lista;
	private PermessoAccesso permesso1;
	private Utente user1, user2;
	private Documento d1, d2;
	
	
	@Before
	public void setUp() throws Exception {
		this.user1 = new Utente("user1");
		this.permesso1 = new PermessoAccesso("permesso1");
		this.permesso1.addUtente(this.user1);
		this.d1 = new Documento("doc1", 1, "data1", this.permesso1);
		this.lista = new ArrayList<>();
	}

	@Test
	public void testUtente2docs_ListaDocumentiVuota() {
		assertEquals(0, Utility.utente2docs(this.lista, this.permesso1.getNome()).size());
	}
	
	@Test
	public void testUtente2docs_ListaSingleton() {
		this.lista.add(d1);
		assertEquals(1, Utility.utente2docs(this.lista, this.permesso1.getNome()).size());
	}
	
	@Test
	public void testUtente2docs_ListaSingleton_DueUtenti() {
		this.lista.add(d1);
		this.user2 = new Utente("user2");
		this.permesso1.addUtente(this.user2);
		assertEquals(2, Utility.utente2docs(this.lista, this.permesso1.getNome()).size());
	}
	
	@Test
	public void testUtente2docs_ListaDoubleton() {
		this.d2 = new Documento("doc2", 2, "data2", this.permesso1);
		this.lista.add(d1);
		this.lista.add(d2);
		assertEquals(1, Utility.utente2docs(this.lista, this.permesso1.getNome()).size());
		assertEquals(2, Utility.utente2docs(this.lista, this.permesso1.getNome()).get(user1).size());
	}

}
