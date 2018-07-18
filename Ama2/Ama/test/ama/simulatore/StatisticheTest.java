package ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
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
		Set<Rifiuto> insieme = new HashSet<>();
		assertEquals(0, this.stats.raccoltoPerMezzo(insieme).size());
		Rifiuto r1 = creaVetroRaccoltoDaBrowniano();
		insieme.add(r1);
		assertEquals(1, this.stats.raccoltoPerMezzo(insieme).size());
		Rifiuto r2 = creaVetroRaccoltoDaChaser();
		insieme.add(r2);
		assertEquals(2, this.stats.raccoltoPerMezzo(insieme).size());
	}

	
	@Test
	public void testRaccoltoPerPolitica() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		Set<Rifiuto> insieme = new HashSet<>();
		assertEquals(0, this.stats.raccoltoPerPolitica(insieme).size());
		Rifiuto r1 = creaVetroRaccoltoDaBrowniano();
		insieme.add(r1);
		assertEquals(1, this.stats.raccoltoPerPolitica(insieme).size());
		Rifiuto r2 = creaVetroRaccoltoDaChaser();
		insieme.add(r2);
		assertEquals(2, this.stats.raccoltoPerPolitica(insieme).size());
		Rifiuto r3 = creaVetroRaccoltoDaChaser();
		insieme.add(r3);
		assertEquals(2, this.stats.raccoltoPerPolitica(insieme).size());
		assertEquals(2, this.stats.raccoltoPerPolitica(insieme).get(Chase.class).intValue());
		assertEquals(1, this.stats.raccoltoPerPolitica(insieme).get(Brown.class).intValue());
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

	@Test
	public void testOrdinaPolitichePerRaccolta_MappaVuota() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Set<Rifiuto> insieme = new HashSet<>();
		assertEquals(0, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).size());
	}
	
	@Test
	public void testOrdinaPolitichePerRaccolta_MappaSingleton() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Set<Rifiuto> insieme = new HashSet<>();
		Rifiuto r1 = creaVetroRaccoltoDaBrowniano();
		insieme.add(r1);
		assertEquals(1, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).size());
	}
	
	@Test
	public void testOrdinaPolitichePerRaccolta_DoubletonConRaccoltoDiverso() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Set<Rifiuto> insieme = new HashSet<>();
		Rifiuto r1 = creaVetroRaccoltoDaBrowniano();
		insieme.add(r1);
		Rifiuto r2 = creaVetroRaccoltoDaChaser();
		insieme.add(r2);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).size());
		assertSame(Brown.class, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).get(0));
		assertSame(Chase.class, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).get(1));
	}
	
	@Test
	public void testOrdinaPolitichePerRaccolta_DoubletonConRaccoltoUguale() {
		/* DA COMPLETARE VEDI DOMANDA 3 */
		Set<Rifiuto> insieme = new HashSet<>();
		Rifiuto r1 = creaVetroRaccoltoDaBrowniano();
		insieme.add(r1);
		Rifiuto r2 = creaVetroRaccoltoDaChaser();
		insieme.add(r2);
		Rifiuto r3 = creaVetroRaccoltoDaChaser();
		insieme.add(r3);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).size());
		assertSame(Brown.class, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).get(1));
		assertSame(Chase.class, this.stats.ordinaPolitichePerRaccolta(this.stats.raccoltoPerPolitica(insieme)).get(0));
	}
}
