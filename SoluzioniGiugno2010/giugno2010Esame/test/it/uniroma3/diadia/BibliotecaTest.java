package it.uniroma3.diadia;

import static org.junit.Assert.*;

import it.uniroma3.diadia.selezionatori.SelezionatoreAutoriGiovani;
import it.uniroma3.diadia.selezionatori.SelezionatoreAutoriProlifici;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BibliotecaTest {
	
	private Biblioteca biblioteca;
	private Autore torlone;
	private Autore atzeni;
	private Autore cabibbo;
	private Autore battista;
	private Libro basididati;
	private Libro fondinf;
	private Libro analisisw;
	private Libro teoriabasidati;
	private Libro graphdrawing;

	@Before
	public void setUp() throws Exception {
		this.biblioteca = new Biblioteca();
		this.torlone = new Autore("Torlone", 10);
		this.atzeni = new Autore("Atzeni", 5);
		this.cabibbo = new Autore("Cabibbo", 2);
		this.battista = new Autore("Di Battista", 10);
		this.basididati = new Libro("Basi Di Dati");
		this.basididati.AddAutore(this.torlone);
		this.basididati.AddAutore(this.atzeni);
		this.fondinf = new Libro("Fondamenti di Informatica");
		this.fondinf.AddAutore(this.cabibbo);
		this.analisisw = new Libro("Analisi del software");
		this.analisisw.AddAutore(this.cabibbo);
		this.teoriabasidati = new Libro("Teoria Basi di Dati");
		this.teoriabasidati.AddAutore(this.atzeni);
		this.graphdrawing = new Libro("Graph Drawing");
		this.graphdrawing.AddAutore(this.battista);
	}

	
	@Test
	public void testAutore2Libri_conNessunLibro() {
		Map<Autore, Set<Libro>> autore2libro = this.biblioteca.autore2Libri();
		assertEquals(0, autore2libro.size());
	}

	@Test
	public void testAutore2Libri_conLibriScrittiDaUnAutore() {
		this.biblioteca.addLibro(this.analisisw.getTitolo(), this.analisisw);
		this.biblioteca.addLibro(this.graphdrawing.getTitolo(), this.graphdrawing);
		Map<Autore, Set<Libro>> autore2libro = this.biblioteca.autore2Libri();
		assertEquals(2, autore2libro.size());
		assertTrue(autore2libro.containsKey(this.cabibbo));
		assertTrue(autore2libro.containsKey(this.battista));
		assertEquals(1, autore2libro.get(this.cabibbo).size());
		assertEquals(1, autore2libro.get(this.battista).size());
		assertTrue(autore2libro.get(this.cabibbo).contains(this.analisisw));
		assertTrue(autore2libro.get(this.battista).contains(this.graphdrawing));
	}
	
	@Test
	public void testAutore2Libri_conLibriScrittiDaPiuAutori() {
		this.biblioteca.addLibro(this.basididati.getTitolo(), this.basididati);
		this.biblioteca.addLibro(this.fondinf.getTitolo(), this.fondinf);
		Map<Autore, Set<Libro>> autore2libro = this.biblioteca.autore2Libri();
		assertEquals(3, autore2libro.size());
		assertTrue(autore2libro.containsKey(this.cabibbo));
		assertTrue(autore2libro.containsKey(this.torlone));
		assertTrue(autore2libro.containsKey(this.atzeni));
		assertEquals(1, autore2libro.get(this.cabibbo).size());
		assertEquals(1, autore2libro.get(this.torlone).size());
		assertEquals(1, autore2libro.get(this.atzeni).size());
		assertTrue(autore2libro.get(this.cabibbo).contains(this.fondinf));
		assertTrue(autore2libro.get(this.torlone).contains(this.basididati));
		assertTrue(autore2libro.get(this.atzeni).contains(this.basididati));
	}
	
	@Test
	public void testAutore2Libri_conLibriScrittiDagliStessiAutori() {
		this.biblioteca.addLibro(this.fondinf.getTitolo(), this.fondinf);
		this.biblioteca.addLibro(this.analisisw.getTitolo(), this.analisisw);
		this.biblioteca.addLibro(this.basididati.getTitolo(), this.basididati);
		this.biblioteca.addLibro(this.teoriabasidati.getTitolo(), this.teoriabasidati);
		Map<Autore, Set<Libro>> autore2libro = this.biblioteca.autore2Libri();
		assertEquals(3, autore2libro.size());
		assertTrue(autore2libro.containsKey(this.cabibbo));
		assertTrue(autore2libro.containsKey(this.torlone));
		assertTrue(autore2libro.containsKey(this.atzeni));
		assertEquals(2, autore2libro.get(this.cabibbo).size());
		assertEquals(1, autore2libro.get(this.torlone).size());
		assertEquals(2, autore2libro.get(this.atzeni).size());
		assertTrue(autore2libro.get(this.cabibbo).contains(this.fondinf));
		assertTrue(autore2libro.get(this.cabibbo).contains(this.analisisw));
		assertTrue(autore2libro.get(this.torlone).contains(this.basididati));
		assertTrue(autore2libro.get(this.atzeni).contains(this.basididati));
		assertTrue(autore2libro.get(this.atzeni).contains(this.teoriabasidati));
	}
	
	/* Test non richiesti nell'esame, ma fatti per verificare la correttezza del codice */
	
	@Test
	public void testSeleziona_conNessunAutoreGiovane(){
		SelezionatoreAutoriGiovani selezionatore = new SelezionatoreAutoriGiovani();
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(0, autori.size());
	}
	
	@Test
	public void testSeleziona_conUnAutoreGiovane(){
		SelezionatoreAutoriGiovani selezionatore = new SelezionatoreAutoriGiovani();
		this.biblioteca.addLibro(this.analisisw.getTitolo(), this.analisisw);
		this.biblioteca.addLibro(this.graphdrawing.getTitolo(), this.graphdrawing);
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(1, autori.size());
		assertTrue(autori.contains(this.battista));
	}
	
	@Test
	public void testSeleziona_conPiuAutoriGiovaniDiLibriDiversi(){
		SelezionatoreAutoriGiovani selezionatore = new SelezionatoreAutoriGiovani();
		this.biblioteca.addLibro(this.basididati.getTitolo(), this.basididati);
		this.biblioteca.addLibro(this.fondinf.getTitolo(), this.fondinf);
		this.biblioteca.addLibro(this.graphdrawing.getTitolo(), this.graphdrawing);
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(2, autori.size());
		assertTrue(autori.contains(this.battista));
		assertTrue(autori.contains(this.torlone));
	}
	
	@Test
	public void testSeleziona_conPiuAutoriGiovaniDelloStessoLibro(){
		SelezionatoreAutoriGiovani selezionatore = new SelezionatoreAutoriGiovani();
		Libro libro = new Libro("Libro");
		libro.AddAutore(this.torlone);
		libro.AddAutore(this.battista);
		this.biblioteca.addLibro(libro.getTitolo(), libro);
		this.biblioteca.addLibro(this.fondinf.getTitolo(), this.fondinf);
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(2, autori.size());
		assertTrue(autori.contains(this.battista));
		assertTrue(autori.contains(this.torlone));
	}
	
	@Test
	public void testSeleziona_conNessunAutoreProlifico(){
		SelezionatoreAutoriProlifici selezionatore = new SelezionatoreAutoriProlifici();
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(0, autori.size());
	}
	
	
	@Test
	public void testSeleziona_conUnAutoreProlifico(){
		SelezionatoreAutoriProlifici selezionatore = new SelezionatoreAutoriProlifici();
		this.biblioteca.addLibro(this.analisisw.getTitolo(), this.analisisw);
		this.biblioteca.addLibro(this.fondinf.getTitolo(), this.fondinf);
		this.biblioteca.addLibro(this.graphdrawing.getTitolo(), this.graphdrawing);
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(1, autori.size());
		assertTrue(autori.contains(this.cabibbo));
	}
	
	@Test
	public void testSeleziona_conPiuAutoriProlifici(){
		SelezionatoreAutoriProlifici selezionatore = new SelezionatoreAutoriProlifici();
		this.biblioteca.addLibro(this.analisisw.getTitolo(), this.analisisw);
		this.biblioteca.addLibro(this.fondinf.getTitolo(), this.fondinf);
		this.biblioteca.addLibro(this.basididati.getTitolo(), this.basididati);
		this.biblioteca.addLibro(this.graphdrawing.getTitolo(), this.graphdrawing);
		this.biblioteca.addLibro(this.teoriabasidati.getTitolo(), this.teoriabasidati);
		List<Autore> autori = this.biblioteca.seleziona(selezionatore);
		assertEquals(2, autori.size());
		assertEquals(this.atzeni.getNome(), autori.get(0).getNome());
		assertEquals(this.cabibbo.getNome(), autori.get(1).getNome());
	}
	
}
