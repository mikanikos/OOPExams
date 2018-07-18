import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VisualizzatoreTest {

	private VisualizzatoreImmobiliPerSuperficie visSup;
	private Immobile i1, i2;
	private MercatoImmobiliare m;
	
	@Before
	public void setUp() throws Exception {
		this.visSup = new VisualizzatoreImmobiliPerSuperficie();
		this.m = new MercatoImmobiliare();
		this.m.aggiungiVisualizzatore(visSup);
		this.i1 = new Immobile("ind1", 1, 1, 0);
		this.i2 = new Immobile("ind2", 2, 1, 0);
	}

	@Test
	public void testSuperficie2immobili_ListinoVuoto() {
		assertEquals(0, this.visSup.superficie2immobili().size());
	}

	@Test
	public void testSuperficie2immobili_ListinoSingleton() {
		this.m.aggiungiImmobile(i1);
		assertEquals(1, this.visSup.superficie2immobili().size());
	}
	
	@Test
	public void testSuperficie2immobili_ListinoDoubletonSuperficiDiverse() {
		this.m.aggiungiImmobile(i1);
		this.m.aggiungiImmobile(i2);
		assertEquals(2, this.visSup.superficie2immobili().size());
		assertSame(this.i1, this.visSup.superficie2immobili().get(1).get(0));
		assertSame(this.i2, this.visSup.superficie2immobili().get(2).get(0));
	}
	
	@Test
	public void testSuperficie2immobili_ListinoDoubletonSuperficiUguali() {
		this.m.aggiungiImmobile(i1);
		this.i2 = new Immobile("ind2", 1, 0, 0);
		this.m.aggiungiImmobile(i2);
		assertEquals(1, this.visSup.superficie2immobili().size());
		assertSame(this.i1, this.visSup.superficie2immobili().get(1).get(1));
		assertSame(this.i2, this.visSup.superficie2immobili().get(1).get(0));
	}
}
