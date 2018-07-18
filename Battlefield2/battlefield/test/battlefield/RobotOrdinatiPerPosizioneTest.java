package battlefield;

import static org.junit.Assert.*;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {

	// (vedi DOMANDA 5)
	// scrivere dei test-case minimali per il metodo
	// Battlefield.getRobotOrdinatiPerPosizione()

	private Battlefield field;
	private Robot r1, r2, r3;

	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
		this.r1 = new Walker(new Position(0,0));
		this.r2 = new Chaser(new Position(1,0));
		this.r3 = new Chaser(new Position(0,1));
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione_CampoVuoto() {
		assertEquals(0, this.field.getAllRobots().size());
		assertEquals(0, this.field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione_Singleton() {
		this.field.addRobot(r1);
		assertEquals(1, this.field.getRobotOrdinatiPerPosizione().size());
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione_DoubletonConXDiversa() {
		this.field.addRobot(r2);
		this.field.addRobot(r1);
		assertEquals(2, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(this.r1, this.field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(this.r2, this.field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione_DoubletonConXUguale() {
		this.field.addRobot(r3);
		this.field.addRobot(r1);
		assertEquals(2, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(this.r1, this.field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(this.r3, this.field.getRobotOrdinatiPerPosizione().get(1));
	}
	
	@Test
	public void testRobotOrdinatiPerPosizione_4Robots() {
		this.field.addRobot(r2);
		this.field.addRobot(r3);
		this.field.addRobot(r1);
		Walker r4 = new Walker(new Position(1,1));
		this.field.addRobot(r4);
		assertEquals(4, this.field.getRobotOrdinatiPerPosizione().size());
		assertSame(this.r1, this.field.getRobotOrdinatiPerPosizione().get(0));
		assertSame(this.r3, this.field.getRobotOrdinatiPerPosizione().get(1));
		assertSame(this.r2, this.field.getRobotOrdinatiPerPosizione().get(2));
		assertSame(r4, this.field.getRobotOrdinatiPerPosizione().get(3));
	}


}
