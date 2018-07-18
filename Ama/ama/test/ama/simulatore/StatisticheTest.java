package ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Mezzo;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Mezzo m = this.simulatore.creaBrowniano();
		final Vetro rifiuto1 = new Vetro(ORIGINE);
		rifiuto1.setRaccoltoDa(m);
		final Vetro rifiuto2 = new Vetro(ORIGINE);
		rifiuto2.setRaccoltoDa(m);
		Set<Rifiuto> smaltiti = new HashSet<>();
		assertEquals(0 , this.stats.raccoltoPerMezzo(smaltiti).size());
		smaltiti.add(creaVetroRaccoltoDaBrowniano());
		assertEquals(1 , this.stats.raccoltoPerMezzo(smaltiti).size());
		smaltiti.add(creaVetroRaccoltoDaChaser());
		assertEquals(2 , this.stats.raccoltoPerMezzo(smaltiti).size());
		smaltiti.add(rifiuto1);
		assertEquals(1 , this.stats.raccoltoPerMezzo(smaltiti).get(m).intValue());
		smaltiti.add(rifiuto2);
		assertEquals(2 , this.stats.raccoltoPerMezzo(smaltiti).get(m).intValue());
	}
	
	@Test
	public void testRaccoltoPerPolitica() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		Mezzo m = this.simulatore.creaBrowniano();
		final Vetro rifiuto1 = new Vetro(ORIGINE);
		rifiuto1.setRaccoltoDa(m);
		final Vetro rifiuto2 = new Vetro(ORIGINE);
		rifiuto2.setRaccoltoDa(m);
		Set<Rifiuto> smaltiti = new HashSet<>();
		assertEquals(0 , this.stats.raccoltoPerPolitica(smaltiti).size());
		smaltiti.add(creaVetroRaccoltoDaBrowniano());
		assertEquals(1 , this.stats.raccoltoPerPolitica(smaltiti).size());
		smaltiti.add(creaVetroRaccoltoDaChaser());
		assertEquals(2 , this.stats.raccoltoPerPolitica(smaltiti).size());
		smaltiti.add(rifiuto2);
		assertEquals(2, this.stats.raccoltoPerPolitica(smaltiti).get(m.getPolitica().getClass()).intValue());
		smaltiti.add(rifiuto1);
		assertEquals(3, this.stats.raccoltoPerPolitica(smaltiti).get(m.getPolitica().getClass()).intValue());
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */
	@Test
	public void testordinaPolitichePerRaccolta() {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		Mezzo brown = this.simulatore.creaBrowniano();
		assertEquals(0, this.stats.ordinaPolitichePerRaccolta(politica2quantita).size());
		politica2quantita.put(brown.getPolitica().getClass(),0);
		assertEquals(1, this.stats.ordinaPolitichePerRaccolta(politica2quantita).size());
		Mezzo chase = this.simulatore.creaChaser();
		politica2quantita.put(chase.getPolitica().getClass(),3);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(politica2quantita).size());
		assertSame(brown.getPolitica().getClass(), this.stats.ordinaPolitichePerRaccolta(politica2quantita).get(1));
		assertSame(chase.getPolitica().getClass(), this.stats.ordinaPolitichePerRaccolta(politica2quantita).get(0));
	}

	@Test
	public void testordinaPolitichePerRaccolta_stessoRaccoltoMaTipoDiverso() {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		Mezzo brown = this.simulatore.creaBrowniano();
		politica2quantita.put(brown.getPolitica().getClass(),0);
		Mezzo chase = this.simulatore.creaChaser();
		politica2quantita.put(chase.getPolitica().getClass(),0);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(politica2quantita).size());
	}

	@Test
	public void testordinaPolitichePerRaccolta_raccoltiDiversi() {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		final Mezzo aSecco = this.simulatore.creaBrowniano();
		final Mezzo prendiTutto = this.simulatore.creaChaser();
		politica2quantita.put(aSecco.getPolitica().getClass(),0); 
		politica2quantita.put(prendiTutto.getPolitica().getClass(),100);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(politica2quantita).size());
		assertSame(prendiTutto.getPolitica().getClass(), this.stats.ordinaPolitichePerRaccolta(politica2quantita).get(0));
		assertSame(aSecco.getPolitica().getClass(), this.stats.ordinaPolitichePerRaccolta(politica2quantita).get(1));
	}
}
