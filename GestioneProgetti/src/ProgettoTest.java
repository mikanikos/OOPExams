import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProgettoTest {
	
	private Attivita att1, att2;
	private Progetto pr1, pr2;

	@Before
	public void setUp() throws Exception {
		this.att1 = new Attivita("attivita1", "responsabile1", 1);
		this.att2 = new Attivita("attivita2", "responsabile2", 2);
		this.pr1 = new Progetto("progetto1", "responsabile1");
		this.pr2 = new Progetto("progetto2", "responsabile3");
		this.pr1.addCompito(att1);
	}

	@Test
	public void testGetCosto_ProgettoSemplice() {
		this.pr1.addCompito(att2);
		assertEquals(3, this.pr1.getCosto());
	}
	
	@Test
	public void testGetCosto_ProgettoComplesso() {
		this.pr2.addCompito(att2);
		this.pr1.addCompito(pr2);
		assertEquals(3, this.pr1.getCosto());
	}
	
	@Test
	public void testResponsabile2compito_ProgettoSemplice() {
		this.pr1.addCompito(att2);
		assertEquals(2, this.pr1.responsabile2compito().size());
		assertSame(this.pr1, this.pr1.responsabile2compito().get(pr1.getResponsabile()).get(1));
		assertSame(this.att1, this.pr1.responsabile2compito().get(att1.getResponsabile()).get(0));
		assertSame(this.att2, this.pr1.responsabile2compito().get(att2.getResponsabile()).get(0));
	}
	
	@Test
	public void testResponsabile2compito_ProgettoComplesso() {
		this.pr2.addCompito(att2);
		this.pr1.addCompito(pr2);
		this.pr1.addCompito(att2);
		assertEquals(3, this.pr1.responsabile2compito().size());
		assertSame(this.pr1, this.pr1.responsabile2compito().get(pr1.getResponsabile()).get(1));
		assertSame(this.att1, this.pr1.responsabile2compito().get(att1.getResponsabile()).get(0));
		assertSame(this.att2, this.pr1.responsabile2compito().get(att2.getResponsabile()).get(0));
		assertSame(this.pr2, this.pr1.responsabile2compito().get(pr2.getResponsabile()).get(0));
		System.out.println(this.pr1.responsabile2compito());
	}

}
