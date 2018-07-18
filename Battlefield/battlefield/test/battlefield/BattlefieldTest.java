package battlefield;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddRobot() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addRobot(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		Robot r1 = new Walker(new Position(0,0));
		this.field.addRobot(r1);
		Map<Class, Set<Robot>> mappa = this.field.raggruppaRobotPerTipo();
		assertEquals(1, mappa.size());
		Robot r2 = new Chaser(new Position(1,1));
		this.field.addRobot(r2);
		assertEquals(2, mappa.size());
		assertTrue(mappa.get(r1.getClass()).contains(r1));
		assertTrue(mappa.get(r2.getClass()).contains(r2));
	}

}
