package esame;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UtilityTest {
	
	private Documento doc1;
	private Documento doc2;
	private List<Documento> docs;
	private Utente utente;

	@Before
	public void setUp() throws Exception {
		this.doc1 = new Documento("doc1", 1, "Gennaio", new PermessoAccesso("lettura"));
		this.doc2 = new Documento("doc2", 1, "Gennaio", new PermessoAccesso("scrittura"));
		this.docs = new ArrayList<>();
		this.utente = new Utente("User1");
		/*this.docs.add(doc1);
		this.doc1.getPermessoAccesso("lettura").addUtente(new Utente("User1"));
		this.docs.add(doc2);
		this.doc2.getPermessoAccesso("scrittura").addUtente(new Utente("User1"));*/
	}

	@Test
	public void testListaDocumentiVuota() {
		assertEquals(0, Utility.utente2docs(this.docs, "lettura").size());
	}
	
	@Test
	public void testListaSingleton() {
		this.docs.add(doc1);
		this.doc1.getPermessoAccesso("lettura").addUtente(utente);
		assertEquals(1, Utility.utente2docs(this.docs, "lettura").size());
		assertEquals(this.doc1, Utility.utente2docs(this.docs, "lettura").get(utente).get(0));
	}
	
	@Test
	public void testListaDoubletonParticolare() {
		this.docs.add(doc1);
		this.doc1.getPermessoAccesso("lettura").addUtente(utente);
		this.docs.add(doc2);
		this.doc2.getPermessoAccesso("scrittura").addUtente(utente);
		assertEquals(1, Utility.utente2docs(this.docs, "lettura").size());
		assertEquals(this.doc1, Utility.utente2docs(this.docs, "lettura").get(utente).get(0));
		assertEquals(1, Utility.utente2docs(this.docs, "lettura").get(utente).size());
	}
	
	@Test
	public void testListaDoubleton() {
		this.docs.add(doc1);
		this.doc1.getPermessoAccesso("lettura").addUtente(utente);
		this.doc1.getPermessoAccesso("lettura").addUtente(new Utente("User2"));
		Documento doc3 = new Documento("doc3", 1, "Gennaio", new PermessoAccesso("lettura"));
		this.docs.add(doc3);
		doc3.getPermessoAccesso("lettura").addUtente(utente);
		this.docs.add(doc2);
		this.doc2.getPermessoAccesso("scrittura").addUtente(utente);
		assertEquals(2, Utility.utente2docs(this.docs, "lettura").size());
		assertEquals(this.doc1, Utility.utente2docs(this.docs, "lettura").get(utente).get(0));
		assertEquals(doc3, Utility.utente2docs(this.docs, "lettura").get(utente).get(1));
		assertEquals(2, Utility.utente2docs(this.docs, "lettura").get(utente).size());
	}

}
