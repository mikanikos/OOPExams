import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConsorzioTest {

	private Consorzio consorzio1, consorzio2;
	private Impresa impresa1;
	
	@Before
	public void setUp() throws Exception {
		this.consorzio1 = new Consorzio(1, "ITA", "Con1");
		this.consorzio2 = new Consorzio(2, "FRA", "Con2");
		this.impresa1 = new Impresa(3, "ITA", "Imp1");
	}

	@Test
	public void testGetNumeroDipendenti_ConsorzioVuoto() {
		assertEquals(0, this.consorzio1.getNumeroDipendenti());
	}
	
	@Test
	public void testGetNumeroDipendenti_ConsorzioSingleton() {
		this.consorzio1.aggiungiDipendente(new Dipendente());
		assertEquals(1, this.consorzio1.getNumeroDipendenti());
	}
	
	@Test
	public void testGetNumeroDipendenti_ConsorzioConImpresa() {
		this.impresa1.aggiungiDipendente(new Dipendente());
		this.consorzio1.aggiungiDipendente(new Dipendente());
		this.consorzio1.aggiungiConsorziata(impresa1);
		assertEquals(2, this.consorzio1.getNumeroDipendenti());
	}
	
	@Test
	public void testGetNumeroDipendenti_ConsorzioConConsorzio() {
		this.consorzio2.aggiungiDipendente(new Dipendente());
		this.consorzio1.aggiungiDipendente(new Dipendente());
		this.consorzio1.aggiungiConsorziata(consorzio2);
		assertEquals(2, this.consorzio1.getNumeroDipendenti());
	}
	
	@Test
	public void testNazione2consorziate_ConsorziateVuoto() {
		assertEquals(1, this.consorzio1.nazione2consorziate().size());
		assertSame(this.consorzio1, this.consorzio1.nazione2consorziate().get(consorzio1.getNazione()).get(0));
	}
	
	@Test
	public void testNazione2consorziate_ConsorziateSingletonStessaNazione() {
		this.consorzio1.aggiungiConsorziata(impresa1);
		assertEquals(1, this.consorzio1.nazione2consorziate().size());
		assertSame(this.consorzio1, this.consorzio1.nazione2consorziate().get(consorzio1.getNazione()).get(0));
		assertSame(this.impresa1, this.consorzio1.nazione2consorziate().get(impresa1.getNazione()).get(1));
	}
	
	@Test
	public void testNazione2consorziate_ConsorzioSingletonNazioneDiversa() {
		this.consorzio1.aggiungiConsorziata(consorzio2);
		assertEquals(2, this.consorzio1.nazione2consorziate().size());
		assertSame(this.consorzio1, this.consorzio1.nazione2consorziate().get(consorzio1.getNazione()).get(0));
		assertSame(this.consorzio2, this.consorzio1.nazione2consorziate().get(consorzio2.getNazione()).get(0));
	}
	
	@Test
	public void testNazione2consorziate_ConsorzioOverConsorzio() {
		this.consorzio2.aggiungiConsorziata(impresa1);
		this.consorzio1.aggiungiConsorziata(consorzio2);
		assertEquals(2, this.consorzio1.nazione2consorziate().size());
		assertSame(this.consorzio1, this.consorzio1.nazione2consorziate().get(consorzio1.getNazione()).get(0));
		assertSame(this.impresa1, this.consorzio1.nazione2consorziate().get(impresa1.getNazione()).get(1));
		assertSame(this.consorzio2, this.consorzio1.nazione2consorziate().get(consorzio2.getNazione()).get(0));
	}
	
}
